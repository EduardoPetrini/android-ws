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
public class Processo implements IEntidade {
	private int id;
	private String idBpms;
	private String nome;
	private List<Atividade> atividades;

	public Processo() {
	}

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

	public void setIdBpms(String idBpms) {
		this.idBpms = idBpms;
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}
}
