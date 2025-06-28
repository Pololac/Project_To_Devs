package com.hb.cda.projecttodevs.repository;

import com.hb.cda.projecttodevs.entity.Skill;
import com.hb.cda.projecttodevs.repository.interfaces.SkillRepository;
import com.hb.cda.projecttodevs.repository.utils.AbstractRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class SkillRepositoryImpl extends AbstractRepository<Skill, Integer> implements SkillRepository {
    public SkillRepositoryImpl(EntityManager em) {
        super(em, Skill.class);
    }

    // Requête JPQL pour récupérer les Objects Skills correspondant aux ids envoyés par le front
    @Override
    public List<Skill> findByIds(List<Integer> ids) {
        try {
            return em.createQuery(
                            "SELECT s FROM Skill s WHERE s.id IN :ids", Skill.class)
                    .setParameter("ids", ids)
                    .getResultList();
        } catch(Exception e) {
            System.err.println("[SkillRepositoryImpl] Erreur lors du findByIds : " + e.getMessage());
            return List.of();
        }
    }
}
