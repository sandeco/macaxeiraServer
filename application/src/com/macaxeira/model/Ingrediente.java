package com.macaxeira.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the ingrediente database table.
 * 
 */
@Entity
@NamedQuery(name="Ingrediente.findAll", query="SELECT i FROM Ingrediente i")
public class Ingrediente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="_id")
	private int id;

	private Timestamp dataUpdate;

	private byte del;

	@Lob
	private String nome;

	//bi-directional many-to-many association to ItemPedido
	@ManyToMany
	@JoinTable(
		name="ingrediente_excluido"
		, joinColumns={
			@JoinColumn(name="Ingrediente_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Item_Pedido_id")
			}
		)
	private List<ItemPedido> itemPedidos;

	//bi-directional many-to-many association to Produto
	@ManyToMany
	@JoinTable(
		name="produto_has_ingrediente"
		, joinColumns={
			@JoinColumn(name="Ingrediente_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Produto_id")
			}
		)
	private List<Produto> produtos1;

	//bi-directional many-to-many association to Produto
	@ManyToMany(mappedBy="ingredientes2")
	private List<Produto> produtos2;

	public Ingrediente() {
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

	public List<ItemPedido> getItemPedidos() {
		return this.itemPedidos;
	}

	public void setItemPedidos(List<ItemPedido> itemPedidos) {
		this.itemPedidos = itemPedidos;
	}

	public List<Produto> getProdutos1() {
		return this.produtos1;
	}

	public void setProdutos1(List<Produto> produtos1) {
		this.produtos1 = produtos1;
	}

	public List<Produto> getProdutos2() {
		return this.produtos2;
	}

	public void setProdutos2(List<Produto> produtos2) {
		this.produtos2 = produtos2;
	}

}