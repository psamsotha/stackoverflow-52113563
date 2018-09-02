package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path( HalloWeltWebservices.webContextPath )
public class HalloWeltWebservices
{
    public static final String webContextPath = "/helloworld";

    @GET
    @Path ("/Auftrag/{id}")
    @Produces( MediaType.APPLICATION_XML )
    public Response zeigeAuftrag( @PathParam("id") int id )
    {
        Auftrag auftrag = new Auftrag();
        auftrag.setId(1);
        auftrag.setNr(1);
        auftrag.setAuftragsname("Einrichtung");

        GenericEntity<Auftrag> entity = new GenericEntity<Auftrag>(auftrag, Auftrag.class);

        return Response
                .ok()
                .entity(entity)
                .build();
    }
}