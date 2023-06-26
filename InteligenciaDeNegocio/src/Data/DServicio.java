/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import coneccionsocket.ClientPsql;
import java.sql.PreparedStatement;
import java.sql.SQLException;



import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author HP
 */

public class DServicio {
    
    ClientPsql conn;
    DUsers us;
    
    int id,idpac,idpers;
    String nombre,detalle,fecha,tipo,correoPac,correoPers ;
    

    public static final String[] headers = {
           "id","idpac","idpers","nombre","detalle","fecha","tipo"
    };
    
    public DServicio(){
        conn = new ClientPsql();
    }
    
    public void setId(int id){
        this.id=id;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setIdpac(String correoPac) throws SQLException {
        int pacId  ;
        pacId = us.getIdByEmail(correoPac);
        this.idpac = pacId;
    }

    public void setIdpers(String correoPers)throws SQLException {
        int perId;
        perId=us.getIdByEmail(correoPers);
        this.idpers = perId;
    }

    
    
    public void insertar() throws SQLException{
        int pacId,perId ;
        pacId=us.getIdByEmail(correoPac) ;
        perId=us.getIdByEmail(correoPers);
        if (pacId!= -1 && perId!= -1) {
            String sql="INSERT INTO pacientes(id,idpac,idpers,nombre,detalle,fecha,tipo)"+
                    " Values(?,?,?,?,?,?,?)";
            PreparedStatement ps = new ClientPsql().conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, pacId);
            ps.setInt(3, perId);
            ps.setString(4, nombre);
            ps.setString(5, detalle);
            ps.setString(6, fecha);
            ps.setString(8, tipo);
            ps.setString(9, "");

            if(ps.executeUpdate()==0){
                System.err.println("Class DPaciente.java dice: "
                +"Ocurrio un error al insertar Paciente insertar()");
                throw new SQLException();
            } 
        }
    }

    
    public void desconectar() {
        if (conn != null) {
            conn.closeConection();
        }
    }


    
}
