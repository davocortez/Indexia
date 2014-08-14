/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEAN.VentaBean;
import Utilerias.ConexionSQLServer;
import java.sql.CallableStatement;
import java.sql.Connection;

/**
 *
 * @author David
 */
public class VentaDAO {

    public String venta = "{CALL cobrar(?,?,?,?)};";

    public boolean cobrarVenta(String productoID, String precio, String cantidad, String ventaID) {

        boolean status = false;
        try {
            VentaBean bean=new VentaBean();
            Connection con = ConexionSQLServer.getConnection();
            CallableStatement cal = con.prepareCall(venta);
            cal.setString(1, productoID);
            cal.setString(2, precio);
            cal.setString(3, cantidad);
            cal.setString(4, ventaID);

            status = cal.executeUpdate() == 1;
            cal.close();
            con.close();

            

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;

    }
}
