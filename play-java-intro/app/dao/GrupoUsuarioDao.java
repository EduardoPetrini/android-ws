package dao;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

import com.lp3.modelodominio.GrupoUsuario;

public class GrupoUsuarioDao {

	public static Finder<Integer, GrupoUsuario> find = new Model.Finder<>(Integer.class, GrupoUsuario.class);
}
