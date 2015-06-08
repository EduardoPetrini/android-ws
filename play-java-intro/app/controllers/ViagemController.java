package controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import play.mvc.BodyParser;
import play.mvc.BodyParser.Json;
import play.mvc.Controller;
import play.mvc.Result;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lp3.Usuario;
import com.lp3.Viagem;

import dao.UsuarioDao;
import dao.ViagemDao;

public class ViagemController extends Controller {

	@BodyParser.Of(Json.class)
	public static Result cadastrar(){
		JsonNode json = request().body().asJson();
		
		Viagem viagem = new Viagem();
		viagem.titulo = json.get("titulo").asText();
		viagem.status = "CRIADA";
		viagem.dataPartida = textToDate(json.get("dataPartida").asText());
		viagem.dataChegada = textToDate(json.get("dataChegada").asText());
		viagem.cidadeOrigem = json.get("origem").asText();
		viagem.cidadeDestino = json.get("destino").asText();
		viagem.qtdePessoas = json.get("qtdePessoas").asInt();
		viagem.custoOrcado = 0;
		viagem.custoReal= 0;
		Integer userId = json.get("usuarioId").asInt();
		Usuario user = UsuarioDao.find.byId(userId);
		viagem.usuarios = new ArrayList<Usuario>();
		viagem.usuarios.add(user);
		
		viagem.save();
		
		ObjectNode result = play.libs.Json.newObject();
		result.put("status", "OK");
	    result.put("message", "Viagem " + viagem.titulo+" cadastrada com sucesso");
	    result.put("viagem", play.libs.Json.toJson(viagem));
		return ok(result);
		
    }

	private static Date textToDate(String data) {
		System.out.println(data);
		String[] dataHora = data.split(" ");
		
		String[] d = dataHora[0].split("/");
		String[] h = dataHora[1].split(":");
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, Integer.parseInt(d[0]));
		calendar.set(Calendar.MONTH, Integer.parseInt(d[1]));
		calendar.set(Calendar.YEAR, Integer.parseInt(d[2]));
		calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(h[0]));
		calendar.set(Calendar.MINUTE, Integer.parseInt(h[1]));
		
		return calendar.getTime();
	}
	
	public static Result getAll(){
		ObjectNode result = play.libs.Json.newObject();
		
		List<Viagem> viagem = ViagemDao.find.all();
		if(viagem.size() > 0){
			result.put("Qtde Viagens", viagem.size());
			result.put("Viagens", play.libs.Json.toJson(viagem));
		}else{
			result.put("Mensagem: ","Não há viagens salvas");
		}
		return ok(result);
	}
	
	public static Result getByUser(Integer userId){
		ObjectNode result = play.libs.Json.newObject();
		
		List<Viagem> viagem = ViagemDao.findByUser(userId);
		if(viagem.size() > 0){
			result.put("Qtde Viagens", viagem.size());
			result.put("Viagens", play.libs.Json.toJson(viagem));
		}else{
			result.put("Mensagem: ","Não há viagens para esse usuario");
		}
		return ok(result);
	}
	
	public static Result get(Integer id){
		ObjectNode result = play.libs.Json.newObject();
		
		Viagem viagem = ViagemDao.find.byId(id);
		if(viagem != null){
			result.put("Viagem", play.libs.Json.toJson(viagem));
		}else{
			result.put("Mensagem: ","Não há viagem para esse id");
		}
		return ok(result);
	}
	
	public static Result orcar(){
		JsonNode json = request().body().asJson();
		ObjectNode result = play.libs.Json.newObject();
		
		Viagem viagem = ViagemDao.find.byId(json.get("id").asInt());
		double valorOrcado = Double.parseDouble(json.get("custoOrcado").asText());
		if(viagem != null){
			viagem.custoOrcado = valorOrcado;
			viagem.update();
			result.put("Mensagem", "Orçamento cadastrado com sucesso!");
			result.put("Viagem", play.libs.Json.toJson(viagem));
		}else{
			result.put("Mensagem: ","Não há viagem para esse id");
		}
		
		return ok(result);
	}
}
