/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Fabián
 */
public class Alumno {
    private String id;
    private Nivel nivel;
    private String login, contraseña, nombre, apellidos,nivel_id;
    private static Alumno instance;

    public Alumno(String id, Nivel nivel, String login, String contraseña, String nombre, String apellidos) {
        this.id = id;
        this.nivel = nivel;
        this.login = login;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public Alumno() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNivel_id() {
        return nivel_id;
    }

    public void setNivel_id(String nivel_id) {
        this.nivel_id = nivel_id;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public static Alumno getInstance(){
        if (instance == null)
            instance = new Alumno();
        return instance;
    }
    
}
