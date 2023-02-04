package com.easy.stock.repository;

import org.springframework.data.repository.CrudRepository;

import com.easy.stock.model.Usuario;

// Interface que extende o repositório CRUD do java SPRING

public interface Dao extends CrudRepository<Usuario, String> {
    
}
