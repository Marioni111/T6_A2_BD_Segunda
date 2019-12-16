/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erik
 */
public class ConexionJDBC {
    Connection conexion;
    Statement stm;
    ResultSet rs;

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
    
    
    public ConexionJDBC(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Escuela";
            String user = "root";
            String password = "root1";
            conexion = DriverManager.getConnection(url,user,password);
            
            System.out.println("conexion establecida");
            
        } catch(ClassNotFoundException ex) {
         Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);   
        }catch (SQLException ex){
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//constructor
    
    public boolean ejecutarInstruccionSQL(String sql){
        boolean res = true;
        
        
        try {
            System.out.println(conexion);
            stm = conexion.createStatement();
            System.out.println(conexion.createStatement());
            stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
    
    public ResultSet ejecutarConsulta(String sql){
        try {
            
            stm = conexion.createStatement();
            rs = stm.executeQuery(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) { /* ignored */}
            }
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) { /* ignored */}
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
        
        return rs;
    }
    
    
    
    public static void main(String[] args){
        new ConexionJDBC();
    }
    
}
