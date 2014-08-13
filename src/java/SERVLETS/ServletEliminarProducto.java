/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SERVLETS;

import DAO.ProductoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author David
 */
public class ServletEliminarProducto extends HttpServlet {

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
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            String xml = "";
            int idProducto=Integer.parseInt(request.getParameter("productoID"));
            System.out.println("producto: "+idProducto);
                      
            ProductoDAO dao = new ProductoDAO();            
            xml = generarXML(dao.eliminarProducto(idProducto));
            System.out.println("valor booleano"+xml);
            
            response.setContentType("txt/xml;charset=UTF-8");
            response.getWriter().write(xml);
            out.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServletEliminarProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String generarXML(boolean producto){
        StringBuilder xml = new StringBuilder();
        xml.append("<resultado>");
    xml.append("<respuesta>");
    xml.append("<productoID>");
    xml.append(producto);
    xml.append("</productoID>");
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
