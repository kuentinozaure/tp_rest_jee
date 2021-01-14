/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.m2ice.util;

import java.util.ArrayList;

/**
 *
 * @author etu
 */
public class Contexte {

    private static Contexte singleton = null;
    
    private ArrayList<Utilisateur> userList;
    private ArrayList<Service> serviceList;
    private ArrayList<Realisation> realisationList;

    public Contexte() {
        this.userList = new ArrayList<>();
        this.serviceList = new ArrayList<>();
        this.realisationList = new ArrayList<>();

        this.userList.add(new Utilisateur("<UTILISATEUR NOM=\"ZEROK\" PRENOM=\"Etienne\" ID=\"1\"/>"));
        this.userList.add(new Utilisateur("<UTILISATEUR NOM=\"Phillipe\" PRENOM=\"Caterine\" ID=\"2\"/>"));
        this.userList.add(new Utilisateur("<UTILISATEUR NOM=\"Loumous\" PRENOM=\"Filip\" ID=\"3\"/>"));
        this.userList.add(new Utilisateur("<UTILISATEUR NOM=\"HIL\" PRENOM=\"ERIKA\" ID=\"4\"/>"));

        this.serviceList.add(new Service("<SERVICE NOM=\"COURS DE MATH\"  UNITELOC=\"€\" COUT=\"40\" LISTRES=\"1;2;\" CREATEBY=\"3\" ID=\"1\"/>"));
        this.serviceList.add(new Service("<SERVICE NOM=\"COURS DE PHYSIQUE\"  UNITELOC=\"€\" COUT=\"50\" LISTRES=\"1;\" CREATEBY=\"2\" ID=\"2\"/>"));
        this.serviceList.add(new Service("<SERVICE NOM=\"REPARATION DE TONDEUSE\"  UNITELOC=\"€\" COUT=\"100\" LISTRES=\"2;3;4;\" CREATEBY=\"1\" ID=\"3\" />"));
        this.serviceList.add(new Service("<SERVICE NOM=\"REPARATION DE VOITURE\"  UNITELOC=\"€\" COUT=\"1000\" LISTRES=\"\" CREATEBY=\"1\" ID=\"4\"/>"));

        // Realisation for the first service
        this.realisationList.add(new Realisation("1",serviceList.get(0), userList.get(0), true));
        this.realisationList.add(new Realisation("2",serviceList.get(0), userList.get(2), false));

        // Realisation for the second service
        this.realisationList.add(new Realisation("3",serviceList.get(1), userList.get(0), false));

        // Realisation for the third service
        this.realisationList.add(new Realisation("4",serviceList.get(2), userList.get(1), true));
        this.realisationList.add(new Realisation("5",serviceList.get(2), userList.get(2), true));
        this.realisationList.add(new Realisation("6",serviceList.get(2), userList.get(3), false));
        
        // Realisation for the fourth service
        this.realisationList.add(new Realisation("7",serviceList.get(3), userList.get(1), true));
        this.realisationList.add(new Realisation("8",serviceList.get(2), userList.get(3), false));
    }

    public static Contexte getSingleton() {
        if (singleton == null) {
            return singleton = new Contexte();
        } 
        
        return singleton;
    }
    
    public ArrayList<Realisation> getRealisationList() {
        return realisationList;
    }

    public void setRealisationList(ArrayList<Realisation> realisationList) {
        this.realisationList = realisationList;
    }

    public ArrayList<Utilisateur> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<Utilisateur> userList) {
        this.userList = userList;
    }

    public ArrayList<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(ArrayList<Service> serviceList) {
        this.serviceList = serviceList;
    }

}
