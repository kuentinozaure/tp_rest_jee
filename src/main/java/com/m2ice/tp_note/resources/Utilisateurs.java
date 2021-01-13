/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.m2ice.tp_note.resources;

import com.m2ice.util.Contexte;
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
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Utilisateur> getListOfUserApplication() {
        Contexte context = new Contexte();
        ArrayList<Utilisateur> arrayUser = context.getUserList();
//        String returnValue = "";
//
//        for (int i = 0; i < arrayUser.size(); i++) {
//            returnValue += arrayUser.get(i).toXML() + "\n";
//        }
//        System.out.println(returnValue);
        return arrayUser;
    }
    
    @POST
    public String createAnUser(String content) {
        Contexte context = new Contexte();
        ArrayList<Utilisateur> arrayUser = context.getUserList();
        Utilisateur user = new Utilisateur(content);
        arrayUser.add(user);
        context.setUserList(arrayUser);
        return user.toXML();
    }
    
    @GET 
    @Path("/{id}")
    @Produces(MediaType.TEXT_XML)
    public String getUserById (@PathParam("id") String id) {
        Contexte context = new Contexte();
        ArrayList<Utilisateur> arrayUser = context.getUserList();
        
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
        Contexte context = new Contexte();
        ArrayList<Utilisateur> arrayUser = context.getUserList();
        Utilisateur putUser = new Utilisateur(content);
        
        Utilisateur user ;
        String returnValue = null;
        
        
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
                context.setUserList(arrayUser);
                
                returnValue =  user.toXML();
            }
        }
        
        return returnValue;
    }
    
        
    @DELETE 
    @Path("/{id}")
    @Produces(MediaType.TEXT_XML)
    public String deleteUserById (@PathParam("id") String id) {
        Contexte context = new Contexte();
        ArrayList<Utilisateur> arrayUser = context.getUserList();
        
        for(int i =0; i< arrayUser.size(); i++) {
            if (arrayUser.get(i).getId().equals(id)){
                Utilisateur user = arrayUser.get(i);
                arrayUser.remove(i);
                context.setUserList(arrayUser);
                return user.toXML();
            }
        }
        return null;
    }
    
    
    
    
}
