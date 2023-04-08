package com.richkane.styloo.persistence.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "role",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = "ID"),
            @UniqueConstraint(columnNames = "NAME")
        }
)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToMany( mappedBy = "roles", fetch = FetchType.LAZY )
    private Set<User> users;

    public Role() {}

    public Role(String name) {
        this.name = name;
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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
