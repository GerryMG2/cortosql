/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corto_miercoles;

/**
 *
 * @author LN710Q
 */
public class filtro {
    public int id;
    public String nombre;
    public String Director;
    public String pais;
    public String clasificacion;
    public int annio;
    public boolean inproyec;
    public filtro(){
        
    }

    public filtro(int id, String nombre, String Director, String pais, String clasificacion, int annio, boolean inproyec) {
        this.id = id;
        this.nombre = nombre;
        this.Director = Director;
        this.pais = pais;
        this.clasificacion = clasificacion;
        this.annio = annio;
        this.inproyec = inproyec;
    }
    
}
