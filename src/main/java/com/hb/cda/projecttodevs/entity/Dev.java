package com.hb.cda.projecttodevs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Dev extends User{
    private String firstname;
    private String lastname;
    private String description;
    private String seniority;

    @OneToMany(mappedBy = "dev")
    private List<Application> applications = new ArrayList<>();

    @ManyToMany
    private List<Skill> skills = new ArrayList<>();

    public Dev() {}

    public Dev(String username, String password, String email, String firstname, String lastname, String description, String seniority) {
        super(username, password, email);
        this.firstname = firstname;
        this.lastname = lastname;
        this.description = description;
        this.seniority = seniority;
    }
    public Dev(Integer id, String username, String password, String email, String firstname, String lastname, String description, String seniority) {
        super(id, username, password, email);
        this.firstname = firstname;
        this.lastname = lastname;
        this.description = description;
        this.seniority = seniority;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeniority() {
        return seniority;
    }

    public void setSeniority(String seniority) {
        this.seniority = seniority;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }
}
