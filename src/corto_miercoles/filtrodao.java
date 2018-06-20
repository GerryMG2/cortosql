/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corto_miercoles;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author LN710Q
 */
public class filtrodao implements metodos<filtro>{
    private static final String SQL_INSERT = "INSERT INTO `movie` (`nombre`, `director`, `pais`, `clasificacion`, `anio`, `en_proyeccion`) VALUES (?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE movie set director = ?, pais = ?,clasificacion = ?,anio = ?,en_proyeccion = ? where nombre = ?";
    private static final String SQL_DELETE = "DELETE FROM MOVIE WHERE NOMBRE = ?";
    private static final String SQL_READALL = "SELECT * FROM MOVIE";
    private static final conexion con = conexion.conectar();
    @Override
    public boolean create(filtro g) {
        PreparedStatement ps;
        try {
            ps = con.getCnx().prepareStatement(SQL_INSERT);
            ps.setString(1, g.nombre);
            ps.setString(2, g.Director);
            ps.setString(3, g.pais);
            ps.setString(4, g.clasificacion);
            ps.setInt(5, g.annio);
            if(g.inproyec){
                ps.setInt(6,1);
            }
            else
            {
                ps.setInt(6,0);
            }
            if(ps.executeUpdate() > 0)
            {
                return true;
            }
            
            
        }
        catch(SQLException exx){
            
        }
        finally{
            con.cerrarconexion();
        }
        return false;
    }

    @Override
    public boolean delete(filtro g) {
        PreparedStatement ps;
        try{
            ps = con.getCnx().prepareStatement(SQL_DELETE);
            ps.setString(1, g.nombre);
        }
        catch(SQLException err){
            
        }
        finally{
            con.cerrarconexion();
        }
    }

    @Override
    public boolean update(filtro c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public filtro read(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<filtro> readall() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
        
          
}
