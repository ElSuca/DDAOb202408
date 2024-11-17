/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;


public abstract class Figura {
    private TipoFigura tipoFigura;

    public Figura(TipoFigura tipoFigura) {
        this.tipoFigura = tipoFigura;
    }

    public TipoFigura getTipoFigura() {
        return tipoFigura;
    }

    public void setTipo(TipoFigura tipoFigura) {
        this.tipoFigura = tipoFigura;
    }
    
    public abstract boolean validar(ArrayList<Carta> cartas);
    
}
