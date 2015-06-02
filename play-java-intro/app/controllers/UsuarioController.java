package controllers;

import java.util.List;

import models.Usuario;
import models.Viagem;
import play.mvc.BodyParser;
import play.mvc.BodyParser.Json;
import play.mvc.Controller;
import play.mvc.Result;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class UsuarioController extends Controller {

	@BodyParser.Of(Json.class)
	public static Result cadastrar(){
		JsonNode json = request().body().asJson();
		System.out.println(json);
		
		Usuario user = new Usuario();
		user.nome = json.get("nome").asText();
		user.email = json.get("email").asText();
		user.senha = json.get("senha").asText();
		user.cargo = json.get("cargo").asText();
		user.id_aplicacao =0;
		
		user.save();
		
		ObjectNode result = play.libs.Json.newObject();
		result.put("status", "OK");
	    result.put("message", "Hello " + user.nome);
	    result.put("usuario", play.libs.Json.toJson(user));
		return ok(result);
		
    }
	
	public static Result getAll(){
		ObjectNode result = play.libs.Json.newObject();
		
		List<Usuario> users = Usuario.find.all();
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
		
		Usuario usuario = Usuario.find.byId(id);
		if(usuario != null){
			result.put("Usuario", play.libs.Json.toJson(usuario));
		}else{
			result.put("Mensagem: ","Não há usuario para esse id");
		}
		return ok(result);
	}
}
