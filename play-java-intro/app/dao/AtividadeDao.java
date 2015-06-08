package dao;

import java.util.List;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

import com.lp3.Atividade;
import com.lp3.Viagem;

public class AtividadeDao {

	public static Finder<Integer, Atividade> find = new Model.Finder<>(Integer.class, Atividade.class);
	public static List<Atividade> findByGroup(String groupId) {
        return find.where()
            .eq("grupoUsuario.idBpms", groupId)
            .findList();
    }
}
