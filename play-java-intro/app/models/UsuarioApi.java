/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;
/**
 *
 * @author Mariana
 */
@Entity
public class UsuarioApi extends Model {
	@Id
    public int id;
    public int id_aplicacao;
    public String nome;
    //private GrupoUsuario grupo_usuario;
   
}
