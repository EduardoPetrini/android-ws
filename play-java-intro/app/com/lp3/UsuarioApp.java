package com.lp3;

import javax.persistence.Entity;

import com.lp3.modelodominio.Usuario;

@Entity
public class UsuarioApp extends Usuario{

	public String email;
	public String senha;
	
	public void print(){
		System.out.println("id: "+id);
		System.out.println("Nome: "+nome);
		System.out.println("Email: "+email);
		System.out.println("Senha: "+senha);
		System.out.println("GrupoUsuario: "+grupoUsuario.nome);
		System.out.println("GrupoUsuario idBpms: "+grupoUsuario.idBpms);
	}

}
