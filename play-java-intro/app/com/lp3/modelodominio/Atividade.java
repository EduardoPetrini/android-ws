/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lp3.modelodominio;

import java.util.List;


/**
 *
 * @author Mariana
 */
public class Atividade {
    private int id;
    private String nome;
    private String idBpms;
    private GrupoUsuario grupoUsuario;
    private List<Parametro> parametrosEntrada;
    private List<Parametro> parametrosSaida;
    
    public Atividade (){}
    
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

    public GrupoUsuario getGrupoUsuario() {
        return grupoUsuario;
    }

    public void setGrupoUsuario(GrupoUsuario grupo_usuario) {
        this.grupoUsuario = grupo_usuario;
    }

	public List<Parametro> getParametrosEntrada() {
		return parametrosEntrada;
	}

	public void setParametrosEntrada(List<Parametro> parametrosEntrada) {
		this.parametrosEntrada = parametrosEntrada;
	}

	public List<Parametro> getParametrosSaida() {
		return parametrosSaida;
	}

	public void setParametrosSaida(List<Parametro> parametrosSaida) {
		this.parametrosSaida = parametrosSaida;
	}
}
