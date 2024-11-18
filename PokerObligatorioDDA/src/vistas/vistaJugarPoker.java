/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vistas;

import java.util.ArrayList;
import modelo.Figura;
import modelo.UsuarioJugador;

/**
 *
 * @author Usuario
 */
public interface vistaJugarPoker {
    
    public void mostrarDatosMesaAbierta(ArrayList<Figura> figuras);
    public void mostrarJugadores();
    public void cargarCartas();
    public void mostrarDatosMesa(ArrayList<Figura> figuras);
    public void mostrarJugador();

    public void mostrarError(String message);

    public void actualizarPozo(int pozo);
}
