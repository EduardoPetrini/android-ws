package controllers;

import java.util.List;

import play.mvc.BodyParser;
import play.mvc.BodyParser.Json;
import play.mvc.Controller;
import play.mvc.Result;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lp3.Atividade;
import com.lp3.GrupoUsuarioApi;
import com.lp3.Usuario;

import dao.AtividadeDao;
import dao.GrupoUsuarioDao;
import dao.UsuarioDao;

public class UsuarioController extends Controller {

	@BodyParser.Of(Json.class)
	public static Result cadastrar(){
		JsonNode json = request().body().asJson();
		System.out.println(json);
		
		Usuario user = new Usuario();
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
	
	private static GrupoUsuarioApi getGrupoUsuarioByCargo(String cargo) {
		return GrupoUsuarioDao.find.where().eq("nome",cargo).findUnique(); 
	}

	public static Result getAll(){
		ObjectNode result = play.libs.Json.newObject();
		
		List<Usuario> users = UsuarioDao.find.all();
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
		
		Usuario usuario = UsuarioDao.find.byId(id);
		if(usuario != null){
			result.put("Usuario", play.libs.Json.toJson(usuario));
		}else{
			result.put("Mensagem: ","Não há usuario para esse id");
		}
		return ok(result);
	}
	
	public static Result getAtividades(Integer id){
		ObjectNode result = play.libs.Json.newObject();
		
		Usuario usuario = UsuarioDao.find.byId(id);
		System.out.println("Obtendo as atividades do usuário: ");
		usuario.print();
		if(usuario != null){
			if(usuario.grupoUsuario != null){
				
				List<Atividade> atividades = AtividadeDao.findByGroup(usuario.grupoUsuario.idBpms);
				if(atividades != null && atividades.size() > 0){
					
					for(Atividade a: atividades){
						a.print();
						System.out.println();
					}
					result.put("atividades", play.libs.Json.toJson(atividades));
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
