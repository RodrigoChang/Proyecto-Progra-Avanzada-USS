/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Login.Login;
import Modelo.Usuario;
import Vistas.frmAltaUsuario;
import Vistas.frmLogin;
import Vistas.frmPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Fabián
 */
public class Controlador implements ActionListener {
    Login login;
    frmLogin win_login;
    frmPrincipal win_principal;
    frmAltaUsuario win_alta_usuario;
    
    public Controlador(Login login, frmLogin win_login, frmPrincipal win_principal,frmAltaUsuario win_alta_usuario) {
        this.login = login;
        this.win_login = win_login;
        this.win_principal = win_principal;
        this.win_alta_usuario=win_alta_usuario;
        this.win_login.ingButton.addActionListener(this);
        this.win_login.salir_butt.addActionListener(this);
        this.win_principal.alta_alumno_menu.addActionListener(this);
    }
    
    public void Iniciar(){
        win_login.setVisible(true);
        win_login.setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== win_login.ingButton){
            String usuario = win_login.txtUsuario.getText();
            String password = win_login.txtPassword.getText();
            boolean logueo = false;
            try {
                logueo = login.login(usuario, password);
                if (logueo == false)
                    JOptionPane.showMessageDialog(null,"Error en los datos de login","Login Error",JOptionPane.QUESTION_MESSAGE);
                else{                
                    win_principal.setVisible(true);
                    win_login.setVisible(false);
                }
            } catch (SQLException ex) {
                Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource()==win_login.salir_butt){
            System.exit(0);
        }
        if(e.getSource()==win_principal.alta_alumno_menu){
            win_alta_usuario.setVisible(true);
        }
    }
}
