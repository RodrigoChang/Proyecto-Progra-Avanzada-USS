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
        
        public boolean updateAdministrador(String ID)throws SQLException{
            Conexion conexion = new Conexion().obtener();
            Administrador admin = Administrador.getInstance();
            conexion.insertar("UPDATE db.administrador SET login = '"+admin.getLogin()+"', clave = '"+ admin.getClave() +"', email = '"+ admin.getEmail() +"' WHERE (id = '"+ ID +"')");
            return true;
        }
        
        public boolean updateAlumno(String ID)throws SQLException{
            Conexion conexion = new Conexion().obtener();
            Alumno alumno = Alumno.getInstance();
            conexion.insertar("UPDATE db.alumno SET nivel_id = '"+alumno.getNivel_id()+"', login = '"+ alumno.getLogin() +"', clave = '"+ alumno.getContraseña() +"',nombre = '"+alumno.getNombre()+"',apellidos='"+alumno.getApellidos()+"' WHERE (id = '"+ ID +"')");
            return true;
        }
        public boolean updateProfesor(String ID)throws SQLException{
            Conexion conexion = new Conexion().obtener();
            Profesor profe = Profesor.getInstance();
            conexion.insertar("UPDATE db.profesor SET login = '"+profe.getLogin()+"', clave = '"+ profe.getContraseña() +"', nombre = '"+ profe.getNombre()+"',apellidos='"+profe.getApellidos()+"',email='"+profe.getEmail()+"',especialista='"+profe.getEspecialista() +"' WHERE (id = '"+ ID +"')");
            return true;
        }
}
