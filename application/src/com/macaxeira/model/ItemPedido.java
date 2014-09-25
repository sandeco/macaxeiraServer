package com.macaxeira.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the item_pedido database table.
 * 
 */
@Entity
@Table(name="item_pedido")
@NamedQuery(name="ItemPedido.findAll", query="SELECT i FROM ItemPedido i")
public class ItemPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="_id")
	private int id;

	//bi-directional many-to-many association to Ingrediente
	@ManyToMany(mappedBy="itemPedidos")
	private List<Ingrediente> ingredientes;

	//bi-directional many-to-many association to Adicional
	@ManyToMany
	@JoinTable(
		name="item_pedido_has_adicional"
		, joinColumns={
			@JoinColumn(name="Item_Pedido_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Adicional_id")
			}
		)
	private List<Adicional> adicionals;

	//bi-directional many-to-one association to Pedido
	@ManyToOne
	@JoinColumn(name="Pedido_id")
	private Pedido pedido;

	//bi-directional many-to-one association to Produto
	@ManyToOne
	@JoinColumn(name="Produto_id")
	private Produto produto;

	public ItemPedido() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Ingrediente> getIngredientes() {
		return this.ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public List<Adicional> getAdicionals() {
		return this.adicionals;
	}

	public void setAdicionals(List<Adicional> adicionals) {
		this.adicionals = adicionals;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}