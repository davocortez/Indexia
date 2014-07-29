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

    String insert = "insert into Proveedor(nombre,telefono,direccion,Correo,estado,idTipoProvedor)values(?,?,?,?,?,?)";
    String consultar = "select * from Proveedor";
    String consultarTipo = "select * from TipoProvedor";

    public boolean insertarProveedor(ProveedorBean bean) {
        boolean status = false;
        try {
            Connection con = ConexionSQLServer.getConnection();
            PreparedStatement ps = con.prepareStatement(insert);

            ps.setString(1, bean.getNombre());
            ps.setString(2, bean.getTelefono());
            ps.setString(3, bean.getDireccion());
            ps.setString(4, bean.getCorreo());
            ps.setInt(5, 1);
            ps.setInt(6, bean.getIdTipoProveedor());
            
            status = ps.executeUpdate()==1;
            ps.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
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

                pbean.setIdProvedor(rs.getInt(1));
                pbean.setNombre(rs.getString(2));
                pbean.setTelefono(rs.getString(3));
                pbean.setDireccion(rs.getString(4));
                pbean.setCorreo(rs.getString(5));
                pbean.setEstado(rs.getByte(6));
                pbean.setIdTipoProveedor(rs.getInt(7));
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
}
