package com.lp3;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

/**
 * Created by Danilo on 02/06/2015.
 */
@Entity
public class Parametros extends Model {
	@Id
	public int id;
    public String entityNome;
    public String entityId;
}
