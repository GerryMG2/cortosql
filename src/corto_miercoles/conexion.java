/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corto_miercoles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LN710Q
 */
public class conexion {
    private String user;
    private String pass;
    private String driver;
    private String url;
    private Connection cnx;
    public static conexion instance;
    public synchronized static conexion conectar(){
        if(instance == null){
            return new conexion();
            
        }
        return instance;
    }
    private conexion() 
    {
        cargarCredenciales();
        try{
            Class.forName(this.driver);
            cnx = (Connection) DriverManager.getConnection(url, user, pass);
            
        }
        catch(ClassNotFoundException | SQLException ex){
            
        }
    }
    
    private void cargarCredenciales(){
        user = "root";
        pass="";
        driver = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql:localhost/movies";
        
    }
    
    public Connection getCnx(){
        return cnx;
    }
    public void cerrarconexion(){
        instance = null;
    }
   
}
