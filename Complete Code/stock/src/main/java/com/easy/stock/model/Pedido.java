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

    @Column( name = "pagamento_status")
    private String pagamentoStatus;

    @Column( name = "orcamento")
    private Float orcamento;

    @Column( name = "id_nota_fiscal")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_nota_fiscal;

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
        return id_nota_fiscal;
    }

    public void setId_nota_fiscal(Integer id_nota_fiscal) {
        this.id_nota_fiscal = id_nota_fiscal;
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