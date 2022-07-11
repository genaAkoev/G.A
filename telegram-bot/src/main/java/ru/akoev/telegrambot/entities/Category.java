package ru.akoev.telegrambot.entities;

import javax.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue
    private Long id;

    @Column (nullable = false, length = 50, unique = true)
    private String name;

    @ManyToOne
    private Category parent;


    public Category(){}

    public Category(String name, Category parent) {
        this.name = name;
        this.parent = parent;
    }


    public Long getId() { return id; }
    public String getName() { return name; }
    public Category getParent() { return parent; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setParent(Category parent) { this.parent = parent; }
}
