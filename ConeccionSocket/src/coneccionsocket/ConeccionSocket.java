/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package coneccionsocket;

/**
 *
 * @author HP
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConeccionSocket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try {
            ClientPsql coneccion = new ClientPsql();
            String sql= "Select * From usuarios Where id=1";
            PreparedStatement ps = new ClientPsql().conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println("Resultado " + rs.next());
            
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
