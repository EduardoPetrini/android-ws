package dao;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

import com.lp3.Usuario;

public class UsuarioDao {

	public static Finder<Integer, Usuario> find = new Model.Finder<>(Integer.class, Usuario.class);
}
