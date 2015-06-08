package com.lp3;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import play.db.ebean.Model;

/**
 * Created by Danilo on 02/06/2015.
 */
@Entity
public class Atividade extends Model{
	@Id
	public int id;
    public String nome;
    @OneToOne
    public GrupoUsuarioApi grupoUsuario;
    @OneToOne(cascade = CascadeType.ALL)
    public Parametros parametros;
    
    public void print(){
    	System.out.println("Id: "+id);
    	System.out.println("Nome: "+nome);
    	System.out.println("GrupoUsuario: "+grupoUsuario.nome);
    	System.out.println("Parametro Nome: "+parametros.entityNome);
    	System.out.println("Parametro id: "+parametros.entityId);
    }
}
