package com.MotoCode.projeto.StudentModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Entity = Tabela do BD
@Table( name = "student")   // Nome da Tabela
public class StudentModel {

    @Id // Primary Key
    @GeneratedValue( strategy = GenerationType.IDENTITY)    // Auto Increment
    @Column( name = "id" )  // Dados da coluna para INTEGER
    private Integer id;

    @Column( name = "nome", length = 200, nullable = true ) // Dados para VARCHAR
    private String nome;
    
    @Column( name = "senha", length = 200, nullable = true ) // Dados para VARCHAR
    private String senha;
    
    @Column( name = "cra", nullable = true ) // Dados para INTEGER
    private Integer cra;
 
    // Getters and Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public Integer getCra() {
        return cra;
    }
    public void setCra(Integer cra) {
        this.cra = cra;
    }
}
