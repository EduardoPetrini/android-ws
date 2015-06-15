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
public class InstanciaAtividade {
    private int id;
    private String idBpms;
    private Atividade atividade;
    private Usuario usuario;
    private List<InstanciaParametro> instanciasParametrosEntrada;
    private List<InstanciaParametro> instanciasParametrosSaida;
    
    public InstanciaAtividade()
    {
        /*this.atividade = new Atividade();
        this.usuario = new UsuarioApp();
        this.instancia_processo = new InstanciaProcesso();*/
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public String getIdBpms() {
		return idBpms;
	}

	public void setIdBpms(String id_bpms) {
		this.idBpms = id_bpms;
	}

	public List<InstanciaParametro> getInstanciasParametrosEntrada() {
		return instanciasParametrosEntrada;
	}

	public void setInstanciasParametrosEntrada(
			List<InstanciaParametro> instanciasParametrosEntrada) {
		this.instanciasParametrosEntrada = instanciasParametrosEntrada;
	}

	public List<InstanciaParametro> getInstanciasParametrosSaida() {
		return instanciasParametrosSaida;
	}

	public void setInstanciasParametrosSaida(
			List<InstanciaParametro> instanciasParametrosSaida) {
		this.instanciasParametrosSaida = instanciasParametrosSaida;
	}
}
