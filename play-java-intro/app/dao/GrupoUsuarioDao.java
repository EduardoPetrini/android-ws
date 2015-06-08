package dao;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

import com.lp3.GrupoUsuarioApi;

public class GrupoUsuarioDao {

	public static Finder<Integer, GrupoUsuarioApi> find = new Model.Finder<>(Integer.class, GrupoUsuarioApi.class);
}
