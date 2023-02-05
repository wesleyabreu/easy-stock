package com.easy.stock.model;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
@Table( name = "produto")
public class Produto {
    
    @Id
    @Column( name = "id_produto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idProduto;

    @Column( name = "nome")
    private String nome;

    @Column( name = "descricao")
    private String descricao;

    @Column( name = "preco")
    private Float preco;

	@Column( name = "quantidade")
    public Integer quantidade;

    // Getters And Setters

	public Integer getId_produto() {
		return idProduto;
	}

	public void setId_produto(Integer id) {
		this.idProduto = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
}
