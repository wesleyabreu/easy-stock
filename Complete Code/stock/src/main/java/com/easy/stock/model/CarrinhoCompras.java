package com.easy.stock.model;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.easy.stock.repository.DaoProduto;

@RestController
@RequestMapping("/carrinho-compras")
public class CarrinhoCompras {

    private final DaoProduto produtoRepository;
    private final List<Produto> itens = new ArrayList<>();

    public CarrinhoCompras(DaoProduto produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping("/add-carrinho")
    public void addProduto(@RequestParam Integer produtoId) {
        Produto produto = produtoRepository.findById(produtoId).get();
        itens.add(produto);
    }

    @DeleteMapping("/remove-carrinho/{id}")
    public void removeItem(@PathVariable Float produtoId) {
        //itens.removeIf(item -> item.getId_produto().equals(produtoId));
    }

    @GetMapping("/lista-carrinho")
    public List<Produto> listaItens() {
        return itens;
    }

    @GetMapping("/total-carrinho")
    public Double getTotal() {
        return itens.stream().mapToDouble(item -> item.getPreco()).sum();
    }
}
