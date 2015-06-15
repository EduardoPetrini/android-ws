/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lp3.modelodominio;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

/**
 *
 * @author Mariana
 */

@Entity
public class Parametro extends Model{
	@Id
    private int id;
    private String idBpms;
    private String nome;
    
    public Parametro (){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getIdBpms() {
        return idBpms;
    }

    public void setIdBpms(String id_bpms) {
        this.idBpms = id_bpms;
    }
}
