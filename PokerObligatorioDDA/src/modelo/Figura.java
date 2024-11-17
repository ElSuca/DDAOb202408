/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import panelCartasPoker.CartaPoker;


public abstract class Figura {
    private String nombre;

    public Figura(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoFigura() {
        return nombre;
    }

    public void setTipo(String tipoFigura) {
        this.nombre = nombre;
    }
    
    public abstract boolean validar(ArrayList<CartaPoker> cartas);
    
}
