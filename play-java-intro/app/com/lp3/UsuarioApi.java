/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lp3;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;
/**
 *
 * @author Eduardo
 */
@Entity
public class UsuarioApi extends Model {
	@Id
    public int id;
    public int idAplicacao;
    public String nome;
    @ManyToOne(cascade = CascadeType.REFRESH)
    public GrupoUsuarioApi grupoUsuario;
}
