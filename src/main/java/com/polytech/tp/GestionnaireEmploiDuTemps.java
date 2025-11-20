package com.polytech.tp;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireEmploiDuTemps implements Subject {

    private List<Observer> observers = new ArrayList<>();

    // ========== MÉTHODES SUBJECT ==========
    @Override
    public void attach(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void detach(Observer obs) {
        observers.remove(obs);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }

    // ========== MÉTHODE EXIGÉE PAR LE TEST ==========
    public void setChangement(String message) {
        notifyObservers(message);
    }

    // ========= NON OBLIGATOIRE POUR LE TEST ==========
    // (seulement utile pour tes TP)
}
