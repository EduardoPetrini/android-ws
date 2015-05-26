package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Viagem extends Model{

	@Id
	public String id;

	public String titulo;
	public Date dataPartida;
	public Date dataChegada;
	public String cidadeOrigem;
	public String cidadeDestino;
	public int qtdePessoas;
	public double custoOrçado;
	public double custoReal;
	
}
