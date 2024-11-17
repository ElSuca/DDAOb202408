/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vistas;

import java.util.ArrayList;
import modelo.TipoFigura;
import modelo.UsuarioJugador;

/**
 *
 * @author Usuario
 */
public interface vistaJugarPoker {
    
    public void mostrarDatosMesa(ArrayList<TipoFigura> figuras);
    public void mostrarJugadores();
    public void iniciarPartida();
    public void cargarCartas();

    public void mostrarJugador();
}
