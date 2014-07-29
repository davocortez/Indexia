/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SERVLETS;

import BEAN.ProveedorBean;
import BEAN.TipoProveedorBean;
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
@WebServlet(name = "ServletTipoProveedor", urlPatterns = {"/ServletTipoProveedor"})
public class ServletTipoProveedor extends HttpServlet {

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

            TipoProveedorBean proveedor = new TipoProveedorBean();
            List listaTipoProveedor = new ArrayList();
            ProveedorDAO prDao = new ProveedorDAO();
            listaTipoProveedor = prDao.consultarTipo();
        

            String xml = generarConsultaXml(listaTipoProveedor);
            response.setContentType("text/xml;charset=UTF-8");
            response.getWriter().write(xml);

        } finally {

        }
    }

    public String generarConsultaXml(List<TipoProveedorBean> proveedor) {
        StringBuffer xml = new StringBuffer();

        xml.append("<resultado>");
        xml.append("<proveedoresPro>");
        for (TipoProveedorBean bean : proveedor) {
            xml.append("<tipoProvedor>");

            xml.append("<idTipoProveedor>");
            xml.append(bean.getIdTipoProvedor());
            xml.append("</idTipoProveedor>");

            xml.append("<descripcion>");
            xml.append(bean.getDescripcion());
            xml.append("</descripcion>");            
            
            xml.append("</tipoProvedor>");
        }
        xml.append("</proveedoresPro>");
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
