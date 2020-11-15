/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Modelo.Profesor;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Fabián
 */
public class Insert {
    public boolean insertarAdmin(String login, String clave, String email)throws SQLException{
        Conexion conexion = new Conexion().obtener();
        conexion.insertar("INSERT INTO db.administrador (login, clave, email, user_type) VALUES ('"+login+"','"+clave+"','"+email+"','admin')");
        return true;
    }
    
    public boolean insertarAlumno(String nivel_id, String login, String clave, String nombre, String apellidos)throws SQLException{
        Conexion conexion = new Conexion().obtener();
        conexion.insertar("INSERT INTO db.alumno (nivel_id, login, clave, nombre, apellidos, user_type) VALUES ('"+nivel_id+"','"+login+"','"+clave+"','"+nombre+"','"+apellidos+"','alumno')");
        return true;
    }
    
    public boolean insertarProfesor(String login, String clave, String nombre, String apellidos, String email, String especialista)throws SQLException{
        Conexion conexion = new Conexion().obtener();
        conexion.insertar("INSERT INTO db.profesor (login, clave, nombre, apellidos, email, especialista, user_type) VALUES ('"+login+"','"+clave+"','"+nombre+"','"+apellidos+"','"+email+"','"+especialista+"','profesor')");
        return true;
    }
    
}
  
