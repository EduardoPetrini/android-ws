/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lp3;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

/**
 *
 * @author Eduardo
 */
@Entity
public class GrupoUsuarioApi extends Model {
	@Id
    public String id;
    public String idBpms;
    public String nome;
}
