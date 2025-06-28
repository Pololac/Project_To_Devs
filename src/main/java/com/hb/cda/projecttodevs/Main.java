package com.hb.cda.projecttodevs;

import com.hb.cda.projecttodevs.entity.*;
import com.hb.cda.projecttodevs.repository.*;
import com.hb.cda.projecttodevs.repository.interfaces.*;
import com.hb.cda.projecttodevs.repository.utils.DataSeeder;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        EntityManager em = null;

        // SEED DATABASE
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

        // DEV : REMPLIR UN PROFIL
/*        try {
            em = Database.getManager();

            em.getTransaction().begin();

            Dev dev3 = new Dev("dev3", "123456", "dev3@gmail.com",
                    "Jack", "Daniels", "Dev junior", 1);

            // Récupérer les skills
            SkillRepository skillRepo = new SkillRepositoryImpl(em);
            List<Skill> selectedSkills = skillRepo.findByIds(List.of(1, 2, 3));
            dev3.setSkills(selectedSkills);

            // Persister le dev
            DevRepository devRepo = new DevRepositoryImpl(em);
            boolean devPersisted= devRepo.persist(dev3);
            if (!devPersisted) {
                System.out.println("Échec du persist de dev3");
            } else {
                System.out.println("Dev3 persisté");
            }

            em.getTransaction().commit();

        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("ERREUR dans main : " + e.getMessage());
            e.printStackTrace();

        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    */


        // DEV : UPDATE PROFIL
        /*try {
            em = Database.getManager();
            em.getTransaction().begin();

            DevRepository devRepo = new DevRepositoryImpl(em);
            Dev devToUpdate = null;


            *//*            Optional<Dev> searchedDev = devRepo.findById(5);
            if (searchedDev.isPresent()) {
                devToUpdate = searchedDev.get();
                devToUpdate.setSeniority(0);
            } else {
                System.out.println("Aucun dev trouvé avec l'id 3");
            }*//*

            // Récupérer le dev à modifier par son nom et prénom (car Id peut changer avec les MAJ de la BDD)
            List<Dev> allDevs = devRepo.findAll();
            for (Dev dev : allDevs) {
                if ("Jack".equals(dev.getFirstname()) && "Daniels".equals(dev.getLastname())) {
                    devToUpdate = dev;
                    break;
                }
            }
            // Appliquer la modification
            devToUpdate.setSeniority(0);

            // Updater le dev
            if (devToUpdate != null) {
                boolean devUpdated = devRepo.update(devToUpdate);
                if (!devUpdated) {
                    System.out.println("Échec de l'update de " + devToUpdate.getFirstname() + " " + devToUpdate.getLastname());
                } else {
                    System.out.println(devToUpdate.getFirstname() + " " + devToUpdate.getLastname() + " updated");
                }
            }

            em.getTransaction().commit();

        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("ERREUR dans main : " + e.getMessage());
            e.printStackTrace();

        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }*/

        // PROJECT OWNER 1 PROPOSE UN PROJET
/*        try {
            em = Database.getManager();
            em.getTransaction().begin();

            // Récupération du ProductOwner qui a fait la demande
            int ownerId = 1;
            ProductOwner owner = null;
            ProductOwnerRepository poRepo = new ProductOwnerRepositoryImpl(em);
            Optional<ProductOwner> optPo = poRepo.findById(ownerId);
            if (optPo.isPresent()) {
                owner = optPo.get();
            } else {
                System.out.println("Pas de ProductOwner avec l’ID " + ownerId);
            }

            // Création du projet
            Project project4 = new Project("Project 4", "App iOS de santé", LocalDate.of(2025, 9, 15), 3000);
            project4.setOwner(owner);

            // Persister le projet
            ProjectRepository projectRepo = new ProjectRepositoryImpl(em);
            boolean projectPersisted= projectRepo.persist(project4);
            if (!projectPersisted) {
                System.out.println("Échec du persist du projet4");
            } else {
                System.out.println("Projet4 persisté");
            }

            em.getTransaction().commit();

        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("ERREUR dans main : " + e.getMessage());
            e.printStackTrace();

        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    */

        // FILTRER LES PROJETS PAR THEME
/*       try {
           em = Database.getManager();

           // Theme recherché
           String themeName = "Services";

           // Récupérer les projets correspondant au theme recherché
           ProjectRepository projectRepo = new ProjectRepositoryImpl(em);
           List<Project> projects = projectRepo.findByTheme(themeName);

           // Affichage des projets correspondants
           if (projects.isEmpty()) {
               System.out.println("Aucun projet trouvé pour le thème « " + themeName + " ».");
           } else {
               System.out.println("Projets pour le thème « " + themeName + " » :");
               for (Project p : projects) {
                   // Avec ton toString() amélioré
                   System.out.println(p);
               }
           }
       } catch (Exception e) {
           e.printStackTrace();
       } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }*/

        // FILTRER LES PROJETS PAR BUDGET MINI
