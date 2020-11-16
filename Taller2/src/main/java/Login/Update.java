/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Modelo.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Fabián
 */
public class Update {
        public boolean updateAsignatura(String ID)throws SQLException{
            Conexion conexion = new Conexion().obtener();
            Asignatura asignatura = Asignatura.getInstance();
            conexion.insertar("UPDATE db.asignatura SET nivel_id = '"+asignatura.getNivel_id()+"', profesor_id = '"+ asignatura.getProfesor_id() +"', nombre = '"+ asignatura.getNombre() +"' WHERE (id = '"+ ID +"')");
            return true;
        }
}
