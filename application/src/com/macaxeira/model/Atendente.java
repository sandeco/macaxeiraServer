package com.macaxeira.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the atendente database table.
 * 
 */
@Entity
@NamedQuery(name="Atendente.findAll", query="SELECT a FROM Atendente a")
public class Atendente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="_id")
	private int id;

	private Timestamp dataUpdate;

	private byte del;

	@Lob
	private String nome;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="Usuario_id")
	private Usuario usuario;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="atendente")
	private List<Pedido> pedidos;

	public Atendente() {
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

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedido addPedido(Pedido pedido) {
		getPedidos().add(pedido);
		pedido.setAtendente(this);

		return pedido;
	}

	public Pedido removePedido(Pedido pedido) {
		getPedidos().remove(pedido);
		pedido.setAtendente(null);

		return pedido;
	}

}