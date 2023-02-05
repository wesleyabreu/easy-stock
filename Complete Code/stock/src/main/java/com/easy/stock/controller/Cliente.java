package com.easy.stock.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.easy.stock.repository.DaoProduto;
import com.easy.stock.model.Produto;


@Controller
public class Cliente {

    @Autowired
    private DaoProduto daoProduto;

    private ArrayList<Produto> encontrados;

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

    @RequestMapping("/painel-cliente")    
    public String lobbyCliente(){
        return "painel-cliente";
    }

    //  Listar os produtos Disponíveis aos cliente

    @GetMapping("/produtos")
    public String listarProdutos(Model model) {

        encontrados = new ArrayList<>(daoProduto.findAll());

        encontrados.removeIf(element -> element.getQuantidade() == 0);

        model.addAttribute("produtos", encontrados );

        return "listagem-produtos";
    }



}
