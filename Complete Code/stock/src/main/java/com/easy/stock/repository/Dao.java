package com.easy.stock.repository;

import org.springframework.data.repository.CrudRepository;

import com.easy.stock.model.Usuario;

public interface Dao extends CrudRepository<Usuario, String> {
    
}
