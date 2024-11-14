/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;
import panelCartasPoker.CartaPoker;

public class Mazo {
    private ArrayList<Carta> cartas;

    public Mazo() {
        this.cartas = new ArrayList<Carta>();
        agregarCartas();
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }
    
    public void agregarCartas(){
        for(int i = 0; i <= 13; i++){
            this.cartas.add(new Carta(i, CartaPoker.CORAZON));
        }
        for(int i = 0; i <= 13; i++){
            this.cartas.add(new Carta(i, CartaPoker.DIAMANTE));
        }
        for(int i = 0; i <= 13; i++){
            this.cartas.add(new Carta(i, CartaPoker.TREBOL));
        }
        for(int i = 0; i <= 13; i++){
            this.cartas.add(new Carta(i, CartaPoker.PIQUE));
        }
        
    }
   
}
