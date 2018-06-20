/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corto_miercoles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author LN710Q
 */
public class filtrodao implements metodos<filtro> {

    private static final String SQL_INSERT = "INSERT INTO `movie` (`nombre`, `director`, `pais`, `clasificacion`, `anio`, `en_proyeccion`) VALUES (?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE movie set director = ?, pais = ?,clasificacion = ?,anio = ?,en_proyeccion = ? where nombre = ?";
    private static final String SQL_DELETE = "DELETE FROM MOVIE WHERE NOMBRE = ?";
    private static final String SQL_READALL = "SELECT * FROM MOVIE";
    private static final String SQL_READ = "SELECT * FROM MOVIE WHERE NOMBRE = ?";
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
            if (g.inproyec) {
                ps.setInt(6, 1);
            } else {
                ps.setInt(6, 0);
            }
            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException exx) {

        } finally {
            con.cerrarconexion();
        }
        return false;
    }

    @Override
    public boolean delete(filtro g) {
        PreparedStatement ps;
        try {
            ps = con.getCnx().prepareStatement(SQL_DELETE);
            ps.setString(1, g.nombre);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException err) {

        } finally {
            con.cerrarconexion();
        }
        return false;
    }

    @Override
    public boolean update(filtro c) {
        PreparedStatement ps;
        try {
            ps = con.getCnx().prepareStatement(SQL_UPDATE);
            ps.setString(1, c.Director);
            ps.setString(2, c.pais);
            ps.setString(3, c.clasificacion);
            ps.setInt(4, c.annio);
            if (c.inproyec) {
                ps.setInt(5, 1);
            } else {
                ps.setInt(5, 0);
            }

            ps.setString(6, c.nombre);

            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException exx) {

        } finally {
            con.cerrarconexion();
        }
        return false;
    }

    @Override
    public filtro read(filtro g) {
        filtro f = null;
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = con.getCnx().prepareStatement(SQL_READ);
            ps.setString(1, g.nombre);
            rs = ps.executeQuery();
            while (rs.next()) {
                boolean inpr = true;
                if (rs.getInt(7) == 1) {
                    
                } else {
                    inpr = false;
                }

                f = new filtro(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6),inpr);
            }
            rs.close();
        } catch (SQLException error) {

        }
        return f;
    }

    @Override
    public ArrayList<filtro> readall() {
        ArrayList<filtro> all = new ArrayList();
        Statement s;
        ResultSet rs;
        try{
            s = con.getCnx().prepareStatement(SQL_READALL);
            rs = s.executeQuery(SQL_READ);
            while (rs.next()) {
                boolean inpr = true;
                if (rs.getInt(7) == 1) {
                    
                } else {
                    inpr = false;
                }

                all.add(new filtro(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6),inpr));
                
            }
            rs.close();
        }   
        catch(SQLException sql){
            
        }
        
        
        
        
        return all;
    }

}
