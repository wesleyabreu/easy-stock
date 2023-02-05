package com.easy.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.easy.stock.model.Usuario;
import com.easy.stock.repository.Dao;

@Controller
public class Vendedor {
    
    @Autowired
    private Dao dao;

    // Direcionar o usuário para SAIR
    

    // Direcionar o usuário para Gerenciar Produtos
    @RequestMapping("/gerenciar")    
    public String clienteProdutos(){
        return "gerenciar-produtos";
    }

    // Direcionar o usuário para Ver Carrinho
    @RequestMapping("/historico")    
    public String clienteCarrinho(){
        return "historico-vendas-site";
    }

    // Direcionar o usuário para Ver Pedidos
    @RequestMapping("/cadastro-vendedor")    
    public String clientePedidos(){
        return "cadastro-vendedor";
    }

    // Registrar usuário - CLIENTE
    @PostMapping("/cadastrar-vendedor")  
    public String userRegistration(@ModelAttribute Usuario usuario, Model model){

        usuario.setTipo_conta("Vendedor");   
        dao.save(usuario);

        return "login";   
    }

}
