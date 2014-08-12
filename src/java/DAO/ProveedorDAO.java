/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEAN.ProveedorBean;
import BEAN.TipoProveedorBean;
import Utilerias.ConexionSQLServer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class ProveedorDAO {

    String insert = "insert into Proveedor(nombre,telefono,direccion,Correo,idTipoProvedor)values(?,?,?,?,?)";
    String consultar = "select * from Proveedor";
    String consultarTipo = "select * from TipoProvedor";
    String modificarProveedor = " UPDATE Proveedor Set Nombre=?,Telefono=?,Direccion=?,Correo=? WHERE idProvedor=?;";

    public boolean insertarProveedor(String nombre,String telefono,String direccion,String correo, int idTipo) {
        boolean status = false;
        try {
            Connection con = ConexionSQLServer.getConnection();
            PreparedStatement ps = con.prepareStatement(insert);
            
            ps.setString(1, nombre);
            ps.setString(2, telefono);
            ps.setString(3, direccion);
            ps.setString(4, correo);
            ps.setInt(5, idTipo);
       
            status = ps.executeUpdate()==1;
            
            ps.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }


    public List consultaProveedor() {
        List listaProveedor = new ArrayList();
        try {
            Connection con = ConexionSQLServer.getConnection();
            PreparedStatement ps = con.prepareStatement(consultar);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProveedorBean pbean = new ProveedorBean();

                pbean.setIdProvedor(rs.getString(1));
                pbean.setNombre(rs.getString(2));
                pbean.setTelefono(rs.getString(3));
                pbean.setDireccion(rs.getString(4));
                pbean.setCorreo(rs.getString(5));
                pbean.setEstado(rs.getString(6));
                pbean.setIdTipoProveedor(rs.getString(7));
                listaProveedor.add(pbean);

            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaProveedor;
    }

    public List consultarTipo() {
        List listaTipoProveedor = new ArrayList();

        try {
            Connection con = ConexionSQLServer.getConnection();
            PreparedStatement ps = con.prepareStatement(consultarTipo);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TipoProveedorBean bean = new TipoProveedorBean();

                bean.setIdTipoProvedor(rs.getInt(1));
                bean.setDescripcion(rs.getString(2));
                listaTipoProveedor.add(bean);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaTipoProveedor;

    }
    
     public boolean modificarProveedor(ProveedorBean beanProveedor) {
        boolean resultado = false;
        try {
            Connection con = ConexionSQLServer.getConnection();
            PreparedStatement ps = con.prepareStatement(modificarProveedor);

            ps.setString(1, beanProveedor.getNombre());
            ps.setString(2, beanProveedor.getTelefono());
            ps.setString(3, beanProveedor.getDireccion());
            ps.setString(4, beanProveedor.getCorreo());
            ps.setString(5, beanProveedor.getIdProvedor());
            resultado = ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }

}
