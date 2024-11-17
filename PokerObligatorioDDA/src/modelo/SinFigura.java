/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import panelCartasPoker.CartaPoker;

public class SinFigura extends Figura {
    public SinFigura(String tipoFigura) {
        super(tipoFigura);
    }

    @Override
    public boolean validar(ArrayList<CartaPoker> cartas) {
        return true;
    }
}
