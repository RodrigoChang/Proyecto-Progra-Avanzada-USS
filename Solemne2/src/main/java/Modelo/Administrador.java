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
public class Administrador {
    String id;
    String login, clave, email;
    private static Administrador instance;

    public Administrador(String id, String login, String clave, String email) {
        this.id = id;
        this.login = login;
        this.clave = clave;
        this.email = email;
    }

    public Administrador() {
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public static Administrador getInstance(){
        if (instance == null)
            instance = new Administrador();
        return instance;
    }
}
