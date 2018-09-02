package com.example;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class HalloWeltTestClient {

    public static void main(String... args) {
        Client client = ClientBuilder.newClient();

        Auftrag result = listeEinenAuftrag(client);
        System.out.println(result);
    }


    public static Auftrag listeEinenAuftrag(Client c) {

        WebTarget wTarget = c.target("http://localhost:4434/helloworld/Auftrag/{id}");

        Invocation.Builder invocationBuilder = wTarget.resolveTemplate("id", 1).request(MediaType.APPLICATION_XML);

        Response response = invocationBuilder.get();

        return response.readEntity(Auftrag.class);
    }
}
