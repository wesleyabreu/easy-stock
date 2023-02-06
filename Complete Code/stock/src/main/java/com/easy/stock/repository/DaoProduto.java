package com.easy.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.easy.stock.model.Produto;

// Interface que extende o repositório CRUD do java SPRING

public interface DaoProduto extends JpaRepository<Produto, Integer> {
    // Produto findById( Integer id);
}