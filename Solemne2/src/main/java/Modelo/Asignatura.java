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
public class Asignatura {
    String id,nivel_id,profesor_id;
    Nivel nivel;
    Profesor profesor;
    String nombre;
    private static Asignatura instance;

    public Asignatura(String id, Nivel nivel, Profesor profesor, String nombre) {
        this.id = id;
        this.nivel = nivel;
        this.profesor = profesor;
        this.nombre = nombre;
    }

    public Asignatura() {
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

    public String getProfesor_id() {
        return profesor_id;
    }

    public void setProfesor_id(String profesor_id) {
        this.profesor_id = profesor_id;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public static Asignatura getInstance(){
        if (instance == null)
            instance = new Asignatura();
        return instance;
    }
    
    
}
