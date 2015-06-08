/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lp3;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

/**
 *
 * @author Eduardo
 */
@Entity
public class AtividadeApi extends Model {
	@Id
    public int id;
    public String nome;
    public String idBpms; 
    public GrupoUsuarioApi grupoUsuario;
    public ArrayList<ParametroApi> parametros;

}
