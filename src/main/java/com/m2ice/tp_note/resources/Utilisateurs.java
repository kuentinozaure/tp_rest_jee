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
    
    /**
     * This method can get the list of all user of application
     * @return the list of the user of application
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Utilisateur> getListOfUserApplication() {
        Contexte context = Contexte.getSingleton();
        ArrayList<Utilisateur> arrayUser = context.getUserList();
        return arrayUser;
    }
    
    /**
     * This method can create a new user
     * @param  content is the content of the new user
     * @return  the value of new user created
     */
    @POST
    @Produces(MediaType.TEXT_XML)
    public String createAnUser(String content) {
        Contexte context = Contexte.getSingleton();
        ArrayList<Utilisateur> arrayUser = context.getUserList();
        Utilisateur user = new Utilisateur(content);
        arrayUser.add(user);
        context.setUserList(arrayUser);
        return user.toXML();
    }
    
    /**
     * This method can get a user by his id
     * @param id is the id of the user passing by http params
     * @return return the value of the user by his selected id
     */
    @GET 
    @Path("/{id}")
    @Produces(MediaType.TEXT_XML)
    public String getUserById (@PathParam("id") String id) {
        Contexte context = Contexte.getSingleton();
        ArrayList<Utilisateur> arrayUser = context.getUserList();
        
        for(int i =0; i< arrayUser.size(); i++) {
            if (arrayUser.get(i).getId().equals(id)){
                System.out.println(arrayUser.get(i));
                return arrayUser.get(i).toXML();
            }
        }
        return null;
    }
    
    /**
     * This method update user by his id
     * @param id is the id of the user selected
     * @param content is the new content of the user selected
     * @return the user updated
     */
    @PUT 
    @Path("/{id}")
    public String updateUserById (@PathParam("id") String id, String content) {
        Contexte context = Contexte.getSingleton();
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
    
    /**
     * This method delete user by his id
     * @param id is the id of the user 
     * @return the deleted user
     */
    @DELETE 
    @Path("/{id}")
    @Produces(MediaType.TEXT_XML)
    public String deleteUserById (@PathParam("id") String id) {
        Contexte context = Contexte.getSingleton();
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
