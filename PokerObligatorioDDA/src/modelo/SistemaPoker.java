/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.List;

public class SistemaPoker {
    private List<UsuarioJugador> jugadores;

    public List<UsuarioJugador> getJugadores() {
        return jugadores;
    }
    public void AgregarJugadores(UsuarioJugador jugador) {
        this.jugadores.add(jugador);
    }
    
}
