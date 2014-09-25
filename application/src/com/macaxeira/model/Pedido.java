package com.macaxeira.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="_id")
	private int id;

	@Lob
	@Column(name="nome_cliente")
	private String nomeCliente;

	//bi-directional many-to-one association to ItemPedido
	@OneToMany(mappedBy="pedido")
	private List<ItemPedido> itemPedidos;

	//bi-directional many-to-one association to Atendimento
	@ManyToOne
	@JoinColumn(name="Atendimento_idAtendimento")
	private Atendimento atendimento;

	//bi-directional many-to-one association to Situacao
	@ManyToOne
	@JoinColumn(name="Situacao_id")
	private Situacao situacao;

	//bi-directional many-to-one association to Cozinheiro
	@ManyToOne
	@JoinColumn(name="Cozinheiro_id")
	private Cozinheiro cozinheiro;

	//bi-directional many-to-one association to Atendente
	@ManyToOne
	@JoinColumn(name="Atendente_id")
	private Atendente atendente;

	public Pedido() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeCliente() {
		return this.nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public List<ItemPedido> getItemPedidos() {
		return this.itemPedidos;
	}

	public void setItemPedidos(List<ItemPedido> itemPedidos) {
		this.itemPedidos = itemPedidos;
	}

	public ItemPedido addItemPedido(ItemPedido itemPedido) {
		getItemPedidos().add(itemPedido);
		itemPedido.setPedido(this);

		return itemPedido;
	}

	public ItemPedido removeItemPedido(ItemPedido itemPedido) {
		getItemPedidos().remove(itemPedido);
		itemPedido.setPedido(null);

		return itemPedido;
	}

	public Atendimento getAtendimento() {
		return this.atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	public Situacao getSituacao() {
		return this.situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public Cozinheiro getCozinheiro() {
		return this.cozinheiro;
	}

	public void setCozinheiro(Cozinheiro cozinheiro) {
		this.cozinheiro = cozinheiro;
	}

	public Atendente getAtendente() {
		return this.atendente;
	}

	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}

}