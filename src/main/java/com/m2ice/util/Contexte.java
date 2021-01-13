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
    private ArrayList<Utilisateur> userList;
    private ArrayList<Service> serviceList;

    public Contexte() {
        this.userList = new ArrayList<>();
        this.serviceList = new ArrayList<>();
        
        this.userList.add(new Utilisateur("<UTILISATEUR NOM=\"ZEROK\" PRENOM=\"Etienne\" ID=\"1\"/>"));
        this.userList.add(new Utilisateur("<UTILISATEUR NOM=\"Phillipe\" PRENOM=\"Caterine\" ID=\"2\"/>"));
        this.userList.add(new Utilisateur("<UTILISATEUR NOM=\"Loumous\" PRENOM=\"Filip\" ID=\"3\"/>"));
        
        this.serviceList.add(new Service("<SERVICE NOM=\"COURS DE MATH\"  UNITELOC=\"€\" COUT=\"40\" LISTRES=\"\" CREATEBY=\"3\" />"));
        this.serviceList.add(new Service("<SERVICE NOM=\"COURS DE PHYSIQUE\"  UNITELOC=\"€\" COUT=\"50\" LISTRES=\"\" CREATEBY=\"2\" />"));
        this.serviceList.add(new Service("<SERVICE NOM=\"REPARATION DE TONDEUSE\"  UNITELOC=\"€\" COUT=\"100\" LISTRES=\"\" CREATEBY=\"1\" />"));
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
