package controllers;

import java.util.Map;

import play.data.DynamicForm;
import play.data.Form;
import play.mvc.BodyParser;
import play.mvc.BodyParser.Json;
import play.mvc.Controller;
import play.mvc.Result;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class UsuarioController extends Controller {

	@BodyParser.Of(Json.class)
	public static Result cadastrar(){
		DynamicForm requestData = Form.form().bindFromRequest();
		Map<String, String> nomeRequestMap = requestData.data();
		String nome = nomeRequestMap.get("nome");
		
		 JsonNode json = request().body().asJson();
		 System.out.println(json);
		 System.out.println(nomeRequestMap);
		
		System.out.println(nome);
		ObjectNode result = play.libs.Json.newObject();
//		play.libs.Json.toJson(arg0);
		result.put("status", "OK");
	    result.put("message", "Hello " + nome);
		return ok(result);
		
    }
}
