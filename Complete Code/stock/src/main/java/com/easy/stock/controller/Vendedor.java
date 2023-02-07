package com.easy.stock.controller;

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
import com.easy.stock.repository.DaoPedido;
import com.easy.stock.model.Produto;
import com.easy.stock.model.Pedido;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


// Controller das ações atribuidas a Usuários Tipo Vendedor

@Controller
public class Vendedor extends Usuario {
    
    @Autowired
    private DaoProduto daoProduto;

    @Autowired
    private DaoUsuario daoUsuario;

    @Autowired
    private DaoPedido daoPedido;

    // Direcionar o usuário para Painel Vendedor
    @RequestMapping("/painel-vendedor")   
    public String lobbyVendedor(){
        return "painel-vendedor";
    }

     // Listar todos os produtos
    @GetMapping("/vendedor/gerenciar")
    public String  listarProdutos(Model model) {

        ArrayList<Produto> encontrados = new ArrayList<>(daoProduto.findAll());

        model.addAttribute("produtos", encontrados );

        return "gerenciar-produtos";
    }
    
    // Cadastrar novos Produtos
    @PostMapping("/api/cadastrar-produto")
    public String cadastrarProduto(@ModelAttribute Produto produto, Model model){

        daoProduto.save(produto);

        return "redirect:/vendedor/gerenciar";
        
    }

    // Deletar
    @GetMapping("/api/deletar-produto/{id}")
    public String excluirProduto( @PathVariable("id") Integer id ){

        daoProduto.deleteById(id);
        
        return "redirect:/vendedor/gerenciar";
    }

    // Editar/ Atualizar produtos
    @GetMapping("/api/editar-produto/{id}")
    public String atualizarProduto(@PathVariable Integer id, Model model) {

        Produto produto = daoProduto.findById(id).orElseThrow();
        model.addAttribute("produto", produto); // Objeto Produto modificável

        return "gerenciar-produtos";
    }


    // Editar/ Atualizar produtos
    @PostMapping("/api/editar-produto/{id}")
    public String atualizarProduto(@PathVariable Integer id, @ModelAttribute Produto produto) {

        produto.setId_produto(id);
        daoProduto.save(produto);

        return "redirect:/vendedor/gerenciar"; // Redirect para o "gerenciar"
    }

    // Direcionar o usuário para Ver o histórico
    @RequestMapping("/vendedor/historico")    
    public String listarVendasSite(){
        return "historico-vendas-site";
    }

     // Listar historico de vendas
    @GetMapping("/vendedor/historico")
    public String listarVendasSite(Model model) {

        ArrayList<Pedido> encontrados = new ArrayList<>(daoPedido.findAll());

        encontrados.removeIf(element -> element.getPagamento_status().equals("Pendente"));

        model.addAttribute("vendas", encontrados );

        return "historico-vendas-site";
    }

    // Direcionar o usuário para cadastrar um novo vendedor
    @RequestMapping("/vendedor/cadastro-vendedor")    
    public String cadastrarVendedor(){
        return "cadastro-vendedor";
    }

    // Registrar usuário - VENDEDOR
    @PostMapping("/api/cadastrar-vendedor")
    public String cadastrarContaVendedor(@ModelAttribute Usuario usuario, Model model){

        Usuario user = daoUsuario.findByUsername(usuario.getUsername());


        // Erro
        if (user != null) {
            
            model.addAttribute("message", "Nome de usuário já existe, use outro.");
            return "cadastro-vendedor";

        } else {

            usuario.setTipo_conta("Vendedor");   
            daoUsuario.save(usuario);

            return "redirect:/painel-vendedor";
        }
    }



}
