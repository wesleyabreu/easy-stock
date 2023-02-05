package com.easy.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.easy.stock.model.Produto;
import com.easy.stock.repository.Dao;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Cliente {
    
    @Autowired
    private Dao dao;

    // Direcionar o usuário para SAIR
    

    // Direcionar o usuário para Ver Produtos
    @RequestMapping("/produtos")    
    public String clienteProdutos(){
        return "listagem-produtos";
    }

    // Direcionar o usuário para Ver Carrinho
    @RequestMapping("/carrinho")    
    public String clienteCarrinho(){
        return "carrinho-compras";
    }

    // Direcionar o usuário para Ver Pedidos
    @RequestMapping("/pedidos")    
    public String clientePedidos(){
        return "pedidos";
    }


}
