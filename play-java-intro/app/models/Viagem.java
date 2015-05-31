package models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import play.db.ebean.Model;

@Entity
public class Viagem extends Model{

	@Id
	public Integer id;
	public String status;
	public String titulo;
	public Date dataPartida;
	public Date dataChegada;
	public String cidadeOrigem;
	public String cidadeDestino;
	public int qtdePessoas;
	public double custoOrcado;
	public double custoReal;
	@ManyToMany(cascade = CascadeType.REFRESH)
	public List<Usuario> usuarios;
		
	public static Finder<Integer, Viagem> find = new Model.Finder<>(Integer.class, Viagem.class);
	
	public static List<Viagem> findByUser(Integer userId) {
        return find.where()
            .eq("usuarios.id", userId)
            .findList();
    }
}
