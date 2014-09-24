package com.macaxeira.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="_id")
	private int id;

	private Timestamp dataUpdate;

	private byte del;

	@Lob
	private String login;

	@Lob
	private String senha;

	//bi-directional many-to-one association to Atendente
	@OneToMany(mappedBy="usuario")
	private List<Atendente> atendentes;

	//bi-directional many-to-one association to Cozinheiro
	@OneToMany(mappedBy="usuario")
	private List<Cozinheiro> cozinheiros;

	public Usuario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDataUpdate() {
		return this.dataUpdate;
	}

	public void setDataUpdate(Timestamp dataUpdate) {
		this.dataUpdate = dataUpdate;
	}

	public byte getDel() {
		return this.del;
	}

	public void setDel(byte del) {
		this.del = del;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Atendente> getAtendentes() {
		return this.atendentes;
	}

	public void setAtendentes(List<Atendente> atendentes) {
		this.atendentes = atendentes;
	}

	public Atendente addAtendente(Atendente atendente) {
		getAtendentes().add(atendente);
		atendente.setUsuario(this);

		return atendente;
	}

	public Atendente removeAtendente(Atendente atendente) {
		getAtendentes().remove(atendente);
		atendente.setUsuario(null);

		return atendente;
	}

	public List<Cozinheiro> getCozinheiros() {
		return this.cozinheiros;
	}

	public void setCozinheiros(List<Cozinheiro> cozinheiros) {
		this.cozinheiros = cozinheiros;
	}

	public Cozinheiro addCozinheiro(Cozinheiro cozinheiro) {
		getCozinheiros().add(cozinheiro);
		cozinheiro.setUsuario(this);

		return cozinheiro;
	}

	public Cozinheiro removeCozinheiro(Cozinheiro cozinheiro) {
		getCozinheiros().remove(cozinheiro);
		cozinheiro.setUsuario(null);

		return cozinheiro;
	}

}