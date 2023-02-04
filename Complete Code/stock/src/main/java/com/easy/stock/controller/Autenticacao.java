package com.easy.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.easy.stock.model.Usuario;
import com.easy.stock.repository.Dao;

// Controller da autenticação de usuário
// HTML related: cadastro-cliente, login

@Controller
public class Autenticacao {  
    
    @Autowired
    private Dao dao;    // DAO =  DataBase Acess Object ( é através desse objeto que usamos funções do Repositório CRUD )
    
    @GetMapping("/") // URL root "/" básica, vai carregar a "login" page HTML - Root, página fonte
    public String indexPage(){
        return "login"; // Esse return identifica o diretório "templates"
    }

    // Direcionar o usuário para o cadastro, caso ele não tenha 
    @RequestMapping("/redirect")    // Endpoit que faz ação de redirecionar o cliente para o CADASTRO ( caso ele não tenha )
    public String userRedirect(){
        return "cadastro-cliente";
    }

    // Registrar usuário - CLIENTE
    @PostMapping("/cadastrar")  // Endepoint que faz ação de CADASTRAR o cliente
    public String userRegistration(@ModelAttribute Usuario usuario, Model model){

        usuario.setTipo_conta("Cliente");   // Adiciona o atributo que o usuário não define ( seu tipo de conta)
        dao.save(usuario);

        return "login";   // Onde vai após o cadastro
    }

}
