package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lp3.UsuarioApp;

import dao.UsuarioDao;

public class LoginController extends Controller {

	public static Result login() {

		JsonNode json = request().body().asJson();
		
		ObjectNode result = play.libs.Json.newObject();
		result.put("status", "OK");
		
		String email = json.get("email").asText();
		String senha = json.get("senha").asText();
		
		UsuarioApp usuarioApp = UsuarioDao.find.where().eq("email", email).findUnique();
		usuarioApp.print();
		if(usuarioApp != null){
			if(usuarioApp.senha.equals(senha)){
				result.put("Mensagem", "Bem vindo "+usuarioApp.nome);
				result.put("usuario", play.libs.Json.toJson(usuarioApp));
			}else{
				result.put("erro", "A senha não confere!");
			}
		}else{
			result.put("erro", "Não existe usuário com este email!");
		}
		
		return ok(result);
    }
}
