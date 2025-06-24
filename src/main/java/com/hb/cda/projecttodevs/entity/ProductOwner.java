package com.hb.cda.projecttodevs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProductOwner extends User {
    private String businessName;

    // Constructeur vide
    public ProductOwner() {}

    // Constructeur avec tous les champs hérités sauf ID + businessName
    public ProductOwner(String username, String password, String email, String businessName) {
        super(username, password, email);
        this.businessName = businessName;
    }

    // Constructeur avec tous les champs hérités + businessName
    public ProductOwner(Integer id, String username, String password, String email, String businessName) {
        super(id, username, password, email);
        this.businessName = businessName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
}
