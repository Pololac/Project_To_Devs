package com.hb.cda.projecttodevs.repository;

import com.hb.cda.projecttodevs.entity.Application;
import com.hb.cda.projecttodevs.repository.interfaces.ApplicationRepository;
import com.hb.cda.projecttodevs.repository.utils.AbstractRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;

import java.util.List;
import java.util.Optional;

public class ApplicationRepositoryImpl extends AbstractRepository<Application, Integer> implements ApplicationRepository {
    public ApplicationRepositoryImpl(EntityManager em) {
        super(em, Application.class);
    }

    // Requête JPQL pour récupérer les Objects Applications correspondant à un projectId
    public List<Application> findByProjectId(Integer projectId) {
        try {
            return em.createQuery(
                    "SELECT a FROM Application a WHERE a.project.id = :pId",
                    Application.class)
                    .setParameter("pId", projectId)
                    .getResultList();
        } catch (PersistenceException e) {
            System.err.println(e);
        }
        return List.of ();
    }
}
