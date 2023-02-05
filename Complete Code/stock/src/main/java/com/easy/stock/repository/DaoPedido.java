package com.easy.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.easy.stock.model.Pedido;

//import com.easy.stock.model.Pedido;

// Interface que extende o repositório CRUD do java SPRING

public interface DaoPedido extends JpaRepository<Pedido, Integer> {
    
}