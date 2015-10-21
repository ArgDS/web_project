package app.mihailov.application;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;



/**
 * Created by Дмитрий
 * Date: 21.10.2015.
 */
public class MainServer {

    public static void main(String[] args) {
        System.setProperty("org.apache.jasper.compiler.disablejsr199","true");
        String webappDirLocation = "src/main/webapp";

        String webPort = System.getenv("PORT");
        if(webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }

        Server server = new Server(Integer.valueOf(webPort));
        WebAppContext root = new WebAppContext();

        root.setContextPath("/");
        root.setDescriptor(webappDirLocation+"/WEB-INF/web.xml");
        root.setResourceBase(webappDirLocation);
        root.setParentLoaderPriority(true);

        server.setHandler(root);
        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            server.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
