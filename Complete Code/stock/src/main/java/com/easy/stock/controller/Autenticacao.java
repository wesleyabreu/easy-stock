package com.easy.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.easy.stock.model.Usuario;
import com.easy.stock.repository.Dao;

// Controller da autenticação de usuário
// HTML related: cadastro-cliente

@Controller
public class Autenticacao {  
    
    @Autowired
    private Dao dao;
    
    @GetMapping("/cadastro") // URL root "/" básica, vai carregar a "index" page HTML - Root, página font
    public String indexPage(){
        return "cadastro-cliente"; // Esse return identifica o diretório "templates"
    }

    @PostMapping("/register")
    public String userRegistration(@ModelAttribute Usuario usuario, Model model){

        // model.addAttribute("name", user.getName()); // Coloca no objeto "name" o valor desse atributo

        usuario.setTipo_conta("Cliente");

        dao.save(usuario);
        //model.addAttribute("message", userInsert.getEmail());

        return "login";   // Onde vai após o cadastro
    }



    

}
