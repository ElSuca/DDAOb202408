/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class Apuesta {
    private Figura figura;
    private UsuarioJugador jugador;
    private int valor;

    public Apuesta(Figura figura, UsuarioJugador jugador, int valor) {
        this.figura = figura;
        this.jugador = jugador;
        this.valor = valor;
    }

    public Figura getFigura() {
        return figura;
    }

    public void setFigura(Figura figura) {
        this.figura = figura;
    }

    public UsuarioJugador getJugador() {
        return jugador;
    }

    public void setJugador(UsuarioJugador jugador) {
        this.jugador = jugador;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
}
