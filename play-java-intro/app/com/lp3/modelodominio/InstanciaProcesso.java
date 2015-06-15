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
public class InstanciaProcesso {
    private int id;
    private String idBpms;
    private Processo processo;
    private List<InstanciaAtividade> instanciasAtividade;
     
    public InstanciaProcesso(){
        this.processo = new Processo();
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
    
     public Processo getProcesso() {
        return processo;
    }

    public void setProcesso(Processo processo) {
        this.processo = processo;
    }

	public List<InstanciaAtividade> getInstanciasAtividade() {
		return instanciasAtividade;
	}

	public void setInstanciasAtividade(List<InstanciaAtividade> instanciasAtividade) {
		this.instanciasAtividade = instanciasAtividade;
	}
}
