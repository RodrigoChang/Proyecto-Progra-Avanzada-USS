/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author rodrigo
 */
public class Usuario {
    private int IDUsuario;
    private String Usuario;
    private String NombreApellidos;
    private String Identificacion;
    private String IdTipoUsuario;
    
    private static Usuario instance;
    
    private Usuario(){
        
    }

    public int getIDUsuario() {
        return IDUsuario;
    }

    public void setIDUsuario(int IDUsuario) {
        this.IDUsuario = IDUsuario;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getNombreApellidos() {
        return NombreApellidos;
    }

    public void setNombreApellidos(String NombreApellidos) {
        this.NombreApellidos = NombreApellidos;
    }

    public String getIdentificacion() {
        return Identificacion;
    }

    public void setIdentificacion(String Identificacion) {
        this.Identificacion = Identificacion;
    }

    public String getIdTipoUsuario() {
        return IdTipoUsuario;
    }

    public void setIdTipoUsuario(String IdTipoUsuario) {
        this.IdTipoUsuario = IdTipoUsuario;
    }
    
    public static Usuario getInstance(){
        if (instance == null)
            instance = new Usuario();
        return instance;
    }
}
