package com.richkane.styloo.persistence.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "cart",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "ID"),
        })
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Float total;
    @OneToOne
    private User user;
    @ManyToMany
    private Set<Item> items;

    public Cart() {};

    public Cart(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
