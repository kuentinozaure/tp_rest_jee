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
public class Service {
    static int idCounter=0;
    String nom, resume, uniteLocation,id, cout, reservationList,createdBy;


    
    public Service(String xml)
    {
        nom = findAttribute(xml, "NOM");
        resume = findAttribute(xml, "RESUME");
        uniteLocation = findAttribute(xml, "UNITELOC");
        cout = findAttribute(xml, "COUT");
        createdBy = findAttribute(xml, "CREATEBY");
        reservationList = findAttribute(xml, "LISTRES");
        
        id = findAttribute(xml, "ID"); // Ne sert pas quand on fait un POST
        if (id==null)
            id = getNewId();
    }
    
    public static String findAttribute(String xml, String idAttribute)
    {
            int pos1=xml.indexOf(idAttribute+"=\""); // On ne fait qu'avec "
            if (pos1<0) return null;
            int pos2=xml.indexOf("\"", pos1+idAttribute.length()+2);
            return xml.substring(pos1+idAttribute.length()+2, pos2);
    }
    
    public String toXML() {
        return "<SERVICE ID=\"" + id + "\" NOM=\"" + nom + "\"  UNITELOC=\"" + uniteLocation + "\" COUT=\"" + cout + "\" LISTRES=\"" + reservationList + "\" CREATEBY=\""+createdBy+"\" />";
    }
    
    public static String getNewId() {
        return "" + (idCounter++);
    }

    public static int getIdCounter() {
        return idCounter;
    }
    
        public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public static void setIdCounter(int idCounter) {
        Service.idCounter = idCounter;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getUniteLocation() {
        return uniteLocation;
    }

    public void setUniteLocation(String uniteLocation) {
        this.uniteLocation = uniteLocation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCout() {
        return cout;
    }

    public void setCout(String cout) {
        this.cout = cout;
    }

    public String getReservationList() {
        return reservationList;
    }

    public void setReservationList(String reservationList) {
        this.reservationList = reservationList;
    }
    
    
}
