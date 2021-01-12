/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.m2ice.tp_note.resources;

import com.m2ice.util.Utilisateur;
import java.util.ArrayList;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author etu
 */
@Path("users")
public class Utilisateurs {
    
    @GET
    @Produces(MediaType.TEXT_XML)
    public String getListOfUserApplication() {
        ArrayList<Utilisateur> arrayUser = new ArrayList<>();
        String returnValue = "";
        
        arrayUser.add(new Utilisateur("<UTILISATEUR NOM=\"tototo\" PRENOM=\"IT\"/>"));
        arrayUser.add(new Utilisateur("titi", "super","2"));
        
        for (int i = 0; i< arrayUser.size(); i++) {
            returnValue += arrayUser.get(i).toXML()+"\n";
        }
        System.out.println(returnValue);
        return returnValue;
    }
    
    @POST
    public String createAnUser(String content) {
        Utilisateur user = new Utilisateur(content);
        return user.toXML();
    }
    
    @GET 
    @Path("/{id}")
    @Produces(MediaType.TEXT_XML)
    public String getUserById (@PathParam("id") String id) {
        ArrayList<Utilisateur> arrayUser = new ArrayList<>();
        
        arrayUser.add(new Utilisateur("titi", "super","1"));
        arrayUser.add(new Utilisateur("titi", "super","2"));
        
        for(int i =0; i< arrayUser.size(); i++) {
            if (arrayUser.get(i).getId().equals(id)){
                System.out.println(arrayUser.get(i));
                return arrayUser.get(i).toXML();
            }
        }
        return null;
    }
    
    @PUT 
    @Path("/{id}")
    public String updateUserById (@PathParam("id") String id, String content) {
        ArrayList<Utilisateur> arrayUser = new ArrayList<>();
        Utilisateur user ;
        Utilisateur putUser = new Utilisateur(content);
        String returnValue = null;
        
        arrayUser.add(new Utilisateur("tutu", "sp","1"));
        arrayUser.add(new Utilisateur("tata", "tata","2"));
        
        for(int i =0; i< arrayUser.size(); i++) {
            if (arrayUser.get(i).getId().equals(id)){
                user = arrayUser.get(i); // get user by id
                arrayUser.remove(i); // remove user
                
                System.out.println(returnValue);
                // check if the name are not the same
                if (!user.getNom().equals(putUser.getNom())) 
                    user.setNom(putUser.getNom());
                
                // check if the surname is not the same
                if (!user.getPrenom().equals(putUser.getPrenom()))
                    user.setPrenom(putUser.getPrenom());
                
                // adding user in arraylist
                arrayUser.add(user);
                
                returnValue =  user.toXML();
            }
        }
        
        return returnValue;
    }
    
        
    @DELETE 
    @Path("/{id}")
    @Produces(MediaType.TEXT_XML)
    public String deleteUserById (@PathParam("id") String id) {
        ArrayList<Utilisateur> arrayUser = new ArrayList<>();
        
        arrayUser.add(new Utilisateur("titi", "super","1"));
        arrayUser.add(new Utilisateur("titi", "super","2"));
        
        for(int i =0; i< arrayUser.size(); i++) {
            if (arrayUser.get(i).getId().equals(id)){
                arrayUser.remove(i);
            }
        }
        return null;
    }
    
    
    
    
}
