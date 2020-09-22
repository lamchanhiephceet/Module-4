package com.codegym.cts.model;

import javax.persistence.*;

@Entity
@Table(name="contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String address;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name= "category_id")
    private Category category;

    public Contact() {}

    public Contact(String username, String address, String phoneNumber) {
        this.username = username;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString() {
        return String.format("Contact[id = %d,username = %s,address = %s,phoneNumber = %s]",id,username,address,phoneNumber);
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Category getCategory() {
        return category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
