/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Login.*;
import Modelo.*;
import Vistas.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
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
    Insert insert;
    Delete delete;
    Consulta consulta;
    Update update;
    frmLogin win_login;
    frmPrincipalAdmin win_principal_admin;
    frmAltaUsuario win_alta_usuario;
    frmPrincipalAlumno win_principal_alumno;
    frmPrincipalProfesor win_principal_profesor;
    frmBajaUsuario win_baja_usuario;
    frmModUsuario win_mod_usuario;
    frmBajaAsignatura win_baja_asignatura;
    frmAltaAsignatura win_alta_asignatura;
    frmModAsignatura win_mod_asignatura;
    frmMatricularAlumno win_mat_alumno;
    frmConsultarNota win_consultar_nota;
    frmListarAlumnos win_listar_alumnos;
    frmListarProfesores win_listar_profesores;
    frmListarAlumnos2 win_listar_alumnos2;
    frmListarProfesores2 win_listar_profesores2;
    frmPonerNotas win_poner_notas;
    String user_type;

    @SuppressWarnings("LeakingThisInConstructor")
    public Controlador(Login login, Insert insert, Delete delete, Consulta consulta, Update update,
            frmLogin win_login, frmAltaUsuario win_alta_usuario, frmPrincipalAdmin win_principal_admin,
            frmPrincipalAlumno win_principal_alumno, frmPrincipalProfesor win_principal_profesor, frmBajaUsuario win_baja_usuario,
            frmBajaAsignatura win_baja_asignatura, frmAltaAsignatura win_alta_asignatura, frmModAsignatura win_mod_asignatura,
            frmModUsuario win_mod_usuario,frmMatricularAlumno win_mat_alumno, frmConsultarNota win_consultar_nota,
            frmListarAlumnos win_listar_alumnos,frmListarProfesores win_listar_profesores, frmListarAlumnos2 win_listar_alumnos2,
            frmListarProfesores2 win_listar_profesores2,frmPonerNotas win_poner_notas) {
        
        this.login                  = login;
        this.insert                 = insert;
        this.delete                 = delete;
        this.consulta               = consulta;
        this.update                 = update;
        this.win_login              = win_login;
        this.win_alta_usuario       = win_alta_usuario;
        this.win_principal_admin    = win_principal_admin;
        this.win_principal_alumno   = win_principal_alumno;
        this.win_principal_profesor = win_principal_profesor;
        this.win_baja_usuario       = win_baja_usuario;
        this.win_baja_asignatura    = win_baja_asignatura;
        this.win_alta_asignatura    = win_alta_asignatura;
        this.win_mod_asignatura     = win_mod_asignatura;
        this.win_mod_usuario        = win_mod_usuario;
        this.win_mat_alumno         = win_mat_alumno;
        this.win_consultar_nota     = win_consultar_nota;
        this.win_listar_alumnos     = win_listar_alumnos;
        this.win_listar_profesores  = win_listar_profesores;
        this.win_listar_alumnos2    = win_listar_alumnos2;
        this.win_listar_profesores2 = win_listar_profesores2;
        this.win_poner_notas        = win_poner_notas;
        user_type = "";
        this.win_alta_usuario.alumno_rButt.addActionListener(this);
        this.win_alta_usuario.profesor_rButt.addActionListener(this);
        this.win_principal_admin.baja_asignatura_menu.addActionListener(this);
        this.win_principal_admin.alta_asignatura_menu.addActionListener(this);
        this.win_principal_admin.baja_usuaio_menu.addActionListener(this);
        this.win_principal_admin.alta_usuario_menu.addActionListener(this);
        this.win_principal_admin.mod_datos_usuario_menu.addActionListener(this);
        this.win_principal_admin.mod_datos_asignatura_menu.addActionListener(this);
        this.win_principal_admin.matricular_alumno_menu.addActionListener(this);
        this.win_principal_alumno.consultar_Notas.addActionListener(this);
        this.win_principal_alumno.listar_alumnos_menu.addActionListener(this);
        this.win_principal_alumno.listar_profesores_menu.addActionListener(this);
        this.win_principal_profesor.listar_alumnos_menu.addActionListener(this);
        this.win_principal_profesor.listar_profesores_menu.addActionListener(this);
        this.win_principal_profesor.poner_notas_menu.addActionListener(this);
        this.win_alta_usuario.crear_butt.addActionListener(this);
        this.win_alta_usuario.cancelar_butt.addActionListener(this);
        this.win_login.ingButton.addActionListener(this);
        this.win_login.salir_butt.addActionListener(this);
        this.win_baja_usuario.eliminar_butt.addActionListener(this);
        this.win_baja_usuario.cancelar_butt.addActionListener(this);
        this.win_mod_usuario.cargar_butt.addActionListener(this);
        this.win_mod_usuario.Mod_butt.addActionListener(this);
        this.win_mod_usuario.cancelar_butt.addActionListener(this);
        this.win_baja_asignatura.eliminar_butt.addActionListener(this);
        this.win_baja_asignatura.cancelar_butt.addActionListener(this);
        this.win_alta_asignatura.crear_butt.addActionListener(this);
        this.win_alta_asignatura.cancelar_butt.addActionListener(this);
        this.win_mod_asignatura.cargar_butt.addActionListener(this);
        this.win_mod_asignatura.modificar_butt.addActionListener(this);
        this.win_mod_asignatura.cancelar_butt.addActionListener(this);
        this.win_mat_alumno.matricular_butt.addActionListener(this);
        this.win_mat_alumno.cancelar_butt.addActionListener(this);
        this.win_consultar_nota.cancelar_butt.addActionListener(this);
        this.win_consultar_nota.consultar_butt.addActionListener(this);
        this.win_listar_alumnos.cancelar_butt.addActionListener(this);
        this.win_listar_alumnos.consultar_butt.addActionListener(this);
        this.win_listar_profesores.cancelar_butt.addActionListener(this);
        this.win_listar_alumnos2.cancelar_butt.addActionListener(this);
        this.win_listar_alumnos2.consultar_butt.addActionListener(this);
        this.win_listar_profesores2.cancelar_butt.addActionListener(this);
        this.win_poner_notas.asignar_nota_butt.addActionListener(this);
        this.win_poner_notas.cancelar_butt.addActionListener(this);
        this.win_poner_notas.consultar_butt.addActionListener(this);
        
    }

    public void Iniciar() {
        win_login.setVisible(true);
        win_login.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        /*Eventos de LOGIN
        #######################################################################################################################################################################################
         */

        if (e.getSource() == win_login.ingButton) {
            String usuario = win_login.txtUsuario.getText();
            String password = win_login.txtPassword.getText();
            boolean logueo;
            if (win_login.admin_rButt.isSelected()) {
                try {
                    logueo = login.loginAdmin(usuario, password);
                    if (logueo == false) {
                        JOptionPane.showMessageDialog(null, "Error en los datos de login", "Login Error", JOptionPane.QUESTION_MESSAGE);
                    } else {
                        win_principal_admin.setLocationRelativeTo(null);
                        win_principal_admin.setVisible(true);
                        win_login.setVisible(false);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (win_login.alumno_rButt.isSelected()) {
                try {
                    logueo = login.loginAlumno(usuario, password);
                    if (logueo == false) {
                        JOptionPane.showMessageDialog(null, "Error en los datos de login", "Login Error", JOptionPane.QUESTION_MESSAGE);
                    } else {
                        win_principal_alumno.setLocationRelativeTo(null);
                        win_principal_alumno.setVisible(true);
                        win_login.setVisible(false);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (win_login.profesor_rButt.isSelected()) {
                try {
                    logueo = login.loginProfesor(usuario, password);
                    if (logueo == false) {
                        JOptionPane.showMessageDialog(null, "Error en los datos de login", "Login Error", JOptionPane.QUESTION_MESSAGE);
                    } else {
                        win_principal_profesor.setLocationRelativeTo(null);
                        win_principal_profesor.setVisible(true);
                        win_login.setVisible(false);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        if (e.getSource() == win_login.salir_butt) {
            System.exit(0);
        }
        
        /*#######################################################################################################################################################
        #########################################################################################################################################################
        ##########################################################Inicio Controlador para administrador##########################################################
        #########################################################################################################################################################
        #########################################################################################################################################################
        */
        
        /*Eventos de Admin - Usuarios
        #######################################################################################################################################################################################
         */
        if (e.getSource() == win_principal_admin.alta_usuario_menu) {
            win_alta_usuario.setLocationRelativeTo(null);
            win_alta_usuario.setVisible(true);
        }
        if (e.getSource() == win_alta_usuario.crear_butt) {
            if (win_alta_usuario.admin_rButt.isSelected()) {
                Administrador usuario = Administrador.getInstance();
                usuario.setLogin(win_alta_usuario.login_text.getText());
                usuario.setClave(win_alta_usuario.clave_text.getText());
                usuario.setEmail(win_alta_usuario.email_text.getText());
                boolean insertar;
                try {
                    insertar = insert.insertarAdmin(usuario.getLogin(), usuario.getClave(), usuario.getEmail());
                    if (insertar == true) {
                        JOptionPane.showMessageDialog(null, "Administrador Creado con éxito", "Insert exitoso", JOptionPane.QUESTION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo crear el administrador", "Insert fallido", JOptionPane.QUESTION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (win_alta_usuario.alumno_rButt.isSelected()) {
                Alumno usuario = Alumno.getInstance();
                usuario.setNivel_id(win_alta_usuario.nivel_id_text.getText());
                usuario.setLogin(win_alta_usuario.login_text.getText());
                usuario.setContraseña(win_alta_usuario.clave_text.getText());
                usuario.setNombre(win_alta_usuario.nombre_text.getText());
                usuario.setApellidos(win_alta_usuario.apellidos_text.getText());
                boolean insertar;
                try {
                    insertar = insert.insertarAlumno(usuario.getNivel_id(), usuario.getLogin(), usuario.getContraseña(), usuario.getNombre(), usuario.getApellidos());
                    if (insertar == true) {
                        JOptionPane.showMessageDialog(null, "Alumno Creado con éxito", "Insert exitoso", JOptionPane.QUESTION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo crear el Alumno", "Insert fallido", JOptionPane.QUESTION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (win_alta_usuario.profesor_rButt.isSelected()) {
                Profesor usuario = Profesor.getInstance();
                usuario.setLogin(win_alta_usuario.login_text.getText());
                usuario.setContraseña(win_alta_usuario.clave_text.getText());
                usuario.setNombre(win_alta_usuario.nombre_text.getText());
                usuario.setApellidos(win_alta_usuario.apellidos_text.getText());
                usuario.setEmail(win_alta_usuario.email_text.getText());
                usuario.setEspecialista(win_alta_usuario.especialista_text.getText());
                boolean insertar;
                try {
                    insertar = insert.insertarProfesor(usuario.getLogin(), usuario.getContraseña(), usuario.getNombre(), usuario.getApellidos(), usuario.getEmail(), usuario.getEspecialista());
                    if (insertar == true) {
                        JOptionPane.showMessageDialog(null, "Profesor Creado con éxito", "Insert exitoso", JOptionPane.QUESTION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo crear el profesor", "Insert fallido", JOptionPane.QUESTION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

        if (e.getSource() == win_alta_usuario.cancelar_butt) {
            win_alta_usuario.nivel_id_text.setText("");
            win_alta_usuario.login_text.setText("");
            win_alta_usuario.clave_text.setText("");
            win_alta_usuario.nombre_text.setText("");
            win_alta_usuario.apellidos_text.setText("");
            win_alta_usuario.email_text.setText("");
            win_alta_usuario.especialista_text.setText("");
            win_alta_usuario.setVisible(false);
        }

        if (e.getSource() == win_principal_admin.baja_usuaio_menu) {
            win_baja_usuario.setLocationRelativeTo(null);
            win_baja_usuario.setVisible(true);
        }

        if (e.getSource() == win_baja_usuario.eliminar_butt) {
            if (win_baja_usuario.admin_rButt.isSelected()) {
                String Id = win_baja_usuario.id_usuario_text.getText();
                boolean eliminar;
                try {
                    eliminar = delete.deleteAdmin(Id);
                    if (eliminar == true) {
                        JOptionPane.showMessageDialog(null, "Administrador eliminado con éxito", "Insert exitoso", JOptionPane.QUESTION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar al administrador", "Insert fallido", JOptionPane.QUESTION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (e.getSource() == win_baja_usuario.eliminar_butt) {
            if (win_baja_usuario.alumno_rButt.isSelected()) {
                String Id = win_baja_usuario.id_usuario_text.getText();
                boolean eliminar;
                try {
                    eliminar = delete.deleteAlumno(Id);
                    if (eliminar == true) {
                        JOptionPane.showMessageDialog(null, "Alumno eliminado con éxito", "Insert exitoso", JOptionPane.QUESTION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar al Alumno", "Insert fallido", JOptionPane.QUESTION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (e.getSource() == win_baja_usuario.eliminar_butt) {
            if (win_baja_usuario.profesor_rButt.isSelected()) {
                String Id = win_baja_usuario.id_usuario_text.getText();
                boolean eliminar;
                try {
                    eliminar = delete.deleteProfesor(Id);
                    if (eliminar == true) {
                        JOptionPane.showMessageDialog(null, "Profesor eliminado con éxito", "Insert exitoso", JOptionPane.QUESTION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar al Profesor", "Insert fallido", JOptionPane.QUESTION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (e.getSource() == win_baja_usuario.cancelar_butt) {
            win_baja_usuario.id_usuario_text.setText("");
            win_baja_usuario.setVisible(false);
        }
        
        if (e.getSource() == win_principal_admin.mod_datos_usuario_menu) {
            win_mod_usuario.setLocationRelativeTo(null);
            win_mod_usuario.setVisible(true);
        }
        if (e.getSource() == win_mod_usuario.cancelar_butt) {
            win_mod_usuario.setVisible(false);
        }
        
        if (e.getSource() == win_mod_usuario.cargar_butt) {
            
            if (win_mod_usuario.admin_rButt.isSelected()) {
                Administrador admin = Administrador.getInstance();
                admin.setId(win_mod_usuario.id_text.getText());
                try {
                    consulta.consultaAdministrador(admin.getId());
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                win_mod_usuario.login_text.setText(admin.getLogin());
                win_mod_usuario.clave_text.setText(admin.getClave());
                win_mod_usuario.email_text.setText(admin.getEmail());
            }
            
            if (win_mod_usuario.alumno_rButt.isSelected()) {
                Alumno alumno = Alumno.getInstance();
                alumno.setId(win_mod_usuario.id_text.getText());
                try {
                    consulta.consultaAlumno(alumno.getId());
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                win_mod_usuario.nivel_id_text.setText(alumno.getNivel_id());
                win_mod_usuario.login_text.setText(alumno.getLogin());
                win_mod_usuario.clave_text.setText(alumno.getContraseña());
                win_mod_usuario.nombre_text.setText(alumno.getNombre());
                win_mod_usuario.apellidos_text.setText(alumno.getApellidos());
            }
            
            if (win_mod_usuario.profesor_rButt.isSelected()) {
                Profesor profe = Profesor.getInstance();
                profe.setId(win_mod_usuario.id_text.getText());
                try {
                    consulta.consultaProfesor(profe.getId());
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                win_mod_usuario.login_text.setText(profe.getLogin());
                win_mod_usuario.clave_text.setText(profe.getContraseña());
                win_mod_usuario.nombre_text.setText(profe.getNombre());
                win_mod_usuario.apellidos_text.setText(profe.getApellidos());
                win_mod_usuario.email_text.setText(profe.getEmail());
                win_mod_usuario.especialista_text.setText(profe.getEspecialista());
            }    
        }
        
        if (e.getSource() == win_mod_usuario.Mod_butt){
            if (win_mod_usuario.admin_rButt.isSelected()){
                Administrador admin = Administrador.getInstance();
                admin.setId(win_mod_usuario.id_text.getText());
                admin.setLogin(win_mod_usuario.login_text.getText());
                admin.setClave(win_mod_usuario.clave_text.getText());
                admin.setEmail(win_mod_usuario.email_text.getText());
                boolean actualizar;
                try {
                    actualizar=update.updateAdministrador(admin.getId());
                    if (actualizar == true) {
                        JOptionPane.showMessageDialog(null, "Administrador actualizado con éxito", "Insert exitoso", JOptionPane.QUESTION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo actualizar el administrador", "Insert fallido", JOptionPane.QUESTION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (win_mod_usuario.alumno_rButt.isSelected()){
                Alumno alumno = Alumno.getInstance();
                alumno.setNivel_id(win_mod_usuario.nivel_id_text.getText());
                alumno.setId(win_mod_usuario.id_text.getText());
                alumno.setLogin(win_mod_usuario.login_text.getText());
                alumno.setContraseña(win_mod_usuario.clave_text.getText());
                alumno.setNombre(win_mod_usuario.nombre_text.getText());
                alumno.setApellidos(win_mod_usuario.apellidos_text.getText());
                boolean actualizar;
                try {
                    actualizar=update.updateAlumno(alumno.getId());
                    if (actualizar == true) {
                        JOptionPane.showMessageDialog(null, "Alumno actualizado con éxito", "Insert exitoso", JOptionPane.QUESTION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo actualizar el alumno", "Insert fallido", JOptionPane.QUESTION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (win_mod_usuario.profesor_rButt.isSelected()){
                Profesor profe = Profesor.getInstance();
                profe.setId(win_mod_usuario.id_text.getText());
                profe.setLogin(win_mod_usuario.login_text.getText());
                profe.setContraseña(win_mod_usuario.clave_text.getText());
                profe.setNombre(win_mod_usuario.nombre_text.getText());
                profe.setApellidos(win_mod_usuario.apellidos_text.getText());
                profe.setEmail(win_mod_usuario.email_text.getText());
                profe.setEspecialista(win_mod_usuario.especialista_text.getText());
                boolean actualizar;
                try {
                    actualizar=update.updateProfesor(profe.getId());
                    if (actualizar == true) {
                        JOptionPane.showMessageDialog(null, "Profesor actualizado con éxito", "Insert exitoso", JOptionPane.QUESTION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo actualizar el profesor", "Insert fallido", JOptionPane.QUESTION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        /*Eventos de Admin - Asignaturas
        #######################################################################################################################################################################################
         */
        if (e.getSource() == win_principal_admin.baja_asignatura_menu) {
            win_baja_asignatura.setLocationRelativeTo(null);
            win_baja_asignatura.setVisible(true);
        }

        if (e.getSource() == win_baja_asignatura.cancelar_butt) {
            win_baja_asignatura.id_text.setText("");
            win_baja_asignatura.setVisible(false);
        }

        if (e.getSource() == win_baja_asignatura.eliminar_butt) {
            String Id = win_baja_asignatura.id_text.getText();
            boolean eliminar;
            try {
                eliminar = delete.deleteAsignatura(Id);
                if (eliminar == true) {
                    JOptionPane.showMessageDialog(null, "Asignatura eliminada con éxito", "Insert exitoso", JOptionPane.QUESTION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo eliminar la asignatura", "Insert fallido", JOptionPane.QUESTION_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == win_principal_admin.alta_asignatura_menu) {
            win_alta_asignatura.setLocationRelativeTo(null);
            win_alta_asignatura.setVisible(true);
        }
        if (e.getSource() == win_alta_asignatura.cancelar_butt) {
            win_alta_asignatura.setVisible(false);
            win_alta_asignatura.nivel_id_text.setText("");
            win_alta_asignatura.profesor_id_text.setText("");
            win_alta_asignatura.nombre_text.setText("");
        }

        if (e.getSource() == win_alta_asignatura.crear_butt) {
            Asignatura asignatura = Asignatura.getInstance();
            asignatura.setNivel_id(win_alta_asignatura.nivel_id_text.getText());
            asignatura.setProfesor_id(win_alta_asignatura.profesor_id_text.getText());
            asignatura.setNombre(win_alta_asignatura.nombre_text.getText());
            boolean insertar;
            try {
                insertar = insert.insertarAsignatura(asignatura.getNivel_id(), asignatura.getProfesor_id(), asignatura.getNombre());
                if (insertar == true) {
                    JOptionPane.showMessageDialog(null, "Asignatura creada con éxito", "Insert exitoso", JOptionPane.QUESTION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo crear la asignatura", "Insert fallido", JOptionPane.QUESTION_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource() == win_principal_admin.mod_datos_asignatura_menu) {
            win_mod_asignatura.setLocationRelativeTo(null);
            win_mod_asignatura.setVisible(true);
        }

        if (e.getSource() == win_mod_asignatura.cancelar_butt) {
            win_mod_asignatura.setVisible(false);
            win_mod_asignatura.id_text.setText("");
            win_mod_asignatura.nivel_id_text.setText("");
            win_mod_asignatura.profesor_id_text.setText("");
            win_mod_asignatura.nombre_text.setText("");
        }

        if (e.getSource() == win_mod_asignatura.cargar_butt) {
            Asignatura asignatura = Asignatura.getInstance();
            asignatura.setId(win_mod_asignatura.id_text.getText());
            try {
                consulta.consultaAsignatura(asignatura.getId());
            } catch (SQLException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            win_mod_asignatura.nivel_id_text.setText(asignatura.getNivel_id());
            win_mod_asignatura.profesor_id_text.setText(asignatura.getProfesor_id());
            win_mod_asignatura.nombre_text.setText(asignatura.getNombre());
        }

        if (e.getSource() == win_mod_asignatura.modificar_butt) {
            Asignatura asignatura = Asignatura.getInstance();
            asignatura.setId(win_mod_asignatura.id_text.getText());
            asignatura.setNivel_id(win_mod_asignatura.nivel_id_text.getText());
            asignatura.setProfesor_id(win_mod_asignatura.profesor_id_text.getText());
            asignatura.setNombre(win_mod_asignatura.nombre_text.getText());
            boolean actualizar;
            try {
                actualizar=update.updateAsignatura(asignatura.getId());
                if (actualizar == true) {
                    JOptionPane.showMessageDialog(null, "Asignatura actualizada con éxito", "Insert exitoso", JOptionPane.QUESTION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar la asignatura", "Insert fallido", JOptionPane.QUESTION_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (e.getSource() == win_principal_admin.matricular_alumno_menu) {
            win_mat_alumno.setLocationRelativeTo(null);
            win_mat_alumno.setVisible(true);
        }
        
        if (e.getSource() == win_mat_alumno.cancelar_butt){
            win_mat_alumno.setVisible(false);
            win_mat_alumno.id_alumno_text.setText("");
            win_mat_alumno.id_asignatura_text.setText("");
        }
        
        if (e.getSource() == win_mat_alumno.matricular_butt){
            String id_alumno =win_mat_alumno.id_alumno_text.getText();
            String id_asignatura = win_mat_alumno.id_asignatura_text.getText();
            boolean inscribir;
            try {
                inscribir = insert.insertarMatricula(id_alumno, id_asignatura);
                if (inscribir == true) {
                    JOptionPane.showMessageDialog(null, "Alumno matriculado con éxito", "Insert exitoso", JOptionPane.QUESTION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo matricular al alumno", "Insert fallido", JOptionPane.QUESTION_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        /*#######################################################################################################################################################
        #########################################################################################################################################################
        ##########################################################Fin Controlador para administrador#############################################################
        #########################################################################################################################################################
        #########################################################################################################################################################
        */
        
        /*#######################################################################################################################################################
        #########################################################################################################################################################
        ##########################################################Inicio Controlador para alumno#################################################################
        #########################################################################################################################################################
        #########################################################################################################################################################
        */
        if (e.getSource() == win_principal_alumno.consultar_Notas){
            win_consultar_nota.setLocationRelativeTo(null);
            win_consultar_nota.setVisible(true);
            Alumno alumno = Alumno.getInstance();
            try {
                ResultSet resultado = consulta.consultaMisAsignaturas(alumno.getId());
                while(true){
                    if(resultado.getRow() >0){
                        String nombre = resultado.getString("asignatura.nombre");
                        String id = resultado.getString("asignatura.id");
                        win_consultar_nota.asignaturas_text_area.append("Nombre: ");
                        win_consultar_nota.asignaturas_text_area.append(nombre);
                        win_consultar_nota.asignaturas_text_area.append(" ID: ");
                        win_consultar_nota.asignaturas_text_area.append(id);
                        win_consultar_nota.asignaturas_text_area.append("\n");
                        if(!resultado.next())
                            break;
                    }    
                }
            } catch (SQLException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == win_consultar_nota.cancelar_butt){
            win_consultar_nota.setVisible(false);
            win_consultar_nota.asignaturas_text_area.setText("");
            win_consultar_nota.id_asignatura.setText("");
            win_consultar_nota.nota_label.setText("");
        }
        
        if (e.getSource() == win_consultar_nota.consultar_butt){
            String id = win_consultar_nota.id_asignatura.getText();
            Alumno alumno = Alumno.getInstance();
            try {
                win_consultar_nota.nota_label.setText(consulta.consultaNota(alumno.getId(), id));
            } catch (SQLException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (e.getSource() == win_principal_alumno.listar_alumnos_menu){
            win_listar_alumnos.setLocationRelativeTo(null);
            win_listar_alumnos.setVisible(true);
            Alumno alumno = Alumno.getInstance();
            try {
                ResultSet resultado = consulta.consultaMisAsignaturas(alumno.getId());
                while(true){
                    if(resultado.getRow() >0){
                        String nombre = resultado.getString("asignatura.nombre");
                        String id = resultado.getString("asignatura.id");
                        win_listar_alumnos.asignaturas_text_area.append("Nombre: ");
                        win_listar_alumnos.asignaturas_text_area.append(nombre);
                        win_listar_alumnos.asignaturas_text_area.append(" ID: ");
                        win_listar_alumnos.asignaturas_text_area.append(id);
                        win_listar_alumnos.asignaturas_text_area.append("\n");
                        if(!resultado.next())
                            break;
                    }    
                }
            } catch (SQLException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == win_listar_alumnos.cancelar_butt){
            win_listar_alumnos.setVisible(false);
            win_listar_alumnos.asignaturas_text_area.setText("");
            win_listar_alumnos.id_asignatura.setText("");
            win_listar_alumnos.compañeros_text_area.setText("");
        }
        
        if (e.getSource() == win_listar_alumnos.consultar_butt){
            win_listar_alumnos.compañeros_text_area.setText("");
            String id = win_listar_alumnos.id_asignatura.getText();
            try {
                ResultSet resultado = consulta.consultaMisCompañeros(id);
                while(true){
                    if(resultado.getRow() >0){
                        String nombre = resultado.getString("alumno.nombre");
                        String apellido = resultado.getString("alumno.apellidos");
                        win_listar_alumnos.compañeros_text_area.append(nombre);
                        win_listar_alumnos.compañeros_text_area.append(" ");
                        win_listar_alumnos.compañeros_text_area.append(apellido);
                        win_listar_alumnos.compañeros_text_area.append("\n");
                        if(!resultado.next())
                            break;
                    }    
                }
            } catch (SQLException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (e.getSource() == win_listar_profesores.cancelar_butt){
            win_listar_profesores.setVisible(false);
            win_listar_profesores.profesores_text_area.setText("");
        }
        
        if (e.getSource() == win_principal_alumno.listar_profesores_menu){
            win_listar_profesores.setLocationRelativeTo(null);
            win_listar_profesores.setVisible(true);
            Alumno alumno = Alumno.getInstance();
            try {
                ResultSet resultado = consulta.consultaMisProfesores(alumno.getId());
                while(true){
                    if(resultado.getRow() >0){
                        String nombre_asignatura = resultado.getString("asig1.nombre");
                        String nombre_profesor = resultado.getString("profesor.nombre");
                        String apellidos_profesor = resultado.getString("profesor.apellidos");
                        win_listar_profesores.profesores_text_area.append(nombre_profesor);
                        win_listar_profesores.profesores_text_area.append(" ");
                        win_listar_profesores.profesores_text_area.append(apellidos_profesor);
                        win_listar_profesores.profesores_text_area.append(" ");
                        win_listar_profesores.profesores_text_area.append(nombre_asignatura);
                        win_listar_profesores.profesores_text_area.append("\n");
                        if(!resultado.next())
                            break;
                    }    
                }
            } catch (SQLException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        /*#######################################################################################################################################################
        #########################################################################################################################################################
        ##########################################################Fin Controlador para alumno####################################################################
        #########################################################################################################################################################
        #########################################################################################################################################################
        */
        
        /*#######################################################################################################################################################
        #########################################################################################################################################################
        ##########################################################Inicio Controlador para profesor###############################################################
        #########################################################################################################################################################
        #########################################################################################################################################################
        */
        if (e.getSource() == win_principal_profesor.listar_profesores_menu){
            win_listar_profesores2.setLocationRelativeTo(null);
            win_listar_profesores2.setVisible(true);
            try {
                ResultSet resultado = consulta.consultaProfesores();
                while(true){
                    if(resultado.getRow() >0){
                        String nombre_profesor = resultado.getString("profesor.nombre");
                        String apellidos_profesor = resultado.getString("profesor.apellidos");
                        win_listar_profesores2.profesores_text_area.append(nombre_profesor);
                        win_listar_profesores2.profesores_text_area.append(" ");
                        win_listar_profesores2.profesores_text_area.append(apellidos_profesor);
                        win_listar_profesores2.profesores_text_area.append("\n");
                        if(!resultado.next())
                            break;
                    }    
                }
            } catch (SQLException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == win_listar_profesores2.cancelar_butt){
            win_listar_profesores2.setVisible(false);
            win_listar_profesores2.profesores_text_area.setText("");
        }
        
        
        if (e.getSource() == win_principal_profesor.listar_alumnos_menu){
            win_listar_alumnos2.setLocationRelativeTo(null);
            win_listar_alumnos2.setVisible(true);
            Profesor profe = Profesor.getInstance();
            try {
                ResultSet resultado = consulta.consultaMisAsignaturasProfe(profe.getId());
                while(true){
                    if(resultado.getRow() >0){
                        String nombre = resultado.getString("asignatura.nombre");
                        String id = resultado.getString("asignatura.id");
                        win_listar_alumnos2.asignaturas_text_area.append("ID: ");
                        win_listar_alumnos2.asignaturas_text_area.append(id);
                        win_listar_alumnos2.asignaturas_text_area.append(" Nombre: ");
                        win_listar_alumnos2.asignaturas_text_area.append(nombre);
                        win_listar_alumnos2.asignaturas_text_area.append("\n");
                        if(!resultado.next())
                            break;
                    }    
                }
            } catch (SQLException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (e.getSource() == win_listar_alumnos2.cancelar_butt){
            win_listar_alumnos2.setVisible(false);
            win_listar_alumnos2.asignaturas_text_area.setText("");
        }
        
        if (e.getSource() == win_listar_alumnos2.consultar_butt){
            String id_asignatura =win_listar_alumnos2.id_asignatura.getText();
            win_listar_alumnos2.compañeros_text_area.setText("");
            try {
                ResultSet resultado = consulta.consultaMisCompañeros(id_asignatura);
                while(true){
                    if(resultado.getRow() >0){
                        String nombre = resultado.getString("alumno.nombre");
                        String apellidos = resultado.getString("alumno.apellidos");
                        win_listar_alumnos2.compañeros_text_area.append(nombre);
                        win_listar_alumnos2.compañeros_text_area.append(" ");
                        win_listar_alumnos2.compañeros_text_area.append(apellidos);
                        win_listar_alumnos2.compañeros_text_area.append("\n");
                        if(!resultado.next())
                            break;
                    }    
                }
            } catch (SQLException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        

        
        if (e.getSource() == win_principal_profesor.poner_notas_menu){
            win_poner_notas.setLocationRelativeTo(null);
            win_poner_notas.setVisible(true);
            Profesor profe = Profesor.getInstance();
            try {
                ResultSet resultado = consulta.consultaMisAsignaturasProfe(profe.getId());
                while(true){
                    if(resultado.getRow() >0){
                        String nombre = resultado.getString("asignatura.nombre");
                        String id = resultado.getString("asignatura.id");
                        win_poner_notas.asignaturas_text_area.append("ID: ");
                        win_poner_notas.asignaturas_text_area.append(id);
                        win_poner_notas.asignaturas_text_area.append(" Nombre: ");
                        win_poner_notas.asignaturas_text_area.append(nombre);
                        win_poner_notas.asignaturas_text_area.append("\n");
                        if(!resultado.next())
                            break;
                    }    
                }
            } catch (SQLException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (e.getSource() == win_poner_notas.cancelar_butt){
            win_poner_notas.setVisible(false);
            win_poner_notas.asignaturas_text_area.setText("");
            win_poner_notas.compañeros_text_area.setText("");
            win_poner_notas.id_alumno_text.setText("");
            win_poner_notas.nota_text.setText("");
        }
        
        if (e.getSource() == win_poner_notas.consultar_butt){
            String id_asignatura =win_poner_notas.id_asignatura.getText();
            win_poner_notas.compañeros_text_area.setText("");
            try {
                ResultSet resultado = consulta.consultaMisCompañeros(id_asignatura);
                while(true){
                    if(resultado.getRow() >0){
                        String nombre = resultado.getString("alumno.nombre");
                        String apellidos = resultado.getString("alumno.apellidos");
                        String id = resultado.getString("alumno.id");
                        win_poner_notas.compañeros_text_area.append("ID: ");
                        win_poner_notas.compañeros_text_area.append(id);
                        win_poner_notas.compañeros_text_area.append(" ");
                        win_poner_notas.compañeros_text_area.append(nombre);
                        win_poner_notas.compañeros_text_area.append(" ");
                        win_poner_notas.compañeros_text_area.append(apellidos);
                        win_poner_notas.compañeros_text_area.append("\n");
                        if(!resultado.next())
                            break;
                    }    
                }
            } catch (SQLException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (e.getSource() == win_poner_notas.asignar_nota_butt){
            String id_asignatura =win_poner_notas.id_asignatura.getText();
            String id_alumno = win_poner_notas.id_alumno_text.getText();
            String nota =win_poner_notas.nota_text.getText();
            boolean actualizar;
            try {
                actualizar =update.updateNota(id_asignatura, id_alumno, nota);
                if (actualizar == true) {
                    JOptionPane.showMessageDialog(null, "Nota actualizada con éxito", "Insert exitoso", JOptionPane.QUESTION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar la Nota", "Insert fallido", JOptionPane.QUESTION_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
        
        
        /*#######################################################################################################################################################
        #########################################################################################################################################################
        ##########################################################Fin Controlador para profesor##################################################################
        #########################################################################################################################################################
        #########################################################################################################################################################
        */
        
    }
}
