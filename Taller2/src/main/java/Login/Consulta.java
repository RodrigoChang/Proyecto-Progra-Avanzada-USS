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
    public boolean consultaAsignatura(String ID)throws SQLException{
        try{
            Conexion conexion = new Conexion().obtener();
            ResultSet resultado = conexion.consultar("SELECT id, nivel_id, profesor_id, nombre FROM asignatura WHERE id = '" +ID+ "'" );
            resultado.next();
            if (resultado.getRow() >0){
                Asignatura asignatura = Asignatura.getInstance();
              asignatura.setNivel_id(resultado.getString("nivel_id"));
              asignatura.setProfesor_id(resultado.getString("profesor_id"));
              asignatura.setNombre(resultado.getString("nombre"));
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
