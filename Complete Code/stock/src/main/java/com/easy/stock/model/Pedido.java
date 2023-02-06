package com.easy.stock.model;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
@Table( name = "pedido")
public class Pedido {
    
    @Id
    @Column( name = "id_pedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;

    @Column( name = "comprador_username")
    private String compradorUsername;

    @Column( name = "pagamento_status")
    private String pagamentoStatus;

    @Column( name = "orcamento")
    private Float orcamento;

    @Column( name = "lista_itens_pedido")
    private String listaItens;

    @Column( name = "id_nota_fiscal")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNota;

    @Column( name = "comprador_nome")
    private String compradorNome;

    @Column( name = "comprador_cpf")
    private String compradorCPF;

    @Column( name = "comprador_endereco")
    private String compradorEndereco;

    // Getters And Setters

    public Integer getId_pedido() {
        return idPedido;
    }

    public void setId_pedido(Integer id_pedido) {
        this.idPedido = id_pedido;
    }

    public String getPagamento_status() {
        return pagamentoStatus;
    }

    public void setPagamento_status(String pagamento_status) {
        this.pagamentoStatus = pagamento_status;
    }

    public Float getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Float orcamento) {
        this.orcamento = orcamento;
    }

    public Integer getId_nota_fiscal() {
        return idNota;
    }

    public void setId_nota_fiscal(Integer id_nota_fiscal) {
        this.idNota = id_nota_fiscal;
    }

    public String getListaItens() {
        return listaItens;
    }

    public void setListaItens(String listaItens) {
        this.listaItens = listaItens;
    }
	
    public String getCompradorUsername() {
        return compradorUsername;
    }

    public void setCompradorUsername(String compradorUsername) {
        this.compradorUsername = compradorUsername;
    }

    public String getCompradorNome() {
        return compradorNome;
    }

    public void setCompradorNome(String compradorNome) {
        this.compradorNome = compradorNome;
    }

    public String getCompradorCPF() {
        return compradorCPF;
    }

    public void setCompradorCPF(String compradorCPF) {
        this.compradorCPF = compradorCPF;
    }

    public String getCompradorEndereco() {
        return compradorEndereco;
    }

    public void setCompradorEndereco(String compradorEndereco) {
        this.compradorEndereco = compradorEndereco;
    }
}














/* 
package com.easy.stock.model;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class Pedido {
    private final Produto productRepository;

    public CartController(ProductRepository productRepository, ItemRepository itemRepository) {
        this.productRepository = productRepository;
        this.itemRepository = itemRepository;
    }

    @PostMapping("/add")
    public Item addItem(@RequestParam Long productId, @RequestParam Integer quantity) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException());
        Item item = new Item();
        item.setProductId(productId);
        item.setQuantity(quantity);
        return itemRepository.save(item);
    }

    @DeleteMapping("/remove/{itemId}")
    public void removeItem(@PathVariable Long itemId) {
        itemRepository.deleteById(itemId);
    }

    @GetMapping("/list")
    public List<Item> listItems() {
        return itemRepository.findAll();
    }

    @GetMapping("/total")
    public Double getTotal() {
        List<Item> items = itemRepository.findAll();
        return items.stream().mapToDouble(item -> {
            Product product = productRepository.findById(item.getProductId()).orElseThrow(() -> new ResourceNotFoundException());
            return product.getPrice() * item.getQuantity();
        }).sum();
    }
}
*/