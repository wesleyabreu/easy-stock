package com.easy.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.easy.stock.model.Usuario;
import com.easy.stock.model.CarrinhoCompras;
import com.easy.stock.repository.DaoUsuario;


// Controller da autenticação de usuário
// HTML related: cadastro-cliente, login

@Controller
public class Autenticacao {  

    @Autowired
    private DaoUsuario dao;             // DAO =  DataBase Acess Object ( é através desse objeto que usamos funções do Repositório CRUD )
    
    @Autowired
    private Cliente cliente;

    @Autowired
    private CarrinhoCompras carrinho;

    @GetMapping("/")                    // URL root "/" básica, vai carregar a "login" page HTML - Root, página fonte
    public String indexPage(){
        return "login";                 // Esse return identifica o diretório "templates"
    }

    @RequestMapping("/sair")    
    public String userSair(){
        return "login";
    }

    // Direcionar o usuário para o cadastro, caso ele não tenha 
    @RequestMapping("/redirect")        // Endpoit que faz ação de redirecionar o cliente para o CADASTRO ( caso ele não tenha )
    public String userRedirect(){
        return "cadastro-cliente";
    }

    // Registrar usuário - CLIENTE
    @PostMapping("/cadastrar")              // Endepoint que faz ação de CADASTRAR o cliente
    public String criarContaCliente(@ModelAttribute Usuario usuario, Model model){

        Usuario user = dao.findByUsername(usuario.getUsername());

        // Erro
        if (user != null) {
            
            model.addAttribute("message", "Nome de usuário já existe, use outro.");
            return "cadastro-cliente";

        } else {

            usuario.setTipo_conta("Cliente");   
            dao.save(usuario);

            return "login";
        }
    }

    // Autenticar o LOGIN
    @PostMapping("/autenticar")
    public String acessarConta(@RequestParam("username") String username, @RequestParam("password") String password, Model model ) { // Esses parâmetros são os que são passados no FORM do HTML

    Usuario user = dao.findByUsername(username);    // user =  objeto que recebe as infos do usuario no BD para comparar ( vai receber o usuario que for encontrado pelo "FindByUsername")

    // Erro
    if (user == null || !user.getPassword().equals(password)) {
      model.addAttribute("message", "Usuário ou senha incorretos");
      return "login";
    }

    // Conta cliente
    else if(user.getTipo_conta().equals("Cliente")){
        cliente.setUsername(user.getUsername());
        carrinho.limpar();
        
        return "painel-cliente";
    }

    //Conta Vendedor
    else{
        return "painel-vendedor";
    }
  }

}
