/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lp3.modelodominio;


/**
 *
 * @author Mariana
 */
public class InstanciaParametro {
    private int id;
    private String idBpms;
    private String valor;
    private Parametro parametro;
    private String tipo;
    
    public InstanciaParametro(){
    }    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    public Parametro getParametro() {
        return parametro;
    }

    public void setParametro(Parametro parametro) {
        this.parametro = parametro;
    }

	public String getIdBpms() {
		return idBpms;
	}

	public void setIdBpms(String idBpms) {
		this.idBpms = idBpms;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
