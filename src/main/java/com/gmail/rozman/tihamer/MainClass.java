package com.gmail.rozman.tihamer;

import org.apache.wicket.protocol.http.WicketFilter;
import org.apache.wicket.protocol.http.WicketServlet;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.bio.SocketConnector;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Created by trozman on 2015. 09. 16..
 */
public class MainClass {
    public static void main(String[] args) {

        // Object that holds, and configures the WicketServlet.
        ServletHolder servletHolder = new ServletHolder(new WicketServlet());
        servletHolder.setInitParameter("applicationClassName", "com.gmail.rozman.tihamer.WebbApp");
        servletHolder.setInitParameter(WicketFilter.FILTER_MAPPING_PARAM, "/*");
        servletHolder.setInitOrder(1);

        // Web context configuration.
        WebAppContext context = new WebAppContext();
        context.addServlet(servletHolder, "/*");
        context.setResourceBase("."); // Web root directory.

        // The HTTP-server on port 8080.
        Server server = new Server();
        SocketConnector connector = new SocketConnector();
        connector.setPort(8080);
        server.setConnectors(new Connector[]{connector});
        server.setHandler(context);

        try {
            // Start HTTP-server.
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}