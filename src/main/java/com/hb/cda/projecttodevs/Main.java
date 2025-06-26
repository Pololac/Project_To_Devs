package com.hb.cda.projecttodevs;

import com.hb.cda.projecttodevs.entity.Dev;
import com.hb.cda.projecttodevs.entity.Skill;
import com.hb.cda.projecttodevs.repository.Database;
import com.hb.cda.projecttodevs.repository.DevRepositoryImpl;
import com.hb.cda.projecttodevs.repository.SkillRepositoryImpl;
import com.hb.cda.projecttodevs.repository.interfaces.DevRepository;
import com.hb.cda.projecttodevs.repository.interfaces.SkillRepository;
import com.hb.cda.projecttodevs.repository.utils.DataSeeder;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        EntityManager em = null;

/*        try {
            em = Database.getManager();
            em.getTransaction().begin();
            System.out.println("Seeding la base de données...");
            DataSeeder.seed(em);
            System.out.println("Seed terminé.");
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Erreur lors du seeding : " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }*/

        // DEV : REMPLIR SON PROFIL
        Dev dev3 = new Dev("dev3", "123456", "dev3@gmail.com", "Jack", "Daniels", "Dev junior", 1);

        // Liste des skills choisis côté front
        List<Integer> selectedSkillIds = List.of(1, 2, 3);

        // Récupération des Objets Skill de la BDD
        SkillRepository skillRepo = new SkillRepositoryImpl();
        List<Skill> selectedSkills = skillRepo.findByIds(selectedSkillIds);

        // On ajoute les skills à dev3
        dev3.setSkills(selectedSkills);

        // Sauvegarde en BDD
        DevRepository devRepo = new DevRepositoryImpl();
        devRepo.persist(dev3);



        // ProductOwner propose un projet


    }
}