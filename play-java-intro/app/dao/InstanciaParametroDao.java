package dao;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

import com.lp3.modelodominio.InstanciaParametro;

public class InstanciaParametroDao {

	public static Finder<Integer, InstanciaParametro> find = new Model.Finder<>(Integer.class, InstanciaParametro.class);
}
