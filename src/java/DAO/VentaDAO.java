/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Utilerias.ConexionSQLServer;
import java.sql.CallableStatement;
import java.sql.Connection;

/**
 *
 * @author David
 */
public class VentaDAO {

    public String venta = "{CALL cobrar(?,?,?,?)};";

    public boolean cobrarVenta(int productoID, String precio, String cantidad, String ventaID) {

        boolean status = false;
        try {

            Connection con = ConexionSQLServer.getConnection();
            CallableStatement cal = con.prepareCall(venta);
            cal.setInt(1, productoID);
            cal.setString(2, precio);
            cal.setString(3, cantidad);
            cal.setString(4, ventaID);

            cal.close();
            con.close();

            status = cal.executeUpdate() == 1;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;

    }
}
