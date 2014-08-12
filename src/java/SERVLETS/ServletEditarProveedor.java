/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SERVLETS;

import BEAN.ProveedorBean;
import DAO.ProveedorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Erick Herrera
 */
public class ServletEditarProveedor extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String xml="";
        try {
            /* TODO output your page here. You may use following sample code. */
            ProveedorBean beanProveedor = new ProveedorBean();
            ProveedorDAO  daoProveedor = new ProveedorDAO();

            String idProveedor=request.getParameter("idProveedor");
            String nombre=request.getParameter("nombre");
            String telefono=request.getParameter("telefono");
            String direccion=request.getParameter("direccion");
            String correo=request.getParameter("correo");
            String estado=request.getParameter("estado");
            String tipoProveedor=request.getParameter("tipoProveedor");
   
            beanProveedor.setIdProvedor(idProveedor);
            beanProveedor.setNombre(nombre);
            beanProveedor.setTelefono(telefono);
            beanProveedor.setDireccion(direccion);
            beanProveedor.setCorreo(correo);
            beanProveedor.setEstado(estado);
            beanProveedor.setIdTipoProveedor(tipoProveedor);

            xml=generarXML(daoProveedor.modificarProveedor(beanProveedor));
            response.setContentType("text/xml;charset=UTF-8");
            response.getWriter().write(xml);
        } finally {
            out.close();
        }
    }
    
    private String generarXML(boolean modificarProveedor) {
    
        StringBuilder xml = new StringBuilder();
        xml.append("<resultado>");
        xml.append("<respuesta>");
        xml.append("<evento>");
        xml.append(modificarProveedor);
        xml.append("</evento>");
        xml.append("</respuesta>");
        xml.append("</resultado>");
        
        return  xml.toString();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
