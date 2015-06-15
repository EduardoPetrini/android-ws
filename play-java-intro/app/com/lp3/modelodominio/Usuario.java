/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lp3.modelodominio;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

/**
 *
 * @author Mariana
 */
@Entity
public class Usuario extends Model {
	@Id
    public int id;
    public int idApp;
    public String nome;
    @ManyToOne(cascade = CascadeType.REFRESH)
    public GrupoUsuario grupoUsuario;

    public Usuario (){
 
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdApp() {
        return idApp;
    }

    public void setIdApp(int idApp) {
        this.idApp = idApp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    public GrupoUsuario getGrupoUsuario() {
        return grupoUsuario;
    }

    public void setGrupoUsuario(GrupoUsuario grupo_usuario) {
        this.grupoUsuario = grupo_usuario;
    }
    
}
