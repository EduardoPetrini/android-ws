package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Usuario extends Model{

	@Id
	public String id;

	public String nome;
	public String email;
	public String senha;
	public String cargo;	
	
}
