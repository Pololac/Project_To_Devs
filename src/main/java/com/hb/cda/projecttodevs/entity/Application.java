package com.hb.cda.projecttodevs.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private LocalDate appliedAt;
    private String message;
    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;

    @ManyToOne
    private Project project;

    @ManyToOne
    private Dev dev;

    public Application() {
    }

    public Application(LocalDate appliedAt, String message, ApplicationStatus status) {
        this.appliedAt = appliedAt;
        this.message = message;
        this.status = status;
    }

    public Application(Integer id, LocalDate appliedAt, String message, ApplicationStatus status) {
        this.id = id;
        this.appliedAt = appliedAt;
        this.message = message;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getAppliedAt() {
        return appliedAt;
    }

    public void setAppliedAt(LocalDate appliedAt) {
        this.appliedAt = appliedAt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Dev getDev() {
        return dev;
    }

    public void setDev(Dev dev) {
        this.dev = dev;
    }
}
