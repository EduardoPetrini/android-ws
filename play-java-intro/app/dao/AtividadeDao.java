package dao;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

import com.lp3.AtividadeApi;
import com.lp3.GrupoUsuarioApi;
import com.lp3.Usuario;

public class AtividadeDao {

	public static Finder<Integer, AtividadeApi> find = new Model.Finder<>(Integer.class, AtividadeApi.class);
}
