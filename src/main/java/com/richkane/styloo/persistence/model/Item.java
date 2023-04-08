package com.richkane.styloo.persistence.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "item",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID")
})
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long quantity;
    private Float price;
    private String description;
    @ManyToMany(mappedBy = "items")
    private Set<Cart> carts;

    public Item() {}

    public Item(String name, Long quantity, Float price, String description) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
