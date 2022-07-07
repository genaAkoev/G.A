package ru.akoev.telegrambot.Entities;

import javax.persistence.*;

@Entity
public class ClientOrder {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Client client;

    @Column (nullable = false)
    private Integer status;

    @Column (nullable = false, precision = 15, scale = 2)
    private Double total;


    public Long getId() { return id; }
    public Client getClient() { return client; }
    public Integer getStatus() { return status; }
    public Double getTotal() { return total; }

    public void setId(Long id) { this.id = id; }
    public void setClient(Client client) { this.client = client; }
    public void setStatus(Integer status) { this.status = status; }
    public void setTotal(Double total) { this.total = total; }
}
