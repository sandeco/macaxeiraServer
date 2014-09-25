package com.macaxeira.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the atendimento database table.
 * 
 */
@Entity
@NamedQuery(name="Atendimento.findAll", query="SELECT a FROM Atendimento a")
public class Atendimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="_id")
	private int id;

	//bi-directional many-to-one association to Mesa
	@ManyToOne
	@JoinColumn(name="Mesa_id")
	private Mesa mesa;

	//bi-directional many-to-one association to Situacao
	@ManyToOne
	@JoinColumn(name="Situacao_id")
	private Situacao situacao;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="atendimento")
	private List<Pedido> pedidos;

	public Atendimento() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Mesa getMesa() {
		return this.mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public Situacao getSituacao() {
		return this.situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedido addPedido(Pedido pedido) {
		getPedidos().add(pedido);
		pedido.setAtendimento(this);

		return pedido;
	}

	public Pedido removePedido(Pedido pedido) {
		getPedidos().remove(pedido);
		pedido.setAtendimento(null);

		return pedido;
	}

}