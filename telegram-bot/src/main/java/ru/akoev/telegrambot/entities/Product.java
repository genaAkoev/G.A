package ru.akoev.telegrambot.entities;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Category category;

    @Column (nullable = false, length = 50, unique = true)
    private String name;

    @Column (nullable = false, length = 400)
    private String description;

    @Column (nullable = false, precision = 15, scale = 2)
    private Double price;


    public Long getId() { return id; }
    public Category getCategory() { return category; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public Double getPrice() { return price; }

    public void setId(Long id) { this.id = id; }
    public void setCategory(Category category) { this.category = category; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setPrice(Double price) { this.price = price; }
}