/*        try {
            em = Database.getManager();

            // Budget mini
            float budgetMini = 4000 ;

            // Récupérer les projets dont budget est supérieur ou égal à budgetMini
            ProjectRepository projectRepo = new ProjectRepositoryImpl(em);
            List<Project> projects = projectRepo.findByMinBudget(budgetMini);

            // Affichage des projets correspondants
            if (projects.isEmpty()) {
                System.out.println("Aucun projet trouvé avec un budget supérieur ou égal à " + budgetMini + ".");
            } else {
                System.out.println("Projets au budget supérieur ou égal à " + budgetMini + " :");
                for (Project p : projects) {
                    // Avec ton toString() amélioré
                    System.out.println(p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }*/

        // FILTRER LES PROJETS AYANT UNE DATE DE LIVRAISON SUPÉRIEURE 0 LA DATE DONNEE
/*        try {
            em = Database.getManager();

            // Theme recherché
            LocalDate dateLivraison = LocalDate.of(2025, 9, 15) ;

            // Récupérer les projets dont date postérieure
            ProjectRepository projectRepo = new ProjectRepositoryImpl(em);
            List<Project> projects = projectRepo.findByDeliveryDate(dateLivraison);

            // Affichage des projets correspondants
            if (projects.isEmpty()) {
                System.out.println("Aucun projet trouvé avec une date de livraison postérieur ou égale à " + dateLivraison + ".");
            } else {
                System.out.println("Projets avec une date de livraison postérieur ou égale à " + dateLivraison + " :");
                for (Project p : projects) {
                    // Avec ton toString() amélioré
                    System.out.println(p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }*/


        // CANDIDATER POUR UN PROJET (côté Dev) = CREATE APPLICATION
/*        try {
            em = Database.getManager();

            em.getTransaction().begin();

            //Créer la candidature
            Application app3 = new Application(LocalDate.of(2025, 6, 25), "J'ai toutes les compétences requises pour ce projet", ApplicationStatus.PENDING);
            app3.setDev(em.find(Dev.class, 3));
            app3.setProject(em.find(Project.class, 1));

            // Persister la candidature
            ApplicationRepository appRepo = new ApplicationRepositoryImpl(em);
            boolean appPersisted = appRepo.persist(app3);
            if (!appPersisted) {
                System.out.println("Échec du persist de l'application 3");
            } else {
                System.out.println("Application 3 persistée");
            }

            em.getTransaction().commit();

        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("ERREUR dans main : " + e.getMessage());
            e.printStackTrace();

        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }*/


        // LISTER LES CANDIDATURES POUR UN PROJET (côté ProductOwner) = AppRepo.findByProjectId
/*        try {
            em = Database.getManager();

            em.getTransaction().begin();

            // Récupérer les candiatures pour un projet donné
            ApplicationRepository appRepo = new ApplicationRepositoryImpl(em);
            int idProject = 1;
            List<Application> applications = appRepo.findByProjectId(idProject);

            // Affichage des projets correspondants
            if (applications.isEmpty()) {
                System.out.println("Aucune candidatures pour le projet");
            } else {
                String projetTitle = em.find(Project.class, idProject).getTitle();
                System.out.println("Candidatures pour le projet \"" + projetTitle + "\" : " );
                for (Application appl : applications) {
                    // Avec ton toString() amélioré
                    System.out.println(appl);
                }
            }

            em.getTransaction().commit();

        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("ERREUR dans main : " + e.getMessage());
            e.printStackTrace();

        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }*/


        // ACCEPTER OU REFUSER LES CANDIDATURES (côté ProductOwner) = AppRepo.update
        /*try {
            em = Database.getManager();
            em.getTransaction().begin();

            ApplicationRepository appRepo = new ApplicationRepositoryImpl(em);
            Application appToUpdate = null;

            //Chercher la candidature à modifier et appliquer la modif de statut si elle existe
            Optional<Application> searchedApp = appRepo.findById(1);
            if (searchedApp.isPresent()) {
                appToUpdate = searchedApp.get();
                appToUpdate.setStatus(ApplicationStatus.APPROVED);
            } else {
                System.out.println("Aucune candidature trouvée avec l'id 1");
            }

            // Updater l'application
            if (appToUpdate != null) {
                boolean appUpdated = appRepo.update(appToUpdate);
                if (!appUpdated) {
                    System.out.println("Échec de l'update de la candidature.");
                } else {
                    System.out.println("La candidature a été mise à jour");
                }
            }

            em.getTransaction().commit();

        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("ERREUR dans main : " + e.getMessage());
            e.printStackTrace();

        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }*/
    }
}