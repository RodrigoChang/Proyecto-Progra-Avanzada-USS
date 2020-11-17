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
public class Consulta {

    public boolean consultaAsignatura(String ID) throws SQLException {
        try {
            Conexion conexion = new Conexion().obtener();
            ResultSet resultado = conexion.consultar("SELECT id, nivel_id, profesor_id, nombre "
                                                   + "FROM asignatura "
                                                   + "WHERE id = '" + ID + "'");
            resultado.next();
            if (resultado.getRow() > 0) {
                Asignatura asignatura = Asignatura.getInstance();
                asignatura.setNivel_id(resultado.getString("nivel_id"));
                asignatura.setProfesor_id(resultado.getString("profesor_id"));
                asignatura.setNombre(resultado.getString("nombre"));
                conexion.closeConexion();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public String consultaNota(String id_alumno, String id_asignatura) throws SQLException {
        try {
            Conexion conexion = new Conexion().obtener();
            ResultSet resultado = conexion.consultar("SELECT nota "
                                                   + "FROM asignatura_has_alumno "
                                                   + "WHERE alumno_id = '" + id_alumno + "' and asignatura_id = '" + id_asignatura + "'");
            resultado.next();
            if (resultado.getRow() > 0) {
                String nota = resultado.getString("nota");
                conexion.closeConexion();
                return nota;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public ResultSet consultaMisAsignaturas(String ID) throws SQLException {
        try {
            Conexion conexion = new Conexion().obtener();
            ResultSet resultado = conexion.consultar("SELECT asignatura.id, asignatura.nombre "
                                                   + "FROM asignatura_has_alumno "
                                                   + "JOIN asignatura ON asignatura_has_alumno.asignatura_id=asignatura.id "
                                                   + "WHERE asignatura_has_alumno.alumno_id = '" + ID + "'");
            resultado.next();
            if (resultado.getRow() > 0) {
                return resultado;
            }
            conexion.closeConexion();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public ResultSet consultaMisAsignaturasProfe(String ID) throws SQLException {
        try {
            Conexion conexion = new Conexion().obtener();
            ResultSet resultado = conexion.consultar("SELECT asignatura.nombre, asignatura.id "
                                                   + "FROM asignatura "
                                                   + "JOIN profesor ON asignatura.profesor_id=profesor.id "
                                                   + "WHERE asignatura.profesor_id = '" + ID + "'");
            resultado.next();
            if (resultado.getRow() > 0) {
                return resultado;
            }
            conexion.closeConexion();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public ResultSet consultaMisCompañeros(String ID) throws SQLException {
        try {
            Conexion conexion = new Conexion().obtener();
            ResultSet resultado = conexion.consultar("SELECT alumno.nombre, alumno.apellidos, alumno.id "
                                                   + "FROM asignatura_has_alumno "
                                                   + "JOIN alumno ON asignatura_has_alumno.alumno_id = alumno.id "
                                                   + "WHERE asignatura_has_alumno.asignatura_id = '" + ID + "'");
            resultado.next();
            if (resultado.getRow() > 0) {
                return resultado;
            }
            conexion.closeConexion();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public ResultSet consultaMisProfesores(String ID) throws SQLException {
        try {
            Conexion conexion = new Conexion().obtener();
            ResultSet resultado = conexion.consultar("SELECT profesor.nombre, profesor.apellidos, asig1.nombre "
                                                   + "FROM asignatura_has_alumno "
                                                   + "JOIN asignatura AS asig1 ON asignatura_has_alumno.asignatura_id=asig1.id "
                                                   + "JOIN profesor ON profesor.id = asig1.profesor_id "
                                                   + "WHERE asignatura_has_alumno.alumno_id = '" + ID + "'");
            resultado.next();
            if (resultado.getRow() > 0) {
                return resultado;
            }
            conexion.closeConexion();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public ResultSet consultaProfesores() throws SQLException {
        try {
            Conexion conexion = new Conexion().obtener();
            ResultSet resultado = conexion.consultar("SELECT profesor.nombre, profesor.apellidos "
                                                   + "FROM profesor ");
            resultado.next();
            if (resultado.getRow() > 0) {
                return resultado;
            }
            conexion.closeConexion();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public boolean consultaAdministrador(String ID) throws SQLException {
        try {
            Conexion conexion = new Conexion().obtener();
            ResultSet resultado = conexion.consultar("SELECT id, login, clave, email "
                                                   + "FROM administrador WHERE id = '" + ID + "'");
            resultado.next();
            if (resultado.getRow() > 0) {
                Administrador admin = Administrador.getInstance();
                admin.setLogin(resultado.getString("login"));
                admin.setClave(resultado.getString("clave"));
                admin.setEmail(resultado.getString("email"));
                conexion.closeConexion();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
    
    public String consultaIdAdministrador(String login, String clave, String email) throws SQLException {
        try {
            String id="";
            Conexion conexion = new Conexion().obtener();
            ResultSet resultado = conexion.consultar("SELECT id "
                                                   + "FROM administrador WHERE login = '" + login + "' and clave = '"+clave+"' and email = '"+email+"' ");
            resultado.next();
            if (resultado.getRow() > 0) {
                id =resultado.getString("id");
                conexion.closeConexion();
                return id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
    
    public String consultaIdAlumno(String nivel, String login, String clave, String nombre, String apellidos) throws SQLException {
        try {
            String id="";
            Conexion conexion = new Conexion().obtener();
            ResultSet resultado = conexion.consultar("SELECT id "
                                                   + "FROM alumno WHERE nivel_id = '" + nivel + "' and login = '"+login+"' and clave = '"+clave+"' and nombre = '"+nombre+"' and apellidos = '"+apellidos+"' ");
            resultado.next();
            if (resultado.getRow() > 0) {
                id =resultado.getString("id");
                conexion.closeConexion();
                return id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
    
    public String consultaIdProfesor(String login, String clave, String nombre, String apellidos, String email, String especialista) throws SQLException {
        try {
            String id="";
            Conexion conexion = new Conexion().obtener();
            ResultSet resultado = conexion.consultar("SELECT id "
                                                   + "FROM profesor WHERE login = '" + login + "' and clave = '"+clave+"' and nombre = '"+nombre+"' and apellidos = '"+apellidos+"' and email = '"+email+"' and especialista = '"+especialista+"'");
            resultado.next();
            if (resultado.getRow() > 0) {
                id =resultado.getString("id");
                conexion.closeConexion();
                return id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public boolean consultaAlumno(String ID) throws SQLException {
        try {
            Conexion conexion = new Conexion().obtener();
            ResultSet resultado = conexion.consultar("SELECT id, nivel_id, login, clave, nombre, apellidos "
                                                   + "FROM alumno WHERE id = '" + ID + "'");
            resultado.next();
            if (resultado.getRow() > 0) {
                Alumno alumno = Alumno.getInstance();
                alumno.setNivel_id(resultado.getString("nivel_id"));
                alumno.setLogin(resultado.getString("login"));
                alumno.setContraseña(resultado.getString("clave"));
                alumno.setNombre(resultado.getString("nombre"));
                alumno.setApellidos(resultado.getString("apellidos"));
                conexion.closeConexion();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean consultaProfesor(String ID) throws SQLException {
        try {
            Conexion conexion = new Conexion().obtener();
            ResultSet resultado = conexion.consultar("SELECT id, login, clave, nombre, apellidos, email, especialista "
                                                   + "FROM profesor WHERE id = '" + ID + "'");
            resultado.next();
            if (resultado.getRow() > 0) {
                Profesor profe = Profesor.getInstance();
                profe.setLogin(resultado.getString("login"));
                profe.setContraseña(resultado.getString("clave"));
                profe.setNombre(resultado.getString("nombre"));
                profe.setApellidos(resultado.getString("apellidos"));
                profe.setEmail(resultado.getString("email"));
                profe.setEspecialista(resultado.getString("especialista"));
                conexion.closeConexion();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

}
