import Vistas.*;
import Modelo.*;
import Controlador.*;
import Login.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fabián
 */
public class Programa {
    public static void main(String[] args){
        Login login = new Login();
        frmLogin ventana_login = new frmLogin();
        frmPrincipal ventana_principal = new frmPrincipal();
        frmAltaUsuario ventana_alta_usuario = new frmAltaUsuario();
        Controlador controlador = new Controlador(login,ventana_login,ventana_principal,ventana_alta_usuario);
        
        controlador.Iniciar();
    }
}
