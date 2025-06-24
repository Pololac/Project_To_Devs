package com.hb.cda.projecttodevs.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String title;
    private String description;
    private LocalDate deliveryDate;
    private float budget;

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
}
