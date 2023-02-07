package com.easy.stock.model;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class CarrinhoCompras {

    private List<Produto> itens = new ArrayList<>();

    // Adicionar produto ao carrinho
    public void addProduto(Produto produto) {
        itens.add(produto);
    }

    // Remover Produto do carrinho
    public void removeProduto(Produto produto) {

        int pos_item = -1;

        for (int i = 0; i < itens.size(); i++) {
            if ( itens.get(i).getId_produto() == produto.getId_produto() ) {
                pos_item = i;
                break;
            }
        }

        if (pos_item != -1) {
            itens.remove(pos_item);
        }
        
    }

    public List<Produto> listarProdutos() {
        return itens;
    }

    public void limpar() {
        itens.clear();
    }

    public Float getTotal() {

        Float soma = null;

        for ( Produto p : itens ) {
            if (soma == null) {
                soma = p.getPreco();
            } else {
                soma += p.getPreco();
            }
        }

        return soma;
    }
    
    public Pedido realizarPedido() {

        Pedido pedido = new Pedido();

        pedido.setLista(itens);
        pedido.setOrcamento(getTotal());
        pedido.setPagamento_status("Pendente");

        limpar();

        return pedido;
    }

}
