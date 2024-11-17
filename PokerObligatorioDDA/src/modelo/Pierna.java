/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import panelCartasPoker.CartaPoker;

public class Pierna extends Figura {
    
    public Pierna(String tipoFigura) {
        super(tipoFigura);
    }
    
    @Override
    public boolean validar(ArrayList<CartaPoker> cartas) {
        int[] contador = new int[14]; // Contadores para valores (1 al 13)
        for (CartaPoker carta : cartas) {
            contador[carta.getValorCarta()]++;
        }
        for (int c : contador) {
            if (c == 3) {
                return true; // Hay 4 cartas del mismo valor
            }
        }
        return false;
    }
    
}
