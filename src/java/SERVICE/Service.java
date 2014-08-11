/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SERVICE;

import DAO.UsuarioDAO;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Feer
 */
@WebService(serviceName = "Service")
public class Service {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "agregarUsuario")
    public String agregarUsuario(@WebParam(name = "usuario") String usuario, @WebParam(name = "contrasena") String contrasena, @WebParam(name = "idTipoUsuario") String idTipoUsuario) {
        //TODO write your implementation code here:
        UsuarioDAO dao = new UsuarioDAO();
        String respuesta = "false";        
        if(dao.insertarUsuario(usuario, contrasena, idTipoUsuario)){
            respuesta = "true";
        }        
        return respuesta;
    }
}
