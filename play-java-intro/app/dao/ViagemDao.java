package dao;

import java.util.List;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

import com.lp3.Viagem;

public class ViagemDao {
public static Finder<Integer, Viagem> find = new Model.Finder<>(Integer.class, Viagem.class);
	
	public static List<Viagem> findByUser(Integer userId) {
        return find.where()
            .eq("usuarios.id", userId)
            .findList();
    }
}
