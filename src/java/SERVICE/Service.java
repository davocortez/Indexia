/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SERVICE;

import BEAN.ProductoBean;
import DAO.LoginDAO;
import DAO.ProductoDAO;
import DAO.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

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

    /**
     * Web service operation
     */
    @WebMethod(operationName = "iniciarSesion")
    public String iniciarSesion(@WebParam(name = "usuario") String usuario, @WebParam(name = "contrasena") String contrasena) {
        //TODO write your implementation code here:
        LoginDAO dao=new LoginDAO();
        String respuesta = "false";
        try {
            if(dao.validarUsuario(usuario, contrasena)){
                respuesta = "true";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "consultarPedidos")
    public List consultarPedidos() {
        ProductoDAO dao=new ProductoDAO();
        List<ProductoBean> listaProductos = new ArrayList<ProductoBean>();
        for (int i = 0; i < dao.consultarProductos().size(); i++) {
            ProductoBean bean = new ProductoBean();
            
            bean =(ProductoBean) dao.consultarProductos().get(i);
            
            listaProductos.add(bean);


        
    }
    return listaProductos;
    
}
    }
