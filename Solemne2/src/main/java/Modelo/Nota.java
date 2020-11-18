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
public class Nota {
    int trimestr;
    double nota;

    public Nota(int trimestr, double nota) {
        this.trimestr = trimestr;
        this.nota = nota;
    }

    public int getTrimestr() {
        return trimestr;
    }

    public void setTrimestr(int trimestr) {
        this.trimestr = trimestr;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    
    
}
