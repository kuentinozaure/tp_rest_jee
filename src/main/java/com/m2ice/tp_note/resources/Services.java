/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.m2ice.tp_note.resources;

import com.m2ice.util.Contexte;
import com.m2ice.util.Service;
import com.m2ice.util.Utilisateur;
import java.util.ArrayList;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author etu
 */
@Path("services")
public class Services {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Service> getListOfServicesApplication(@QueryParam("cout")Integer cout) {
        Contexte context = new Contexte();
        ArrayList<Service> arrayService = context.getServiceList();
        ArrayList<Service> arrayReturn = new ArrayList<>();
        
        if (cout != null) {
            System.out.println(cout.toString());
            for (int i = 0; i < arrayService.size(); i++) {
                Integer coutService =  Integer.parseInt(arrayService.get(i).getCout());
                if (coutService <= cout) {
                    arrayReturn.add(arrayService.get(i));
                }
            }
        } else {
            arrayReturn = arrayService;
        }
        
        return arrayReturn;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_XML)
    public String getServiceByID(@PathParam("id") String id) {
        Contexte context = new Contexte();
        ArrayList<Service> arrayService = context.getServiceList();

        for (int i = 0; i < arrayService.size(); i++) {
            if (arrayService.get(i).getId().equals(id)) {
                System.out.println(arrayService.get(i));
                return arrayService.get(i).toXML();
            }
        }
        return null;
    }
    
    @GET
    @Path("/users/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Service> getServiceByUser(@PathParam("id") String id) {
        Contexte context = new Contexte();
        ArrayList<Service> arrayService = context.getServiceList();
        ArrayList<Service> returnArray = new ArrayList<>();

        for (int i = 0; i < arrayService.size(); i++) {
            if (arrayService.get(i).getCreatedBy().equals(id)) {
                System.out.println(arrayService.get(i));
               returnArray.add(arrayService.get(i));
            }
        }
        return returnArray;
    }
    
    @POST
    @Path("/users/{id}")
    @Produces(MediaType.TEXT_XML)
    public String createUserService(@PathParam("id") String id,String content) {
        Contexte context = new Contexte();
        ArrayList<Service> arrayService = context.getServiceList();
        Service serv = new Service(content);
        serv.setCreatedBy(id);
        arrayService.add(serv);
        context.setServiceList(arrayService);
        return serv.toXML();
    }

    @PUT
    @Path("/{id}")
    public String updateServiceByID(@PathParam("id") String id, String content) {
        Contexte context = new Contexte();
        ArrayList<Service> arrayService = context.getServiceList();
        Service putService = new Service(content);

        Service serv;
        String returnValue = null;

        for (int i = 0; i < arrayService.size(); i++) {
            if (arrayService.get(i).getId().equals(id)) {
                serv = arrayService.get(i); // get user by id
                arrayService.remove(i); // remove user

                System.out.println(returnValue);
                // check if the name are not the same
                if (!serv.getNom().equals(putService.getNom())) {
                    serv.setNom(putService.getNom());
                }

                // check if the cout is not the same
                if (!serv.getCout().equals(putService.getCout())) {
                    serv.setCout(putService.getCout());
                }
 
                if (!serv.getUniteLocation().equals(putService.getUniteLocation())) {
                    serv.setUniteLocation(putService.getUniteLocation());
                }

                // adding user in arraylist
                arrayService.add(serv);
                context.setServiceList(arrayService);

                returnValue = serv.toXML();
            }
        }

        return returnValue;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_XML)
    public String deleteServiceById(@PathParam("id") String id) {
        Contexte context = new Contexte();
        ArrayList<Service> arrayService = context.getServiceList();

        for (int i = 0; i < arrayService.size(); i++) {
            if (arrayService.get(i).getId().equals(id)) {
                Service serv = arrayService.get(i);
                arrayService.remove(i);
                context.setServiceList(arrayService);
                return serv.toXML();
            }
        }
        return null;
    }
}
