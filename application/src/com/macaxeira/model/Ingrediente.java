package com.macaxeira.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


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
	@ManyToMany(mappedBy="ingredientes")
	private List<ItemPedido> itemPedidos;

	//bi-directional many-to-many association to Produto
	@ManyToMany(mappedBy="ingredientes")
	private List<Produto> produtos;

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

	public List<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}