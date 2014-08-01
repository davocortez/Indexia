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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author David
 */
@WebServlet(name = "ServletRegistrarProducto", urlPatterns = {"/ServletRegistrarProducto"})
public class ServletRegistrarProducto extends HttpServlet {

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
        String nombre = request.getParameter("nombreProducto");
        String tipo = request.getParameter("tipoProducto");
        String cantidad = request.getParameter("cantidadProducto");
        String marca = request.getParameter("marcaProducto");
        String precioCompra = request.getParameter("precioCompra");
        String precioVenta = request.getParameter("precioVenta");
        String cantidadMinima = request.getParameter("cantidadMin");
        String descripcion = request.getParameter("descripcion");

        ProductoDAO dao = new ProductoDAO();

        xml = generarXML(dao.insertarProducto(nombre, tipo, cantidad, marca,
                precioCompra, precioVenta, cantidadMinima, descripcion));
        
        response.setContentType("txt/xml;charset=UTF-8");
        response.getWriter().write(xml);
        out.close();
    }

    public String generarXML(boolean resultado) {
        StringBuilder xml = new StringBuilder();

        xml.append("<resultado>");
        xml.append("<respuesta>");
        xml.append("<producto>");
        xml.append(resultado);
        xml.append("</producto>");
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
