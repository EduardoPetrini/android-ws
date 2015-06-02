package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Usuario extends UsuarioApi{

	@Id
	public Integer id;

	public String email;
	public String senha;
	public String cargo;	

	public static Finder<Integer, Usuario> find = new Model.Finder<>(Integer.class, Usuario.class);
}
