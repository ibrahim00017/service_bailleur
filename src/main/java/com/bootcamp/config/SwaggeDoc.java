/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.config;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author ARESKO
 */
@Path("/swagger-doc")
public class SwaggeDoc {
    @GET
    @Path("/")
    public Response home() {

        String output = " SWAGGER Documentation ";
        
        return Response.status(200).entity(output).build();

    }
}
