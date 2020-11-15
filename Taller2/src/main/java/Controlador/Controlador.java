/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Login.Insert;
import Login.Login;
import Modelo.Administrador;
import Modelo.Alumno;
import Modelo.Profesor;
import Modelo.Usuario;
import Vistas.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author Fabián
 */
public class Controlador implements ActionListener, ChangeListener {
    Login login;
    Insert insert;
    frmLogin win_login;
    frmPrincipalAdmin win_principal_admin;
    frmAltaUsuario win_alta_usuario;
    frmPrincipalAlumno win_principal_alumno;
    frmPrincipalProfesor win_principal_profesor;
    String user_type;
    
    public Controlador(Login login,Insert insert, frmLogin win_login,frmAltaUsuario win_alta_usuario,frmPrincipalAdmin win_principal_admin,frmPrincipalAlumno win_principal_alumno,frmPrincipalProfesor win_principal_profesor) {
        this.login = login;
        this.insert = insert;
        this.win_login = win_login;
        this.win_alta_usuario=win_alta_usuario;
        this.win_principal_admin = win_principal_admin;
        this.win_principal_alumno = win_principal_alumno;
        this.win_principal_profesor = win_principal_profesor;
        user_type="";
        this.win_alta_usuario.alumno_rButt.addActionListener(this);
        this.win_alta_usuario.profesor_rButt.addActionListener(this);
        this.win_principal_admin.alta_usuario_menu.addActionListener(this);
        this.win_alta_usuario.crear_butt.addActionListener(this);
        this.win_alta_usuario.cancelar_butt.addActionListener(this);
        this.win_login.ingButton.addActionListener(this);
        this.win_login.salir_butt.addActionListener(this);
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
            if(win_login.admin_rButt.isSelected()){
                try {
                    logueo = login.loginAdmin(usuario, password);
                    if (logueo == false)
                        JOptionPane.showMessageDialog(null,"Error en los datos de login","Login Error",JOptionPane.QUESTION_MESSAGE);
                    else{
                        win_principal_admin.setLocationRelativeTo(null);
                        win_principal_admin.setVisible(true);
                        win_login.setVisible(false);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
            if(win_login.alumno_rButt.isSelected()){
                try {
                    logueo = login.loginAlumno(usuario, password);
                    if (logueo == false)
                        JOptionPane.showMessageDialog(null,"Error en los datos de login","Login Error",JOptionPane.QUESTION_MESSAGE);
                    else{
                        win_principal_alumno.setLocationRelativeTo(null);
                        win_principal_alumno.setVisible(true);
                        win_login.setVisible(false);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
            if(win_login.profesor_rButt.isSelected()){
                try {
                    logueo = login.loginProfesor(usuario, password);
                    if (logueo == false)
                        JOptionPane.showMessageDialog(null,"Error en los datos de login","Login Error",JOptionPane.QUESTION_MESSAGE);
                    else{
                        win_principal_profesor.setLocationRelativeTo(null);
                        win_principal_profesor.setVisible(true);
                        win_login.setVisible(false);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        
        if(e.getSource()==win_login.salir_butt){
            System.exit(0);
        }
        if(e.getSource()==win_principal_admin.alta_usuario_menu){
            win_alta_usuario.setLocationRelativeTo(null);
            win_alta_usuario.setVisible(true);  
        }
        if(e.getSource()==win_alta_usuario.crear_butt){
            if(win_alta_usuario.admin_rButt.isSelected()){
                Administrador usuario = Administrador.getInstance();
                usuario.setLogin(win_alta_usuario.login_text.getText());
                usuario.setClave(win_alta_usuario.clave_text.getText());
                usuario.setEmail(win_alta_usuario.email_text.getText());
                boolean insertar = false;
                try {
                    insertar = insert.insertarAdmin(usuario.getLogin(), usuario.getClave(), usuario.getEmail());
                    if(insertar==true){
                        JOptionPane.showMessageDialog(null,"Administrador Creado con éxito","Insert exitoso",JOptionPane.QUESTION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"No se pudo crear el administrador","Insert fallido",JOptionPane.QUESTION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                 
            }
            if(win_alta_usuario.alumno_rButt.isSelected()){
                Alumno usuario = Alumno.getInstance();
                usuario.setNivel_id(win_alta_usuario.nivel_id_text.getText());
                usuario.setLogin(win_alta_usuario.login_text.getText());
                usuario.setContraseña(win_alta_usuario.clave_text.getText());
                usuario.setNombre(win_alta_usuario.nombre_text.getText());
                usuario.setApellidos(win_alta_usuario.apellidos_text.getText());
                boolean insertar = false;
                try {
                    insertar = insert.insertarAlumno(usuario.getNivel_id(), usuario.getLogin(), usuario.getContraseña(), usuario.getNombre(), usuario.getApellidos());
                    if(insertar==true){
                        JOptionPane.showMessageDialog(null,"Alumno Creado con éxito","Insert exitoso",JOptionPane.QUESTION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"No se pudo crear el Alumno","Insert fallido",JOptionPane.QUESTION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            if(win_alta_usuario.profesor_rButt.isSelected()){
                Profesor usuario = Profesor.getInstance();
                usuario.setLogin(win_alta_usuario.login_text.getText());
                usuario.setContraseña(win_alta_usuario.clave_text.getText());
                usuario.setNombre(win_alta_usuario.nombre_text.getText());
                usuario.setApellidos(win_alta_usuario.apellidos_text.getText());
                usuario.setEmail(win_alta_usuario.email_text.getText());
                usuario.setEspecialista(win_alta_usuario.especialista_text.getText());
                boolean insertar = false;
                try {
                    insertar = insert.insertarProfesor(usuario.getLogin(), usuario.getContraseña(), usuario.getNombre(), usuario.getApellidos(), usuario.getEmail(), usuario.getEspecialista());
                    if(insertar==true){
                        JOptionPane.showMessageDialog(null,"Profesor Creado con éxito","Insert exitoso",JOptionPane.QUESTION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"No se pudo crear el profesor","Insert fallido",JOptionPane.QUESTION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
        
        if(e.getSource()==win_alta_usuario.cancelar_butt){
            win_alta_usuario.nivel_id_text.setText("");
            win_alta_usuario.login_text.setText("");
            win_alta_usuario.clave_text.setText("");
            win_alta_usuario.nombre_text.setText("");
            win_alta_usuario.apellidos_text.setText("");
            win_alta_usuario.email_text.setText("");
            win_alta_usuario.especialista_text.setText("");
            win_alta_usuario.setVisible(false);
        }
    }
    
    public void stateChanged(ChangeEvent ce){
        
    }

    @Override
    public void changed(ObservableValue ov, Object t, Object t1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
