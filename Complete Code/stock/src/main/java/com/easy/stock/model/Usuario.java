package com.easy.stock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario extends Pessoa {
        
    @Id
    @Column ( name = "username")
    private String username;

    @Column ( name = "password")
    private String password;

    @Column ( name = "tipo_conta")
    private String tipo_conta;

    // Getters and Setters a

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo_conta() {
        return tipo_conta;
    }

    public void setTipo_conta(String tipo_conta) {
        this.tipo_conta = tipo_conta;
    }

    public String listarProdutos(){
        return null;
    }

}



