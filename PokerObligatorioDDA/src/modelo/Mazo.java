/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;
import java.util.Collections;
import panelCartasPoker.CartaPoker;

public class Mazo {
    private ArrayList<CartaPoker> cartas;

    public Mazo() {
        this.cartas = new ArrayList<CartaPoker>();
        agregarCartas();
    }

    public ArrayList<CartaPoker> getCartas() {
        return cartas;
    }
    
    public void agregarCartas(){
        for(int i = 1; i <= 13; i++){
            this.cartas.add(new Carta(i, CartaPoker.CORAZON));
        }
        for(int i = 1; i <= 13; i++){
            this.cartas.add(new Carta(i, CartaPoker.DIAMANTE));
        }
        for(int i = 1; i <= 13; i++){
            this.cartas.add(new Carta(i, CartaPoker.TREBOL));
        }
        for(int i = 1; i <= 13; i++){
            this.cartas.add(new Carta(i, CartaPoker.PIQUE));
        }
    }
    
    public void barajar(){
        Collections.shuffle(this.cartas);
    }
   
}
