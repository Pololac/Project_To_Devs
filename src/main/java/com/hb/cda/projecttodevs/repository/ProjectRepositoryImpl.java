package com.hb.cda.projecttodevs.repository;

import com.hb.cda.projecttodevs.entity.Project;
import com.hb.cda.projecttodevs.repository.interfaces.ProjectRepository;
import com.hb.cda.projecttodevs.repository.utils.AbstractRepository;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class ProjectRepositoryImpl extends AbstractRepository<Project, Integer> implements ProjectRepository {

    public ProjectRepositoryImpl(EntityManager em) {
        super(em, Project.class);
    }

    // Requête JPQL pour récupérer les Objects Projects correspondant à un theme donné
    public List<Project> findByTheme(String themeName) {
        try {
            return em.createQuery(
                            "SELECT p FROM Project p WHERE p.theme.name = :th", Project.class)
                    .setParameter("th", themeName)
                    .getResultList();
        } catch (Exception ex) {
            System.err.println("findByTheme: " + ex.getMessage());
            return Collections.emptyList();
        }
    }

    // Requête JPQL pour récupérer les Objects Projects ayant une date de livraison postérieure à une date donnée
    public List<Project> findByMinBudget(float minBudget) {
        try {
            return em.createQuery(
                            "SELECT p FROM Project p WHERE p.budget >= :budg", Project.class)
                    .setParameter("budg", minBudget)
                    .getResultList();
        } catch (Exception ex) {
            System.err.println("findByMinBudget: " + ex.getMessage());
            return Collections.emptyList();
        }
    }

    // Requête JPQL pour récupérer les Objects Projects ayant une date de livraison postérieure à une date donnée
    public List<Project> findByDeliveryDate(LocalDate date) {
        try {
            return em.createQuery(
                            "SELECT p FROM Project p WHERE p.deliveryDate >= :d", Project.class)
                    .setParameter("d", date)
                    .getResultList();
        } catch (Exception ex) {
            System.err.println("findByDeliveryDate: " + ex.getMessage());
            return Collections.emptyList();
        }
    }

}
