package com.macaxeira.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonAutoDetect;


/**
 * The persistent class for the categoria database table.
 * 
 */
@JsonAutoDetect
@Entity
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String nome;

	//bi-directional many-to-one association to Produto
	@OneToMany(mappedBy="categoria")
	private List<Produto> produtos;

	public Categoria() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto addProduto(Produto produto) {
		getProdutos().add(produto);
		produto.setCategoria(this);

		return produto;
	}

	public Produto removeProduto(Produto produto) {
		getProdutos().remove(produto);
		produto.setCategoria(null);

		return produto;
	}

}