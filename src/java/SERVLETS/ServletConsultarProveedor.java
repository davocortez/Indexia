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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author David
 */
@WebServlet(name = "ServletProveedor", urlPatterns = {"/ServletProveedor"})
public class ServletConsultarProveedor extends HttpServlet {

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
        try {

            ProveedorBean proveedor = new ProveedorBean();
            List listaProveedor = new ArrayList();
            ProveedorDAO prDao = new ProveedorDAO();
            listaProveedor = prDao.consultaProveedor();
            
            String xml = generarConsultaXml(listaProveedor);
            response.setContentType("text/xml;charset=UTF-8");
            response.getWriter().write(xml);

        } finally {

        }
    }

    public String generarConsultaXml(List<ProveedorBean> proveedor) {
        StringBuffer xml = new StringBuffer();

        xml.append("<resultado>");
        xml.append("<proveedor>");
        for (ProveedorBean beanProveedor : proveedor) {
            xml.append("<provedorBean>");

            xml.append("<idProveedor>");
            xml.append(beanProveedor.getIdProvedor());
            xml.append("</idProveedor>");

            xml.append("<nombre>");
            xml.append(beanProveedor.getNombre());
            xml.append("</nombre>");

            xml.append("<telefono>");
            xml.append(beanProveedor.getTelefono());
            xml.append("</telefono>");

            xml.append("<direccion>");
            xml.append(beanProveedor.getDireccion());
            xml.append("</direccion>");

            xml.append("<correo>");
            xml.append(beanProveedor.getCorreo());
            xml.append("</correo>");

            xml.append("<estado>");
            xml.append(beanProveedor.getEstado());
            xml.append("</estado>");

            xml.append("<tipoProveedor>");
            xml.append(beanProveedor.getIdTipoProveedor());
            xml.append("</tipoProveedor>");

            xml.append("</provedorBean>");
        }
        xml.append("</proveedor>");
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
