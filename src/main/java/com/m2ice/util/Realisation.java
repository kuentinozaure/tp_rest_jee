/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.m2ice.util;

/**
 *
 * @author etu
 */
public class Realisation {
    private Service service;
    private Utilisateur utilisateur;
    private boolean estRealisé;
    private String ID;

    public Realisation(String ID,Service service, Utilisateur utilisateur, boolean estRealisé) {
        this.ID = ID;
        this.service = service;
        this.utilisateur = utilisateur;
        this.estRealisé = estRealisé;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public boolean isEstRealisé() {
        return estRealisé;
    }

    public void setEstRealisé(boolean estRealisé) {
        this.estRealisé = estRealisé;
    }
    
    
}
