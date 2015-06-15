package dao;

import java.util.List;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

import com.lp3.modelodominio.InstanciaAtividade;

public class InstanciaAtividadeDao {

	public static Finder<Integer, InstanciaAtividade> find = new Model.Finder<>(Integer.class, InstanciaAtividade.class);
	public static List<InstanciaAtividade> findByGroup(String groupId) {
        return find.where()
            .eq("grupoUsuario.idBpms", groupId)
            .findList();
    }
}
