package com.hb.cda.projecttodevs.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class ProductOwner extends User {
    private String businessName;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true) // utilisé le nom de la propriété de l'autre côté
    private List<Project> projects = new ArrayList<>();

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

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
