package com.richkane.styloo.persistence.model;

import com.richkane.styloo.persistence.GenderEnum;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "customer_details",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = "ID"),
            @UniqueConstraint(columnNames = "PHONE_NUMBER")
        })
public class CustomerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    private LocalDate birthDay;
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CART_ID", referencedColumnName = "ID")
    private Cart cart;

    public CustomerDetails() {}

    public CustomerDetails(String firstName, String lastName, String phoneNumber,
                           LocalDate birthDay, GenderEnum gender, Cart cart) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
        this.gender = gender;
        this.cart = cart;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
