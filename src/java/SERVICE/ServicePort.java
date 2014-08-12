/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SERVICE;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author Erick Herrera
 */
@Path("serviceport")
public class ServicePort {
    private SERVICE_client.Service port;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServicePort
     */
    public ServicePort() {
        port = getPort();
    }

    /**
     * Invokes the SOAP method iniciarSesion
     * @param usuario resource URI parameter
     * @param contrasena resource URI parameter
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("iniciarsesion/")
    public String getIniciarSesion(@QueryParam("usuario") String usuario, @QueryParam("contrasena") String contrasena) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.lang.String result = port.iniciarSesion(usuario, contrasena);
                return result;
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method agregarUsuario
     * @param usuario resource URI parameter
     * @param contrasena resource URI parameter
     * @param idTipoUsuario resource URI parameter
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("agregarusuario/")
    public String getAgregarUsuario(@QueryParam("usuario") String usuario, @QueryParam("contrasena") String contrasena, @QueryParam("idTipoUsuario") String idTipoUsuario) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.lang.String result = port.agregarUsuario(usuario, contrasena, idTipoUsuario);
                return result;
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method hello
     * @param name resource URI parameter
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("hello/")
    public String getHello(@QueryParam("name") String name) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.lang.String result = port.hello(name);
                return result;
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     *
     */
    private SERVICE_client.Service getPort() {
        try {
            // Call Web Service Operation
            SERVICE_client.Service_Service service = new SERVICE_client.Service_Service();
            SERVICE_client.Service p = service.getServicePort();
            return p;
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }
}
