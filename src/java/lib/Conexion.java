/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

/**
 *
 * @author Dahian
 */
public class Conexion {

    Connection con;
    String url = "jdbc:mysql://localhost:3306/turnero";
    String Driver = "com.mysql.jdbc.Driver";
    String user = "root";
    String clave = "";

    PreparedStatement ps;
    ResultSet rs;

    public Connection getCon() {
        return con;
    }

    public PreparedStatement getPs() {
        return ps;
    }

    public ResultSet getRs() {
        return rs;
    }

    public Connection getConexion() {
        return con;
    }

    public void Conectar() throws SQLException {
        try {
            Class.forName(Driver);
            con = DriverManager.getConnection(url, user, clave);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ResultSet realizarConsulta(String query) throws SQLException {
        ps = con.prepareStatement(query);
        rs = ps.executeQuery();
        
        return rs;
    }
    public void ingresarCLiente(int id,String nombre,String producto, String ciudad) throws SQLException{
        
        ps=con.prepareStatement("insert into clientes (id,nombre,producto,ciudad ) values("+id+",'"+nombre+"','"+producto+"','"+ciudad+"')");
        ps.executeUpdate();
        
    }
    public void cierraConexion() {
    try {
        con.close();
    } catch (SQLException sqle) {
        
        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, sqle);
    }
}
    
    public PreparedStatement actualizarCliente(int id,String nom,String produ,String ciudad){
        PreparedStatement pstm = null;
         try {
             pstm = con.prepareStatement("update clientes "
                    + "set id= "+id+" ,  "
                    + "nombre= '"+nom+"' , "
                    + "producto= '"+produ+"' , "
                    + "ciudad= '"+ciudad+"' "
                    + "where id= " + id );
            
           
          pstm.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println(e);
        }
       return pstm;
    }
    
    public PreparedStatement eliminarCliente(int id){
        PreparedStatement pstm = null;
         try {
             pstm = con.prepareStatement("delete from clientes where"
                    + " id= "+id);
            
           
          pstm.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println(e);
        }
       return pstm;
    }
}
