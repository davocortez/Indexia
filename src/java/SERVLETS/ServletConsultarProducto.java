/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETS;
///puto
import BEAN.ProductoBean;
import BEAN.ProveedorBean;
import DAO.ProductoDAO;
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
@WebServlet(name = "ServletProducto", urlPatterns = {"/ServletProducto"})
public class ServletConsultarProducto extends HttpServlet {

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

            ProductoBean bean = new ProductoBean();
            List listaProductos = new ArrayList();
            ProductoDAO Dao = new ProductoDAO();
            listaProductos = Dao.consultarProductos();
            String xml = generarProductoXML(listaProductos);
            response.setContentType("text/xml;charset=UTF-8");
            response.getWriter().write(xml);

        } finally {

        }
    }

    public String generarProductoXML(List<ProductoBean> bean) {
        StringBuilder xml = new StringBuilder();

        xml.append("<resultado>");
        xml.append("<bean>");
        for (ProductoBean productoBean : bean) {
            xml.append("<productoBean>");

                xml.append("<idProducto>");
                xml.append(productoBean.getIdProducto());
                xml.append("</idProducto>");

                xml.append("<nombre>");
                xml.append(productoBean.getNombre());
                xml.append("</nombre>");
                
                xml.append("<tipo>");
                xml.append(productoBean.getTipo());
                xml.append("</tipo>");
                
                xml.append("<marca>");
                xml.append(productoBean.getMarca());
                xml.append("</marca>");

                xml.append("<descripcion>");
                xml.append(productoBean.getDescripcion());
                xml.append("</descripcion>");

                xml.append("<precioVenta>");
                xml.append(productoBean.getPrecioVenta());
                xml.append("</precioVenta>");

                xml.append("<precioCompra>");
                xml.append(productoBean.getPrecioCompra());
                xml.append("</precioCompra>");
                
                xml.append("<cantidadMinima>");
                xml.append(productoBean.getCantidadMinima());
                xml.append("</cantidadMinima>");
                
                xml.append("<cantidad>");
                xml.append(productoBean.getCantidad());
                xml.append("</cantidad>");
            xml.append("</productoBean>");

        }
        xml.append("</bean>");
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
