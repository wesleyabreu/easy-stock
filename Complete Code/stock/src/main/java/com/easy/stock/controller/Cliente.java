package com.easy.stock.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.easy.stock.repository.DaoProduto;
import com.easy.stock.repository.DaoUsuario;
import com.easy.stock.model.Produto;
import com.easy.stock.model.Pedido;
import com.easy.stock.model.CarrinhoCompras;
import com.easy.stock.model.Usuario;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class Cliente extends Usuario {

    @Autowired
    private DaoProduto daoProduto;

    @Autowired
    private DaoProduto daoPedido;

    @Autowired
    private DaoUsuario daoUsuario;

    @Autowired
    private CarrinhoCompras carrinho;


    // Direcionar o usuário para SAIR    

    // Direcionar o usuário para Ver Produtos
    @RequestMapping("/cliente/produtos")    
    public String clienteProdutos(){
        return "listagem-produtos";
    }

    // Direcionar o usuário para Ver Carrinho
    @RequestMapping("/cliente/carrinho")    
    public String clienteCarrinho(Model model){
        model.addAttribute("produtos", carrinho.listarProdutos() );

        return "carrinho-compras";
    }

    // Direcionar o usuário para Ver Pedidos
    @RequestMapping("/cliente/pedidos")    
    public String clientePedidos(){
        return "pedidos";
    }

    // Retornar ao Painel do Cliente
    @RequestMapping("/painel-cliente")    
    public String lobbyCliente(){
        return "painel-cliente";
    }

    //  Listar os produtos Disponíveis aos cliente
    @GetMapping("/cliente/produtos")
    public String listarProdutos(Model model) {

        ArrayList<Produto> encontrados = new ArrayList<>(daoProduto.findAll());

        encontrados.removeIf(element -> element.getQuantidade() == 0);

        model.addAttribute("produtos", encontrados );

        return "listagem-produtos";
    }

    // Adicionar item ao carrinho
    @GetMapping("/api/add-carrinho/{id}")
    public String adicionarProduto(@PathVariable("id") Integer id, @ModelAttribute Produto produto, Model model) {

        Produto produtoEncontrado = daoProduto.findById(id).orElseThrow();

        carrinho.addProduto(produtoEncontrado);    // Método da classe carrinho

        produtoEncontrado.setQuantidade(produtoEncontrado.getQuantidade()-1);   // Decrementar do BD a quantidade ao adicionar
        
        daoProduto.save(produtoEncontrado);        

        return "redirect:/cliente/produtos";
        
    }

    // Remover Produto
    @GetMapping("/api/remove-carrinho/{id}")
    public String removerProduto(@PathVariable Integer id, Model model) {

        Produto produtoEncontrado = daoProduto.findById(id).orElseThrow();

        produtoEncontrado.setQuantidade(produtoEncontrado.getQuantidade()+1);   // Incrementar a quantidade no BD

        daoProduto.save(produtoEncontrado);

        carrinho.removeProduto(produtoEncontrado);

        return "redirect:/cliente/carrinho";
        
    }

    // Efetuar Pedido
    @GetMapping("/api/efetuar-pedido")
    public String realizarPedido(Model model) {
        
        Pedido pedido = carrinho.realizarPedido();
        
        Usuario comprador = daoUsuario.findByUsername(getUsername());

        pedido.setCompradorUsername(comprador.getUsername());
        pedido.setCompradorNome(comprador.getNome());
        pedido.setCompradorCPF(comprador.getCpf());
        pedido.setCompradorEndereco(comprador.getEndereco());

        daoPedido.save(pedido);
        
        carrinho.limpar();

        return "redirect:/cliente/pedidos";
        
    }
}
