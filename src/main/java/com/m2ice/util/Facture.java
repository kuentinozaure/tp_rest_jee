/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.m2ice.util;

import java.time.LocalDateTime;

/**
 *
 * @author etu
 */
public class Facture {
    private Realisation realisation;

    public Facture(Realisation realisation) {
        this.realisation = realisation;
    }

    public Realisation getRealisation() {
        return realisation;
    }

    public void setRealisation(Realisation realisation) {
        this.realisation = realisation;
    }
    
    @Override
    public String toString() {
        return "<FACTURE COUT=\"" + this.realisation.getService().getCout() + 
                "\"  SERVICENAME=\"" + this.realisation.getService().getNom()+ 
                "\"  UNITELOC=\"" + this.realisation.getService().getUniteLocation()+ 
                "\" USERNAME=\"" + this.realisation.getUtilisateur().getNom() + 
                "\" FIRSTNAME=\"" + this.realisation.getUtilisateur().getPrenom() + 
                "\" CREATEAT=\""+ LocalDateTime.now()+"\" />";
    }
    
    
}
