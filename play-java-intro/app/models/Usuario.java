package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class Usuario extends Model{

	@Id
	public Integer id;

	public String nome;
	public String email;
	public String senha;
	public String cargo;	

	public static Finder<Integer, Usuario> find = new Model.Finder<>(Integer.class, Usuario.class);
}
