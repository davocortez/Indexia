/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Utilerias.ConexionSQLServer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author David
 */
public class LoginDAO {
    
    String queryLogin="select * from Usuario where Usuario=? and Contrasena=?";
    
     public boolean validarUsuario(String nombreUsuario, String password) throws SQLException {
        boolean validateOK = false;
        try {
            System.out.println("entroooooooooooooo al daooooooooooooo");
            Connection db = ConexionSQLServer.getConnection();
            PreparedStatement ps = db.prepareStatement(this.queryLogin);
            ps.setString(1, nombreUsuario);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            validateOK = rs.next();
            ps.close();
            db.close();
        } catch (SQLException sqle) {
            System.err.println("Error en el método DAO Validate: " + sqle);
        }
        return validateOK;
    }
}
