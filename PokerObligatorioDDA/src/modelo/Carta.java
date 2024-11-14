/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import panelCartasPoker.CartaPoker;

public class Carta implements CartaPoker {
    private int valor;
    private String palo;
    private boolean visible = true;

    public Carta(int valor, String palo) {
        this.valor = valor;
        this.palo = palo;
    }
    
    @Override
    public int getValorCarta() {
        return valor;
    }

    @Override
    public String getPaloCarta() {
        return palo;
    }

    @Override
    public boolean estaVisible() {
        return visible;
    }

    @Override
    public void setVisible(boolean b) {
        visible = b;
    }
    
    
}
