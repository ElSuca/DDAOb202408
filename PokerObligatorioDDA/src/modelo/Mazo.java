/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.List;

public class Mazo {
    private List<Carta> cartas;
    private int cantidad;

    public Mazo(List<Carta> cartas, int cantidad) {
        this.cartas = cartas;
        this.cantidad = cantidad;
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void AgregarCartas(Carta carta) {
        this.cartas.add(carta);
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
