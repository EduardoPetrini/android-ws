package controllers;

import java.util.Date;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import com.lp3.UsuarioApp;
import com.lp3.Viagem;
import com.lp3.modelodominio.Atividade;
import com.lp3.modelodominio.GrupoUsuario;
import com.lp3.modelodominio.InstanciaAtividade;
import com.lp3.modelodominio.InstanciaParametro;
import com.lp3.modelodominio.Parametro;

import dao.AtividadeDao;
import dao.GrupoUsuarioDao;
import dao.InstanciaAtividadeDao;
import dao.InstanciaParametroDao;
import dao.ParametroDao;
import dao.UsuarioDao;
import dao.ViagemDao;

public class Application extends Controller {

    public static Result index() {
    	GrupoUsuario gp = GrupoUsuarioDao.find.where().eq("idBpms", "1").findUnique();
    	if(gp == null){
    		gp = new GrupoUsuario();
    		gp.idBpms = "1";
    		gp.nome = "AUTORIZADOR";
    		gp.save();
    	}
    	
    	gp = GrupoUsuarioDao.find.where().eq("idBpms", "2").findUnique();
    	if(gp == null){
    		gp = new GrupoUsuario();
    		gp.idBpms = "2";
    		gp.nome = "MOTORISTA";
    		gp.save();
    	}
    	
    	gp = GrupoUsuarioDao.find.where().eq("idBpms", "3").findUnique();
    	if(gp == null){
    		gp = new GrupoUsuario();
    		gp.idBpms = "3";
    		gp.nome = "SOLICITANTE";
    		gp.save();
    	}
    	
    	gp = GrupoUsuarioDao.find.where().eq("idBpms", "4").findUnique();
    	if(gp == null){
    		gp = new GrupoUsuario();
    		gp.idBpms = "4";
    		gp.nome = "TRANSPORTADOR";
    		gp.save();
    	}
    	
    	UsuarioApp user = UsuarioDao.find.where().eq("nome", "aut").findUnique();
    	if(user == null){
    		user = new UsuarioApp();
    		user.nome = "aut";
    		user.email = "aut@email";
    		user.senha = "qwe";
    		user.grupoUsuario = GrupoUsuarioDao.find.where().eq("idBpms", "1").findUnique();
    		user.save();
    	}
    	
    	user = UsuarioDao.find.where().eq("nome", "mot").findUnique();
    	if(user == null){
    		user = new UsuarioApp();
    		user.nome = "mot";
    		user.email = "mot@email";
    		user.senha = "qwe";
    		user.grupoUsuario = GrupoUsuarioDao.find.where().eq("idBpms", "2").findUnique();
    		user.save();
    	}
    	
    	user = UsuarioDao.find.where().eq("nome", "sol").findUnique();
    	if(user == null){
    		user = new UsuarioApp();
    		user.nome = "sol";
    		user.email = "sol@email";
    		user.senha = "qwe";
    		user.grupoUsuario = GrupoUsuarioDao.find.where().eq("idBpms", "3").findUnique();
    		user.save();
    	}
    	
    	user = UsuarioDao.find.where().eq("nome", "tra").findUnique();
    	if(user == null){
    		user = new UsuarioApp();
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
    	
//    	Parametro parametro = ParametroDao.find.where().eq("idBpms", "").findUnique();
//    	InstanciaParametro instParametro = InstanciaParametroDao.find.where().eq("idBpms","").findUnique();
//    	Atividade atividade = AtividadeDao.find.where().eq("idBpms", "").findUnique();
//    	InstanciaAtividade atv = InstanciaAtividadeDao.find.where().eq("idBpms", "").findUnique();
    	
    	
        return ok(index.render());
    }
}
