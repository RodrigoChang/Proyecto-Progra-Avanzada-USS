/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.sql.SQLException;


/**
 *
 * @author Fabián
 */
public class Insert {
    public boolean insertarAdmin(String login, String clave, String email)throws SQLException{
        Conexion conexion = new Conexion().obtener();
        conexion.insertar("INSERT INTO db.administrador (login, clave, email, user_type) "
                        + "VALUES ('"+login+"','"+clave+"','"+email+"','admin')");
        conexion.closeConexion();
        return true;
    }
    
    public boolean insertarAlumno(String nivel_id, String login, String clave, String nombre, String apellidos)throws SQLException{
        Conexion conexion = new Conexion().obtener();
        conexion.insertar("INSERT INTO db.alumno (nivel_id, login, clave, nombre, apellidos, user_type) "
                        + "VALUES ('"+nivel_id+"','"+login+"','"+clave+"','"+nombre+"','"+apellidos+"','alumno')");
        conexion.closeConexion();
        return true;
    }
    
    public boolean insertarProfesor(String login, String clave, String nombre, String apellidos, String email, String especialista)throws SQLException{
        Conexion conexion = new Conexion().obtener();
        conexion.insertar("INSERT INTO db.profesor (login, clave, nombre, apellidos, email, especialista, user_type) "
                        + "VALUES ('"+login+"','"+clave+"','"+nombre+"','"+apellidos+"','"+email+"','"+especialista+"','profesor')");
        conexion.closeConexion();
        return true;
    }
    
    public boolean insertarAsignatura(String nivel_id, String profesor_id , String nombre) throws SQLException{
        Conexion conexion = new Conexion().obtener();
        conexion.insertar("INSERT INTO db.asignatura (nivel_id,profesor_id,nombre) "
                        + "VALUES ('"+nivel_id+"','"+profesor_id+"','"+nombre+"')");
        conexion.closeConexion();
        return true;
    }
    
    public boolean insertarMatricula(String alumno_id, String asignatura_id) throws SQLException{
        Conexion conexion = new Conexion().obtener();
        conexion.insertar("INSERT INTO db.asignatura_has_alumno (asignatura_id,alumno_id) "
                        + "VALUES ('"+asignatura_id+"','"+alumno_id+"')");
        conexion.closeConexion();
        return true;
    }
    
}
  
