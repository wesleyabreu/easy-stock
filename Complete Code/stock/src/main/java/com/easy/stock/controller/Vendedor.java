package com.easy.stock.controller;

import java.util.ArrayList;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class Vendedor {
    
    @Autowired
    private DaoProduto daoProduto;

    @Autowired
    private DaoUsuario daoUsuario;

    private ArrayList<Produto> encontrados;

    // Direcionar o usuário para Painel Vendedor
    @RequestMapping("/painel-vendedor")   
    public String lobbyVendedor(){
        return "painel-vendedor";
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

    // Registrar usuário - VENDEDOR
    @PostMapping("/cadastrar-vendedor")
    public String cadastrarContaVendedor(@ModelAttribute Usuario usuario, Model model){

        Usuario user = daoUsuario.findByUsername(usuario.getUsername());


        // Erro
        if (user != null) {
            
            model.addAttribute("message", "Nome de usuário já existe, use outro.");
            return "cadastro-vendedor";

        } else {

            usuario.setTipo_conta("Vendedor");   
            daoUsuario.save(usuario);

            return "login";
        }
    }


    // Listar todos os produtos
    @GetMapping("/gerenciar")
    public String  listarProdutos(Model model) {

        encontrados = new ArrayList<>(daoProduto.findAll());

        model.addAttribute("produtos", encontrados );

        return "gerenciar-produtos";
    }
    
    // Adicionar Produtos
    @PostMapping("/cadastrar-produto")
    public String cadastrarProduto(@ModelAttribute Produto produto, Model model){

        daoProduto.save(produto);

        return "redirect:/gerenciar";
        
    }

    // Deletar
    @GetMapping("/deletar-produto/{id}")
    public String excluirProduto( @PathVariable("id") Integer id ){

        daoProduto.deleteById(id);
        
        return "redirect:/gerenciar";
    }

    // Editar produtos
    @GetMapping("/editar-produto/{id}")
    public String atualizarProduto( @PathVariable("id") Integer id ){

        // Acrescentar aqui o código

        return "redirect:/gerenciar";

    }

}
