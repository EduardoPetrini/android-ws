package controllers;

import java.util.ArrayList;
import java.util.Date;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import com.lp3.AtividadeApi;
import com.lp3.GrupoUsuarioApi;
import com.lp3.ParametroApi;
import com.lp3.Usuario;
import com.lp3.Viagem;

import dao.AtividadeDao;
import dao.GrupoUsuarioDao;
import dao.UsuarioDao;
import dao.ViagemDao;

public class Application extends Controller {

    public static Result index() {
    	GrupoUsuarioApi gp = GrupoUsuarioDao.find.where().eq("idBpms", "1").findUnique();
    	if(gp == null){
    		gp = new GrupoUsuarioApi();
    		gp.idBpms = "1";
    		gp.nome = "AUTORIZADOR";
    		gp.save();
    	}
    	
    	gp = GrupoUsuarioDao.find.where().eq("idBpms", "2").findUnique();
    	if(gp == null){
    		gp = new GrupoUsuarioApi();
    		gp.idBpms = "2";
    		gp.nome = "MOTORISTA";
    		gp.save();
    	}
    	
    	gp = GrupoUsuarioDao.find.where().eq("idBpms", "3").findUnique();
    	if(gp == null){
    		gp = new GrupoUsuarioApi();
    		gp.idBpms = "3";
    		gp.nome = "SOLICITANTE";
    		gp.save();
    	}
    	
    	gp = GrupoUsuarioDao.find.where().eq("idBpms", "4").findUnique();
    	if(gp == null){
    		gp = new GrupoUsuarioApi();
    		gp.idBpms = "4";
    		gp.nome = "TRANSPORTADOR";
    		gp.save();
    	}
    	
    	Usuario user = UsuarioDao.find.where().eq("nome", "aut").findUnique();
    	if(user == null){
    		user = new Usuario();
    		user.nome = "aut";
    		user.email = "aut@email";
    		user.senha = "qwe";
    		user.grupoUsuario = GrupoUsuarioDao.find.where().eq("idBpms", "1").findUnique();
    		user.save();
    	}
    	
    	user = UsuarioDao.find.where().eq("nome", "mot").findUnique();
    	if(user == null){
    		user = new Usuario();
    		user.nome = "mot";
    		user.email = "mot@email";
    		user.senha = "qwe";
    		user.grupoUsuario = GrupoUsuarioDao.find.where().eq("idBpms", "2").findUnique();
    		user.save();
    	}
    	
    	user = UsuarioDao.find.where().eq("nome", "sol").findUnique();
    	if(user == null){
    		user = new Usuario();
    		user.nome = "sol";
    		user.email = "sol@email";
    		user.senha = "qwe";
    		user.grupoUsuario = GrupoUsuarioDao.find.where().eq("idBpms", "3").findUnique();
    		user.save();
    	}
    	
    	user = UsuarioDao.find.where().eq("nome", "tra").findUnique();
    	if(user == null){
    		user = new Usuario();
    		user.nome = "tra";
    		user.email = "tra@email";
    		user.senha = "qwe";
    		user.grupoUsuario = GrupoUsuarioDao.find.where().eq("idBpms", "4").findUnique();
    		user.save();
    	}
    	
    	Viagem viagem = ViagemDao.find.where().eq("status", "CRIADA").findUnique();
    	if(viagem == null){
    		viagem = new Viagem();
    		viagem.status = "CRIADA";
    		viagem.titulo = "Passeio na UFLA";
    		viagem.dataPartida = new Date(System.currentTimeMillis());
    		viagem.dataChegada = new Date(System.currentTimeMillis()+200000);
    		viagem.cidadeOrigem = "Ijací, MG";
    		viagem.cidadeDestino = "Lavras, MG";
    		viagem.qtdePessoas = 12;
    		viagem.save();
    	}
    	
    	AtividadeApi atv = AtividadeDao.find.where().eq("idBpms", "1").findUnique();
    	if(atv == null){
    		atv = new AtividadeApi();
    		atv.idBpms = "1";
    		atv.nome = "ORÇAMENTO";
    		atv.grupoUsuario = GrupoUsuarioDao.find.where().eq("idBpms", "3").findUnique();
    		ParametroApi p = new ParametroApi();
    		p.idBpms = "1";
    		p.nome = "com.lp3.Viagem";
    		p.valor = String.valueOf(viagem.id);
    		p.save();
    		atv.parametros = new ArrayList<ParametroApi>();
    		atv.parametros.add(p);
    		atv.save();
    	}
    	
        return ok(index.render());
    }
}
