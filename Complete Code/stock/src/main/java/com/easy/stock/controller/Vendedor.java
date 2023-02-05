package com.easy.stock.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.easy.stock.model.Usuario;
import com.easy.stock.repository.DaoProduto;
import com.easy.stock.repository.DaoUsuario;
import com.easy.stock.model.Produto;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Vendedor {
    
    @Autowired
    private DaoProduto daoProduto;

    @Autowired
    private DaoUsuario daoUsuario;

    private ArrayList<Produto> encontrados;

    //private Model model;

    // Direcionar o usuário para SAIR


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
        daoUsuario.save(usuario);

        return "login";   
    }

    // Listar todos os produtos
    @GetMapping()
    public String ListarTodosProdutos() {
        
        

        return "0";
    }

    // Listar todos os produtos -- TESTAR ESSE AQUI -- DEVE TÁ ERRADO AINDA
    @GetMapping("/gerenciar")
    public String exibirTodos(Model model) {

        encontrados = new ArrayList<>(daoProduto.findAll());

        for (Produto p:encontrados) {
            System.out.println(p.getNome());
            System.out.println(p.getId_produto());
        }

        model.addAttribute("produtos", encontrados );

        return "gerenciar-produtos";
    }
    

}
