package com.hb.cda.projecttodevs;

import com.hb.cda.projecttodevs.repository.Database;
import com.hb.cda.projecttodevs.repository.utils.DataSeeder;
import jakarta.persistence.EntityManager;

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





    }
}