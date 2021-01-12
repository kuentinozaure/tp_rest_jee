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

/**
 *
 * @author etu
 */
@Path("users")
public class Utilisateurs {
    
    @GET
    public ArrayList<Utilisateur> getListOfUserApplication() {
        ArrayList<Utilisateur> arrayUser = new ArrayList<>();
        
        arrayUser.add(new Utilisateur("NOM=AUBRY;PRENOM=QUENTIN;ID=1"));
                
        return arrayUser;
    }
    
    @POST
    public String createAnUser(String content) {
        return "";
    }
    
    @GET 
    @Path("/{id}")
    public Utilisateur getUserById () {
        return null;
    }
    
    @PUT 
    @Path("/{id}")
    public Utilisateur updateUserById () {
        return null;
    }
    
        
    @DELETE 
    @Path("/{id}")
    public Utilisateur deleteUserById () {
        return null;
    }
    
    
    
    
}
