/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package SERVLETS;
//
//import Utilerias.ConexionSQLServer;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.servlet.ServletException;
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JRExporter;
//import net.sf.jasperreports.engine.JRExporterParameter;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.export.JRPdfExporter;
//import net.sf.jasperreports.engine.util.JRLoader;
//
///**
// *
// * @author David
// */
//public class ServletReporte extends HttpServlet {
//
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException, JRException {
//        response.setContentType("text/html;charset=UTF-8");
//        try {
//            ServletOutputStream out = response.getOutputStream();
//            Connection con = null;
//            try {
//                con = ConexionSQLServer.getConnection();
//            } catch (SQLException ex) {
//                Logger.getLogger(ServletReporte.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            Map parametros = new HashMap();
//            parametros.clear();
//            parametros.put("lugarReporte", getServletContext().getRealPath("/Reportes/reportVentaProducto.jasper"));
//            JasperReport reporteGeneral = (JasperReport) JRLoader.loadObject(getServletContext().getRealPath("Reportes/reportVentaProducto.jasper"));
//            JasperPrint jasperPrint = JasperFillManager.fillReport(reporteGeneral, parametros, con);
//            response.setContentType("reportVentaProducto.pdf");
//            JRExporter exporter = new JRPdfExporter();
//            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
//            exporter.exportReport();
//            String xml = "";
//            if (true) {
//                xml = generarXML(true);
//            } else {
//                xml = generarXML(false);
//            }
//
//        } finally {
//        }
//    }
//
//    public String generarXML(boolean respuesta) {
//        StringBuilder xml = new StringBuilder();
//        xml.append("<resultado>");
//        xml.append("<respuesta>");
//        xml.append("</respuesta>");
//        xml.append("</resultado>");
//        return xml.toString();
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        try {
//            processRequest(request, response);
//        } catch (JRException ex) {
//            Logger.getLogger(ServletReporte.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        try {
//            processRequest(request, response);
//        } catch (JRException ex) {
//            Logger.getLogger(ServletReporte.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
