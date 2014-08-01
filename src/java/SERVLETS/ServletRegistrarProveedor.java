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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author David
 */
@WebServlet(name = "ServletRegistrarProveedor", urlPatterns = {"/ServletRegistrarProveedor"})
public class ServletRegistrarProveedor extends HttpServlet {

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
        String xml = "";

        ProveedorDAO daoProveedor = new ProveedorDAO();
        ProveedorBean bean = new ProveedorBean();
        int tipo = 0;

        String nombre = request.getParameter("nombre");
        System.out.println("campo de texto nombre: " + nombre);
        String telefono = request.getParameter("telefono");
        System.out.println("campo de texto telefono: " + telefono);
        String direccion = request.getParameter("direccion");
        System.out.println("campo de texto direccion: " + direccion);
        String correo = request.getParameter("correo");
        System.out.println("campo de texto correo: " + correo);
        String type = request.getParameter("tipoProveedor");
        tipo = Integer.parseInt(type);
        
        xml=generarXML(daoProveedor.insertarProveedor(nombre, telefono, direccion, correo, tipo+1));
        response.setContentType("txt/xml;charset=UTF-8");
        response.getWriter().write(xml);
        out.close();
    }

    public String generarXML(boolean resultado) {
        StringBuilder xml = new StringBuilder();

        xml.append("<resultado>");
        xml.append("<respuesta>");
        xml.append("<proveedor>");
        xml.append(resultado);
        xml.append("</proveedor>");
        xml.append("</respuesta>");
        xml.append("</resultado>");

        return xml.toString();

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
