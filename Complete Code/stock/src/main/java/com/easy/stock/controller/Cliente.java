package com.easy.stock.controller;

import java.util.ArrayList;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.easy.stock.repository.DaoProduto;
import com.easy.stock.repository.DaoPedido;
import com.easy.stock.repository.DaoUsuario;
import com.easy.stock.model.Produto;
import com.easy.stock.model.Pedido;
import com.easy.stock.model.CarrinhoCompras;
import com.easy.stock.model.Usuario;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;

// Controller das ações atribuidas a Usuários tipo Cliente

@Controller
public class Cliente extends Usuario {

    // Injection do DAO's ( Para operar nos bancos de dados desses models usando esses DAO's )
    @Autowired
    private DaoProduto daoProduto;

    @Autowired
    private DaoPedido daoPedido;

    @Autowired
    private DaoUsuario daoUsuario;

    // Injection para utilizar o @Bean declarado no "Configuration". Ele atua como um objeto que tem sua memória por sessão.
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

    @GetMapping("/cliente/pedidos")    
    public String listarHistoricoCompras(Model model){

        ArrayList<Pedido> encontrados = new ArrayList<>(daoPedido.findAll());
        ArrayList<Produto> encontradosP = new ArrayList<>(daoPedido.findProdutoList());

        encontrados.removeIf(element -> !element.getCompradorUsername().equals(getUsername()));

        model.addAttribute("pedidos", encontrados );
        model.addAttribute("produtos", encontradosP );
        
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

    // Pagar Pedido
    @GetMapping("/api/pagar-pedido/{id}")
    public String realizarPagamentoPedido(@PathVariable Integer id, Model model ) {
        
        Random random =  new Random();

        Pedido pedido = daoPedido.findById(id).orElseThrow();

        pedido.setId_nota_fiscal(random.nextInt(Integer.MAX_VALUE)+1);
        pedido.setPagamento_status("Pago");

        daoPedido.save(pedido);

        return "redirect:/cliente/pedidos";
        
    }
}
