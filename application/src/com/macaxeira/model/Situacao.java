package com.macaxeira.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the situacao database table.
 * 
 */
@Entity
@NamedQuery(name="Situacao.findAll", query="SELECT s FROM Situacao s")
public class Situacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="_id")
	private int id;

	@Lob
	private String situacao;

	//bi-directional many-to-one association to Atendimento
	@OneToMany(mappedBy="situacao")
	private List<Atendimento> atendimentos;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="situacao")
	private List<Pedido> pedidos;

	public Situacao() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public List<Atendimento> getAtendimentos() {
		return this.atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}

	public Atendimento addAtendimento(Atendimento atendimento) {
		getAtendimentos().add(atendimento);
		atendimento.setSituacao(this);

		return atendimento;
	}

	public Atendimento removeAtendimento(Atendimento atendimento) {
		getAtendimentos().remove(atendimento);
		atendimento.setSituacao(null);

		return atendimento;
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedido addPedido(Pedido pedido) {
		getPedidos().add(pedido);
		pedido.setSituacao(this);

		return pedido;
	}

	public Pedido removePedido(Pedido pedido) {
		getPedidos().remove(pedido);
		pedido.setSituacao(null);

		return pedido;
	}

}