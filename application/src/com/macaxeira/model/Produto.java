package com.macaxeira.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the produto database table.
 * 
 */
@Entity
@NamedQuery(name="Produto.findAll", query="SELECT p FROM Produto p")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="_id")
	private int id;

	private Timestamp dataUpdate;

	private byte del;

	@Lob
	private String nome;

	private double preco;

	//bi-directional many-to-one association to ItemPedido
	@OneToMany(mappedBy="produto")
	private List<ItemPedido> itemPedidos;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="categoria_id")
	private Categoria categoria;

	//bi-directional many-to-many association to Adicional
	@ManyToMany
	@JoinTable(
		name="produto_has_adicional"
		, joinColumns={
			@JoinColumn(name="Produto__id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Adicional__id")
			}
		)
	private List<Adicional> adicionals;

	//bi-directional many-to-many association to Ingrediente
	@ManyToMany
	@JoinTable(
		name="produto_has_ingrediente"
		, joinColumns={
			@JoinColumn(name="Produto_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Ingrediente_id")
			}
		)
	private List<Ingrediente> ingredientes;

	public Produto() {
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

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return this.preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public List<ItemPedido> getItemPedidos() {
		return this.itemPedidos;
	}

	public void setItemPedidos(List<ItemPedido> itemPedidos) {
		this.itemPedidos = itemPedidos;
	}

	public ItemPedido addItemPedido(ItemPedido itemPedido) {
		getItemPedidos().add(itemPedido);
		itemPedido.setProduto(this);

		return itemPedido;
	}

	public ItemPedido removeItemPedido(ItemPedido itemPedido) {
		getItemPedidos().remove(itemPedido);
		itemPedido.setProduto(null);

		return itemPedido;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Adicional> getAdicionals() {
		return this.adicionals;
	}

	public void setAdicionals(List<Adicional> adicionals) {
		this.adicionals = adicionals;
	}

	public List<Ingrediente> getIngredientes() {
		return this.ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

}