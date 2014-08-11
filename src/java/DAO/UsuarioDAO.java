/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Utilerias.ConexionSQLServer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Feer
 */
public class UsuarioDAO {
    
    String registrar = "insert into Usuario(Usuario, Contrasena, idTipoUsuario)" +
                       "values(?,?,?);";

    public boolean insertarUsuario(String usuario, String contrasena, String idTipoUsuario) {
        boolean status = false;
        try {
            Connection con = ConexionSQLServer.getConnection();
            PreparedStatement ps = con.prepareStatement(registrar);

            ps.setString(1, usuario);
            ps.setString(2, contrasena);
            ps.setString(3, idTipoUsuario);           

            status = ps.executeUpdate() == 1;
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en en el metodo insertarUsuario() "+ex);
        }
        return status;
    }    
}
