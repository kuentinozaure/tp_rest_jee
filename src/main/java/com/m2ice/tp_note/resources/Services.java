/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.m2ice.tp_note.resources;

import com.m2ice.util.Contexte;
import com.m2ice.util.Facture;
import com.m2ice.util.Realisation;
import com.m2ice.util.Service;
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
    /**
     * This method return the entire list of service of the app
     *
     * @param cout is the http query param to filter service by price
     * @return the list of the service of the app or the list filtered by price
     *
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Service> getListOfServicesApplication(@QueryParam("cout") Integer cout) {
        Contexte context = Contexte.getSingleton();
        ArrayList<Service> arrayService = context.getServiceList();
        ArrayList<Service> arrayReturn = new ArrayList<>();

        if (cout != null) {
            System.out.println(cout.toString());
            for (int i = 0; i < arrayService.size(); i++) {
                Integer coutService = Integer.parseInt(arrayService.get(i).getCout());
                if (coutService <= cout) {
                    arrayReturn.add(arrayService.get(i));
                }
            }
        } else {
            arrayReturn = arrayService;
        }

        return arrayReturn;
    }

    /**
     * This method get a service by his id
     *
     * @param id the id of the service passing by path parameter
     * @return the service filtered by id
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_XML)
    public String getServiceByID(@PathParam("id") String id) {
        Contexte context = Contexte.getSingleton();
        ArrayList<Service> arrayService = context.getServiceList();

        for (int i = 0; i < arrayService.size(); i++) {
            if (arrayService.get(i).getId().equals(id)) {
                System.out.println(arrayService.get(i));
                return arrayService.get(i).toXML();
            }
        }
        return null;
    }

    /**
     * This method can return the service posted by user
     *
     * @param id this is the id of user passing by http parameter
     * @return the list of service posted by user
     */
    @GET
    @Path("/users/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Service> getServiceByUser(@PathParam("id") String id) {
        Contexte context = Contexte.getSingleton();
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

    /**
     * This method create a post for a selected user
     *
     * @param id this is the id of user who want create a post passing by http
     * parameter
     * @param content is the content of the new post
     * @return the service created
     */
    @POST
    @Path("/users/{id}")
    @Produces(MediaType.TEXT_XML)
    public String createUserService(@PathParam("id") String id, String content) {
        Contexte context = Contexte.getSingleton();
        ArrayList<Service> arrayService = context.getServiceList();
        Service serv = new Service(content);
        serv.setCreatedBy(id);
        arrayService.add(serv);
        context.setServiceList(arrayService);
        return serv.toXML();
    }

    /**
     * This methode can update a service by his id
     *
     * @param id is the id of service
     * @content is the content of the updated service
     * @return return the element updated
     */
    @PUT
    @Path("/{id}")
    public String updateServiceByID(@PathParam("id") String id, String content) {
        Contexte context = Contexte.getSingleton();
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

    /**
     * This method can delete a service by id
     *
     * @param id is the id of service who want deleted
     * @return the service already deleted
     */
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_XML)
    public String deleteServiceById(@PathParam("id") String id) {
        Contexte context = Contexte.getSingleton();
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

    /**
     * This method can get all realisation  by a service
     * @param id is the id of a service
     * @return a list of realisation by service
     */
    @GET
    @Path("/{id}/rendus")
    public ArrayList<Realisation> getRenduByService(@PathParam("id") String id) {
        Contexte context = Contexte.getSingleton();
        ArrayList<Realisation> arrayRealisation = context.getRealisationList();
        ArrayList<Realisation> returnArray = new ArrayList<>();

        for (int i = 0; i < arrayRealisation.size(); i++) {
            // if id of service contained in the array of realisation
            if (arrayRealisation.get(i).getService().getId().equals(id)) {
                // if the realisation is realised
                if (arrayRealisation.get(i).isEstRealisé()) {
                    returnArray.add(arrayRealisation.get(i));
                }

            }
        }

        return returnArray;
    }
    
    /**
     * This method can get by service id and realisation id a realisation
     * @param idServ is the id of service
     * @param idReal  is the id of the realisation
     * @return return a realisation by service id and realisation id
     */
    @GET
    @Path("/{id}/rendus/{idrendu}")
    public Realisation getRealisationByID (@PathParam ("id")String idServ, @PathParam("idrendu")String idReal ) {
        Contexte context = Contexte.getSingleton();
        ArrayList<Realisation> arrayRealisation = context.getRealisationList();
        Realisation real = null;
        
         for (int i = 0; i < arrayRealisation.size(); i++) {
            // if id of service contained in the array of realisation
            if (arrayRealisation.get(i).getService().getId().equals(idServ)) {
                // if the realisation is realised
                if (arrayRealisation.get(i).getID().equals(idReal)) {
                   real = arrayRealisation.get(i);
                }

            }
        }
         return real;
    }
    
    /**
     * Generate a bill by service realisation
     * @param idServ is service id
     * @param idReal is realisation id
     * @return a bill of realisation by service
     */
    @GET
    @Path("/{id}/rendus/{idrendu}/facture")
    public String getFactureByRealisation (@PathParam ("id")String idServ, @PathParam("idrendu")String idReal) {
        Contexte context = Contexte.getSingleton();
        ArrayList<Realisation> arrayRealisation = context.getRealisationList();
       
        
         for (int i = 0; i < arrayRealisation.size(); i++) {
            // if id of service contained in the array of realisation
            if (arrayRealisation.get(i).getService().getId().equals(idServ)) {
                // if the realisation is realised
                if (arrayRealisation.get(i).getID().equals(idReal)) {
                   return new Facture(arrayRealisation.get(i)).toString();
                }

            }
        }
        return null;
    }

}
