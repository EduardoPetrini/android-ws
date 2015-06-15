package dao;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

import com.lp3.modelodominio.Parametro;

public class ParametroDao {

	public static Finder<Integer, Parametro> find = new Model.Finder<>(Integer.class, Parametro.class);
}
