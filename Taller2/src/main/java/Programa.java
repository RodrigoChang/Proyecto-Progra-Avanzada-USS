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
        Insert insert = new Insert();
        frmLogin ventana_login = new frmLogin();
        frmAltaUsuario ventana_alta_usuario = new frmAltaUsuario();
        frmPrincipalAdmin ventana_principal_admin = new frmPrincipalAdmin();
        frmPrincipalAlumno ventana_principal_alumno = new frmPrincipalAlumno();
        frmPrincipalProfesor ventana_principal_profesor = new frmPrincipalProfesor();
        
        Controlador controlador = new Controlador(login,insert,ventana_login,ventana_alta_usuario,ventana_principal_admin, ventana_principal_alumno,ventana_principal_profesor);
        
        controlador.Iniciar();
    }
}
