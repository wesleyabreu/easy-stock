package com.easy.stock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

import com.easy.stock.model.Pedido;
import com.easy.stock.model.Produto;

//import com.easy.stock.model.Pedido;

// Interface que extende o repositório CRUD do java SPRING

public interface DaoPedido extends JpaRepository<Pedido, Integer> {
    @Query(value = "SELECT p.id_produto, p.nome, p.descricao, p.preco" +
                   "  FROM lista_produtos p" +
                   "  INNER JOIN pedido c ON p.id = c.lista_itens_pedido")
    List<Produto> findProdutoList();
}