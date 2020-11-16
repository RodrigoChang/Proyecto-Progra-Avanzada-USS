/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;
import java.sql.*;
import Modelo.*;
/**
 *
 * @author rodrigo
 */
public class Login {
    public boolean loginAdmin(String usuario, String password)throws SQLException{
        try{
            Conexion conexion = new Conexion().obtener();
            
            ResultSet resultado = conexion.consultar("SELECT id, login, clave, email FROM administrador WHERE login = '" + usuario + "' and clave = '" + password + "'" );
            resultado.next();
            if (resultado.getRow() >0){
                Administrador usuarioactual = Administrador.getInstance();
              usuarioactual.setId(resultado.getInt("id"));
              usuarioactual.setLogin(resultado.getString("login"));
              usuarioactual.setClave(resultado.getString("clave"));
              usuarioactual.setEmail(resultado.getString("email"));
              conexion.closeConexion();
              return true;
            }
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return false;
    }
    public boolean loginAlumno(String usuario, String password)throws SQLException{
        try{
            Conexion conexion = new Conexion().obtener();
            ResultSet resultado = conexion.consultar("SELECT id, nivel_id, login, clave, nombre, apellidos FROM alumno WHERE login = '" + usuario + "' and clave = '" + password + "'" );
            resultado.next();
            if (resultado.getRow() >0){
                Alumno usuarioactual = Alumno.getInstance();
              usuarioactual.setId(resultado.getInt("id"));
              usuarioactual.setNivel_id(resultado.getString("nivel_id"));
              usuarioactual.setLogin(resultado.getString("login"));
              usuarioactual.setContraseña(resultado.getString("clave"));
              usuarioactual.setNombre(resultado.getString("nombre"));
              usuarioactual.setApellidos(resultado.getString("apellidos"));
              conexion.closeConexion();
              return true;
            }
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return false;
    }
    public boolean loginProfesor(String usuario, String password)throws SQLException{
        try{
            Conexion conexion = new Conexion().obtener();
            
            ResultSet resultado = conexion.consultar("SELECT id, login, clave, nombre, apellidos, email, especialista FROM profesor WHERE login = '" + usuario + "' and clave = '" + password + "'" );
            resultado.next();
            if (resultado.getRow() >0){
                Profesor usuarioactual = Profesor.getInstance();
              usuarioactual.setId(resultado.getInt("id"));
              usuarioactual.setLogin(resultado.getString("login"));
              usuarioactual.setContraseña(resultado.getString("clave"));
              usuarioactual.setNombre(resultado.getString("nombre"));
              usuarioactual.setApellidos(resultado.getString("apellidos"));
              usuarioactual.setEmail(resultado.getString("email"));
              usuarioactual.setEspecialista(resultado.getString("especialista"));
              conexion.closeConexion();
              return true;
            }
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
