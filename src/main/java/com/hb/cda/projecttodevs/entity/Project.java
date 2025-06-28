package com.hb.cda.projecttodevs.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private LocalDate deliveryDate;
    private float budget;

    @ManyToOne
    private ProductOwner owner;

    @ManyToOne
    private Theme theme;

    @OneToMany(mappedBy = "project")
    private List<Application> applications = new ArrayList<>();

    public Project() {
    }

    public Project(String title, String description, LocalDate deliveryDate, float budget) {
        this.title = title;
        this.description = description;
        this.deliveryDate = deliveryDate;
        this.budget = budget;
    }

    public Project(Integer id, String title, String description, LocalDate deliveryDate, float budget) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deliveryDate = deliveryDate;
        this.budget = budget;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public ProductOwner getOwner() {
        return owner;
    }

    public void setOwner(ProductOwner owner) {
        this.owner = owner;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    @Override
    public String toString() {
        return "Project : " +
                "id=" + id +
                ", titre ='" + title + '\'' +
                ", description ='" + description + '\'' +
                ", theme =" + (theme != null ? theme.getName() : "null") +
                ", budget =" + budget +
                ", date de livraison =" + deliveryDate +
                ", Propriétaire =" + (owner != null ? owner.getBusinessName() : "null") +
                ';';
    }
}
