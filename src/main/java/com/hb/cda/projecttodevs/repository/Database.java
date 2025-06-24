package com.hb.cda.projecttodevs.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Database {
    private static EntityManagerFactory factory;

    public static EntityManager getManager() {
        // Singleton
        if(factory == null) {
            factory = Persistence
                    .createEntityManagerFactory("main");
        }
        return factory.createEntityManager();
    }
}
