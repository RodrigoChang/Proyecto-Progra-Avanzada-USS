/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;
import java.sql.*;
import Modelo.Usuario;
/**
 *
 * @author rodrigo
 */
public class Login {
    public boolean login(String usuario, String password)throws SQLException{
        try{
            Conexion conexion = new Conexion().obtener();
            
            ResultSet resultado = conexion.consultar("SELECT idusuario, titular, identificacion, tipo_usuario FROM usuarios WHERE usuario = '" + usuario + "' and password = '" + password + "'" );
            resultado.next();
            if (resultado.getRow() >0){
                Usuario usuarioactual = Usuario.getInstance();
              usuarioactual.setIDUsuario(resultado.getInt("idusuario"));
              usuarioactual.setIdTipoUsuario(resultado.getString("tipo_usuario"));
              usuarioactual.setIdentificacion(resultado.getString("identificacion"));
              usuarioactual.setNombreApellidos(resultado.getString("titular"));
              return true;
            }
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
