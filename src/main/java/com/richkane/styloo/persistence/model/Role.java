package com.richkane.styloo.persistence.model;

import com.richkane.styloo.persistence.RoleEnum;
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
    @Enumerated(EnumType.STRING)
    private RoleEnum name;

    public Role() {}

    public Role(RoleEnum name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public RoleEnum getName() {
        return name;
    }

    public void setName(RoleEnum name) {
        this.name = name;
    }
}
