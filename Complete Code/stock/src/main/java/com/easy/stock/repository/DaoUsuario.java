package com.easy.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.easy.stock.model.Usuario;

// Interface que extende o repositório CRUD do java SPRING

public interface DaoUsuario extends JpaRepository<Usuario, String> {
    Usuario findByUsername(String username);
}
