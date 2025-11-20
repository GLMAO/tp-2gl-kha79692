package com.polytech;

import com.polytech.tp.*;

public class App {
    public static void main(String[] args) {

        // Création d'un cours avec le Builder
        Cours cours = new CoursBuilder()
                .setMatiere("Programmation Java")
                .setEnseignant("Dr. Bencheikh")
                .setSalle("Salle B12")
                .setDate("2025-02-01")
                .setHeureDebut("08:00")
                .setOptionnel(false)
                .setNiveau("L2")
                .setNecessiteProjecteur(true)
                .build();

        // Affichage (test)
        System.out.println("=== Test du Pattern Builder ===");
        System.out.println("Matière : " + cours.getMatiere());
        System.out.println("Enseignant : " + cours.getEnseignant());
        System.out.println("Description : " + cours.getDescription());
        System.out.println("Durée : " + cours.getDuree() + "h");


        System.out.println("\n\n\n\n=== Test du Pattern Obsever ===");

        GestionnaireEmploiDuTemps gestionnaire = new GestionnaireEmploiDuTemps();

        // Observateurs
        Etudiant e1 = new Etudiant("Amine");
        Responsable r1 = new Responsable("Dr. Bensaid");

        // Inscription via attach
        gestionnaire.attach(e1);
        gestionnaire.attach(r1);

        // Simulation d’un changement
        gestionnaire.setChangement("Nouvelle salle : C15");


        System.out.println("\n\n\n\n=== Test du Pattern Decorater ===");
        ICours cours4 = new CoursBuilder()
                .setMatiere("Génie Logiciel")
                .setEnseignant("Dr. Karim")
                .setSalle("A22")
                .setDate("2025-02-10")
                .setHeureDebut("10:00")
                .setOptionnel(false)
                .setNiveau("L3")
                .setNecessiteProjecteur(true)
                .build();

        System.out.println("----- Cours normal -----");
        System.out.println(cours.getDescription());

        // Ajout dynamique de responsabilités
        cours4 = new CoursEnLigne(cours4);

        System.out.println("----- Cours décoré : En ligne -----");
        System.out.println(cours4.getDescription());
    }
}
