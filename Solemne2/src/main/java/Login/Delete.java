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
public class Delete {
    public boolean deleteAdmin(String ID)throws SQLException{
        Conexion conexion = new Conexion().obtener();
        conexion.eliminar("DELETE FROM db.administrador WHERE (id = '"+ID+"')");
        conexion.closeConexion();
        return true;
    }
    
    public boolean deleteAlumno(String ID)throws SQLException{
        Conexion conexion = new Conexion().obtener();
        conexion.eliminar("DELETE FROM db.alumno WHERE (id = '"+ID+"')");
        conexion.closeConexion();
        return true;
    }
    
    public boolean deleteProfesor(String ID)throws SQLException{
        Conexion conexion = new Conexion().obtener();
        conexion.eliminar("DELETE FROM db.profesor WHERE (id = '"+ID+"')");
        conexion.closeConexion();
        return true;
    }
    
    public boolean deleteAsignatura(String ID)throws SQLException{
        Conexion conexion = new Conexion().obtener();
        conexion.eliminar("DELETE FROM db.asignatura WHERE (id = '"+ID+"')");
        conexion.closeConexion();
        return true;
    }
    
}
  
