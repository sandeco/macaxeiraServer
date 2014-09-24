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
	private int item_Pedido_id;

	private double preco;

	//bi-directional many-to-many association to Ingrediente
	@ManyToMany
	@JoinTable(
		name="ingrediente_excluido"
		, joinColumns={
			@JoinColumn(name="Item_Pedido_Item_Pedido_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Ingrediente_id")
			}
		)
	private List<Ingrediente> ingredientes;

	//bi-directional many-to-one association to Pedido
	@ManyToOne
	@JoinColumn(name="Pedido_id")
	private Pedido pedido;

	//bi-directional many-to-one association to Produto
	@ManyToOne
	@JoinColumn(name="Produto_id")
	private Produto produto;

	//bi-directional many-to-many association to Adicional
	@ManyToMany
	@JoinTable(
		name="item_pedido_has_adicional"
		, joinColumns={
			@JoinColumn(name="Item_Pedido_Item_Pedido_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Adicional__id")
			}
		)
	private List<Adicional> adicionals;

	public ItemPedido() {
	}

	public int getItem_Pedido_id() {
		return this.item_Pedido_id;
	}

	public void setItem_Pedido_id(int item_Pedido_id) {
		this.item_Pedido_id = item_Pedido_id;
	}

	public double getPreco() {
		return this.preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public List<Ingrediente> getIngredientes() {
		return this.ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
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

	public List<Adicional> getAdicionals() {
		return this.adicionals;
	}

	public void setAdicionals(List<Adicional> adicionals) {
		this.adicionals = adicionals;
	}

}