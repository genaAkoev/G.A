package ru.akoev.telegrambot.Entities;

import javax.persistence.*;

@Entity
public class OrderProduct {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private ClientOrder clientOrder;

    @ManyToOne
    private Product product;

    @Column (nullable = false)
    private Integer countProduct;


    public Long getId() { return id; }
    public ClientOrder getClientOrder() { return clientOrder; }
    public Product getProduct() { return product; }
    public Integer getCountProduct() { return countProduct; }

    public void setId(Long id) { this.id = id; }
    public void setClientOrder(ClientOrder clientOrder) { this.clientOrder = clientOrder; }
    public void setProduct(Product product) { this.product = product; }
    public void setCountProduct(Integer countProduct) { this.countProduct = countProduct; }
}
