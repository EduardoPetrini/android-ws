package dao;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

import com.lp3.UsuarioApp;

public class UsuarioDao {

	public static Finder<Integer, UsuarioApp> find = new Model.Finder<>(Integer.class, UsuarioApp.class);
}
