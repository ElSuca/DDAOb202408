/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import panelCartasPoker.CartaPoker;

public class Escalera extends Figura {
    
    public Escalera(String tipoFigura) {
        super(tipoFigura,4);
    }

    @Override
    public boolean validar(ArrayList<CartaPoker> cartas) {
        if(estaOrdenadoAsc(cartas)) return true;
        else if(estaOrdenadoDesc(cartas)) return true;
        else return false;
    }

    private boolean estaOrdenadoAsc(ArrayList<CartaPoker> cartas) {
        return estaOrdenadoAscRec(cartas, 0);
    }

    private boolean estaOrdenadoAscRec(ArrayList<CartaPoker> cartas, int pos){
        if(pos > 4) return false;
        else if(pos == 0) return estaOrdenadoAscRec(cartas, pos+1);
        else{
            if(cartas.get(pos).getValorCarta() > cartas.get(pos-1).getValorCarta() 
                    && cartas.get(pos-1).getValorCarta() != 1) return true && estaOrdenadoAscRec(cartas, pos+1); 
            else return false;
        }
    }
    
    private boolean estaOrdenadoDesc(ArrayList<CartaPoker> cartas) {
        return estaOrdenadoDescRec(cartas, 0);
    }

    private boolean estaOrdenadoDescRec(ArrayList<CartaPoker> cartas, int pos) {
        if(pos > 4) return false;
        else if(pos == 0) return estaOrdenadoAscRec(cartas, pos+1);
        else{
            if(cartas.get(pos).getValorCarta() < cartas.get(pos-1).getValorCarta() 
                    && cartas.get(pos).getValorCarta() != 1) return true && estaOrdenadoAscRec(cartas, pos+1); 
            else return false;
        }
    }
    
    
}
