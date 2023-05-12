package me.dio.padroesprojetospring.model;

import jakarta.persistence.*;


@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String phoneNumeber;
    private String email;
    @ManyToOne
    private Address address;

    public String getPhoneNumeber() {
        return phoneNumeber;
    }

    public void setPhoneNumeber(String phoneNumeber) {
        this.phoneNumeber = phoneNumeber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
