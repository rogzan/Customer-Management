package com.mycompany.customer;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 45)
    private String name;
    @Column(nullable = false, length = 14)
    private BigInteger vatId;
    @Column(nullable = false)
    private LocalDate creationDate;
    @Column(nullable = false, length = 100)
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getVatId() {
        return vatId;
    }

    public void setVatId(BigInteger vatId) {
        this.vatId = vatId;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vatId=" + vatId +
                ", creationDate=" + creationDate +
                ", address='" + address + '\'' +
                '}';
    }
}
