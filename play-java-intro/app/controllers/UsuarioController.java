package controllers;

import java.util.List;

import play.mvc.BodyParser;
import play.mvc.BodyParser.Json;
import play.mvc.Controller;
import play.mvc.Result;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lp3.UsuarioApp;
import com.lp3.modelodominio.GrupoUsuario;
import com.lp3.modelodominio.InstanciaAtividade;
import com.lp3.modelodominio.InstanciaParametro;
import com.lp3.modelodominio.Parametro;

import dao.GrupoUsuarioDao;
import dao.InstanciaAtividadeDao;
import dao.UsuarioDao;

public class UsuarioController extends Controller {

	@BodyParser.Of(Json.class)
	public static Result cadastrar(){
		JsonNode json = request().body().asJson();
		System.out.println(json);
		
		UsuarioApp user = new UsuarioApp();
		user.nome = json.get("nome").asText();
		user.email = json.get("email").asText();
		user.senha = json.get("senha").asText();
		String cargo = json.get("cargo").asText();
		user.grupoUsuario = getGrupoUsuarioByCargo(cargo.toUpperCase());
		
		user.save();
		
		ObjectNode result = play.libs.Json.newObject();
		result.put("status", "OK");
	    result.put("message", "Hello " + user.nome);
	    result.put("usuario", play.libs.Json.toJson(user));
		return ok(result);
		
    }
	
	private static GrupoUsuario getGrupoUsuarioByCargo(String cargo) {
		return GrupoUsuarioDao.find.where().eq("nome",cargo).findUnique(); 
	}

	public static Result getAll(){
		ObjectNode result = play.libs.Json.newObject();
		
		List<UsuarioApp> users = UsuarioDao.find.all();
		if(users.size() > 0){
			result.put("Qtde Usuarios", users.size());
			result.put("Usuarios", play.libs.Json.toJson(users));
		}else{
			result.put("Mensagem: ","Não há usuários salvos");
		}
		return ok(result);
	}
	
	public static Result get(Integer id){
		ObjectNode result = play.libs.Json.newObject();
		
		UsuarioApp usuarioApp = UsuarioDao.find.byId(id);
		if(usuarioApp != null){
			result.put("UsuarioApp", play.libs.Json.toJson(usuarioApp));
		}else{
			result.put("Mensagem: ","Não há usuario para esse id");
		}
		return ok(result);
	}
	
	public static Result getAtividades(Integer id){
		ObjectNode result = play.libs.Json.newObject();
		
		UsuarioApp usuarioApp = UsuarioDao.find.byId(id);
		System.out.println("Obtendo as atividades do usuário: ");
		usuarioApp.print();
		if(usuarioApp != null){
			if(usuarioApp.grupoUsuario != null){
				
				List<InstanciaAtividade> atividades = InstanciaAtividadeDao.find.where().eq("usuario.id",usuarioApp.getId()).findList();
				if(atividades != null && atividades.size() > 0){
					//Passar somente o que interessa para o android
					ArrayNode atividadesJson = new ObjectMapper().createArrayNode();
					ObjectNode paramJson;
					ObjectNode atvJson;
					
					for(InstanciaAtividade instAtv: atividades){
						atvJson = play.libs.Json.newObject();
						atvJson.put("nome",instAtv.getAtividade().getNome());
						for(InstanciaParametro p: instAtv.getInstanciasParametrosEntrada()){
							paramJson = play.libs.Json.newObject();
							paramJson.put("entityId", p.getValor());
							paramJson.put("entityNome", p.getParametro().getNome());
							atvJson.put("parametros", paramJson);
						}
						atividadesJson.add(atvJson);
					}
					result.put("atividades", atividadesJson);
				}else{
					result.put("erro","Não há atividades para esse usuário.");
				}
				
			}else{
				result.put("erro","Usuário não possui grupo.");
			}
			
		}else{
			result.put("erro","Não há usuario para esse id: "+id);
		}
		return ok(result);
	}
}
