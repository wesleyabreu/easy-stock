package com.easy.stock.configuration;

import org.springframework.context.annotation.Bean;

import com.easy.stock.controller.Cliente;
import com.easy.stock.model.CarrinhoCompras;

public class Configuracoes {
    @Bean
    public Cliente contaLoginCliente() {
        return new Cliente();
    }

    @Bean
    public CarrinhoCompras carrinhoCliente() {
        return new CarrinhoCompras();
    }
}
