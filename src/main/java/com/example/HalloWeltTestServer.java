package com.example;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class HalloWeltTestServer {

    public static String baseUrl = "http://localhost:4434";

    public static void main(String[] args) throws IOException, InterruptedException {

        ResourceConfig resourceConfig = new ResourceConfig(HalloWeltWebservices.class);

        resourceConfig.register(DebugExceptionMapper.class);

        final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(baseUrl), resourceConfig, false);

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                server.shutdownNow();
            }
        }));

        try {

            server.start();

            System.out.println(String.format(
                    "\nGrizzly-HTTP-Server gestartet mit der URL: %s\n"
                            + "Stoppen des Grizzly-HTTP-Servers mit:      Strg+C\n",
                    baseUrl + HalloWeltWebservices.webContextPath));

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {

            Thread.currentThread().join();
            server.shutdown();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}