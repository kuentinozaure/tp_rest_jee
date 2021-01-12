/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.m2ice.tp_note.resources;

import com.m2ice.util.Service;
import com.m2ice.util.Utilisateur;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author etu
 */
@Path("services")
public class Services {
    
    @GET
    @Produces(MediaType.TEXT_XML)
    public String getListOfServicesApplication() {
        ArrayList<Service> arrayService = new ArrayList<>();
        String returnValue = "";
        
        arrayService.add(new Service("<SERVICE NOM=\"COURS EN LIGNE\"  UNITELOC=\"€\" COUT=\"40\" LISTRES=\"toto,titi\" />"));
        arrayService.add(new Service("<SERVICE NOM=\"COURS de math\"  UNITELOC=\"€\" COUT=\"40\" LISTRES=\"toto,titi\" />"));
        
        for (int i = 0; i< arrayService.size(); i++) {
            returnValue += arrayService.get(i).toXML()+"\n";
        }
        return returnValue;
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_XML)
    public String getServiceByID(@PathParam("id") String id) {
        ArrayList<Service> arrayService = new ArrayList<>();
        
        arrayService.add(new Service("<SERVICE NOM=\"COURS EN LIGNE\"  UNITELOC=\"€\" COUT=\"40\" LISTRES=\"toto,titi\" />"));
        arrayService.add(new Service("<SERVICE NOM=\"COURS de math\"  UNITELOC=\"€\" COUT=\"40\" LISTRES=\"toto,titi\" />"));
        
        
        for(int i =0; i< arrayService.size(); i++) {
            if (arrayService.get(i).getId().equals(id)){
                System.out.println(arrayService.get(i));
                return arrayService.get(i).toXML();
            }
        }
        return null;
    }
}
