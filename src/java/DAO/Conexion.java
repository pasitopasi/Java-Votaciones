/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*; 
public class Conexion {
    
    private static Conexion UnicaConexion = null;
    private Connection Conex;
    
    private Conexion() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        String URL =  "jdbc:mysql://localhost/bd_votaciones_amr";
        Conex = DriverManager.getConnection(URL,"root","root");
    } 
    
    public synchronized static Conexion getConexion()  throws ClassNotFoundException, SQLException{
        if(UnicaConexion == null){
            UnicaConexion = new Conexion();
        }        
        return UnicaConexion;
    }
    
    public Connection getConex(){
        return Conex;
    }    
    
    public void Destroy() throws SQLException{
        Conex.close();
    }
} 

