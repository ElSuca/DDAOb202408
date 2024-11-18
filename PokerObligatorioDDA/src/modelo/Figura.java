/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import panelCartasPoker.CartaPoker;


public abstract class Figura {
    private String nombre;
    private int jerarquia;

    public Figura(String nombre, int jerarquia) {
        this.nombre = nombre;
        this.jerarquia = jerarquia;
    }

    public String getTipoFigura() {
        return nombre;
    }

    public void setTipo(String tipoFigura) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getJerarquia() {
        return jerarquia;
    }

    public void setJerarquia(int jerarquia) {
        this.jerarquia = jerarquia;
    }
    
    public abstract boolean validar(ArrayList<CartaPoker> cartas);

}
