/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SERVLETS;

import BEAN.ProductoBean;
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
public class ServletModificarProducto extends HttpServlet {

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
        String xml="";
        PrintWriter out = response.getWriter();
        try {
            ProductoBean bean=new ProductoBean();
            ProductoDAO  dao=new ProductoDAO();
            String idProducto=request.getParameter("idProducto");
            String nombre = request.getParameter("nombreProducto");
            String tipo = request.getParameter("tipo");
            String cantidad= request.getParameter("cantidad");
            String marcar=request.getParameter("marca");
            String precioCompra = request.getParameter("precioCompra");
            String precioVenta = request.getParameter("precioVenta");
            String cantidadMin = request.getParameter("cantidadMin");
            String descripcion = request.getParameter("descripcion");
            
           bean.setIdProducto(idProducto);
            bean.setNombre(nombre);
            bean.setTipo(tipo);
            bean.setCantidad(cantidad);
            bean.setMarca(marcar);
            bean.setPrecioCompra(precioCompra);
            bean.setPrecioVenta(precioVenta);
            bean.setCantidadMinima(cantidadMin);
            bean.setDescripcion(descripcion);            
             xml=generarXML(dao.modificarProducto(bean));
            response.setContentType("text/xml;charset=UTF-8");
            response.getWriter().write(xml);
        } catch (SQLException ex) {
            Logger.getLogger(ServletModificarProducto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }

    
    public String generarXML(boolean producto){
        StringBuilder xml = new StringBuilder();
        xml.append("<resultado>");
    xml.append("<respuesta>");
    xml.append("<evento>");
    xml.append(producto);
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
