/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corto_miercoles;

import java.util.ArrayList;

/**
 *
 * @author LN710Q
 * @param <Generic>
 */
public interface metodos <Generic>{
    public boolean create(Generic g);
    public boolean delete(Generic g);
    public boolean update(Generic c);
    public Generic read(Generic g);
    public ArrayList<Generic> readall();
}
