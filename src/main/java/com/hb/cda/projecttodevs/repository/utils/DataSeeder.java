package com.hb.cda.projecttodevs.repository.utils;

import com.hb.cda.projecttodevs.entity.*;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

public class DataSeeder {
    public static void seed(EntityManager em) {
        ProductOwner owner1 = new ProductOwner("owner1", "123456","owner1@test.com","TechCorp");
        ProductOwner owner2 = new ProductOwner("owner2", "123456","owner2@test.com","AICorp");

        Dev dev1 = new Dev("dev1", "123456", "dev1@test.com", "Bobby", "Lapointe", "Full-stack developer", 7);
        Dev dev2 = new Dev("dev2", "123456", "dev2@test.com", "Franck", "Ocean", "Front developer", 2);


        Skill skill1 = new Skill("Java");
        Skill skill2 = new Skill("Angular");
        Skill skill3 = new Skill("React");
        Skill skill4 = new Skill("Node");
        Skill skill5 = new Skill("Python");
        Skill skill6 = new Skill("C++");

        em.persist(skill1);
        em.persist(skill2);
        em.persist(skill3);
        em.persist(skill4);
        em.persist(skill5);
        em.persist(skill6);

        dev1.setSkills(List.of(skill1, skill2, skill3, skill6));
        dev2.setSkills(List.of(skill2, skill3, skill4));

        em.persist(owner1);
        em.persist(owner2);

        em.persist(dev1);
        em.persist(dev2);


        Project project1 = new Project("project1", "Refonte de notre site vitrine", LocalDate.of(2025, 10, 25) , 5000);
        Project project2 = new Project("project2", "Produire une app complète de location de bornes électriques", LocalDate.of(2025, 8, 10) , 10000);
        Project project3 = new Project("project3", "Créer une API restful", LocalDate.of(2026, 1, 10) , 2000);

        Theme theme1 = new Theme( "Environnement");
        Theme theme2 = new Theme( "Industrie");
        Theme theme3 = new Theme( "Santé");
        Theme theme4 = new Theme( "Services");

        em.persist(theme1);
        em.persist(theme2);
        em.persist(theme3);
        em.persist(theme4);

        project1.setTheme(theme4);
        project2.setTheme(theme1);
        project3.setTheme(theme2);

        project1.setOwner(owner1);
        project2.setOwner(owner2);
        project3.setOwner(owner2);

        em.persist(project1);
        em.persist(project2);
        em.persist(project3);

        Application application1 = new Application(LocalDate.of(2025, 06, 25), "Je suis le roi du Front", ApplicationStatus.PENDING);
        Application application2 = new Application(LocalDate.of(2025, 05, 25), "J'ai toutes les compétences requises", ApplicationStatus.APPROVED);

        application1.setDev(dev2);
        application1.setProject(project1);
        application2.setDev(dev1);
        application2.setProject(project2);

        em.persist(application1);
        em.persist(application2);

        em.getTransaction().commit();
    }
}
