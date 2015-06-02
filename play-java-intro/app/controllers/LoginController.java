package controllers;

import models.Usuario;
import play.mvc.Controller;
import play.mvc.Result;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class LoginController extends Controller {

	public static Result login() {

		JsonNode json = request().body().asJson();
		
		ObjectNode result = play.libs.Json.newObject();
		result.put("status", "OK");
		
		String email = json.get("email").asText();
		String senha = json.get("senha").asText();
		
		Usuario usuario = Usuario.find.where().eq("email", email).findUnique();
		
		if(usuario != null){
			if(usuario.senha.equals(senha)){
				result.put("Mensagem", "Bem vindo "+usuario.nome);
				result.put("usuario", play.libs.Json.toJson(usuario));
			}else{
				result.put("erro", "A senha não confere!");
			}
		}else{
			result.put("erro", "Não existe usuário com este email!");
		}
		
		return ok(result);
    }
}
