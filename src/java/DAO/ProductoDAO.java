/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEAN.ProductoBean;
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
public class ProductoDAO {

    String registrar = "insert into Producto(nombre,tipo,cantidad,marca,precioCompra"
            + ",precioVenta,cantidadMinima,descripcionProducto)values(?,?,?,?,?,?,?,?)";
    String sQlConsultarProducto = "select * from Producto where estado=1";
    String modificar = "UPDATE Producto SET nombre=(?), tipo=(?), cantidad=(?), marca=(?), precioCompra=(?), "
            + "precioVenta=(?), cantidadMinima=(?),descripcionProducto=(?) WHERE idProducto =?";
    String eliminar = "update producto set estado=0 where idProducto=?";

    public boolean insertarProducto(String nombre, String tipo, String cantidad, String marca,
            String precioCompra, String precioVenta, String cantidadMinima, String descripcionProducto) {
        boolean status = false;
        try {
            Connection con = ConexionSQLServer.getConnection();
            PreparedStatement ps = con.prepareStatement(registrar);

            ps.setString(1, nombre);
            ps.setString(2, tipo);
            ps.setString(3, cantidad);
            ps.setString(4, marca);
            ps.setString(5, precioCompra);
            ps.setString(6, precioVenta);
            ps.setString(7, cantidadMinima);
            ps.setString(8, descripcionProducto);

            status = ps.executeUpdate() == 1;
            ps.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public List consultarProductos() {
        List listaProductos = new ArrayList();
        try {
            Connection con = ConexionSQLServer.getConnection();
            PreparedStatement ps = con.prepareStatement(sQlConsultarProducto);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductoBean bean = new ProductoBean();
                bean.setIdProducto(rs.getString(1));
                bean.setNombre(rs.getString(2));
                bean.setTipo(rs.getString(3));
                bean.setCantidad(rs.getString(4));
                bean.setMarca(rs.getString(5));
                bean.setPrecioCompra(rs.getString(6));
                bean.setPrecioVenta(rs.getString(7));
                bean.setCantidadMinima(rs.getString(8));
                bean.setDescripcion(rs.getString(9));

                listaProductos.add(bean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaProductos;
    }

    public boolean modificarProducto(ProductoBean bean) throws SQLException {
        boolean resultado = false;
        try {
            Connection con = ConexionSQLServer.getConnection();
            PreparedStatement ps = con.prepareStatement(modificar);
            ps.setString(1, bean.getNombre());
            ps.setString(2, bean.getTipo());
            ps.setString(3, bean.getCantidad());
            ps.setString(4, bean.getMarca());
            ps.setString(5, bean.getPrecioCompra());
            ps.setString(6, bean.getPrecioVenta());
            ps.setString(7, bean.getCantidadMinima());
            ps.setString(8, bean.getDescripcion());
            ps.setString(9, bean.getIdProducto());

            resultado = ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;

    }

    public boolean eliminarProducto(int eliminarID) throws SQLException {
        boolean resultado = false;
        try{
        Connection con = ConexionSQLServer.getConnection();
        PreparedStatement ps = con.prepareStatement(eliminar);
         ps.setInt(1, eliminarID);
         
         resultado=ps.executeUpdate()==1;
          ps.close();
            con.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }return resultado;

    }
}
