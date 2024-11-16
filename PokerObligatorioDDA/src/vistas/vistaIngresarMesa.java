/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vistas;
import java.util.ArrayList;
import modelo.Mesa;
import modelo.UsuarioJugador;

/**
 *
 * @author Usuario
 */
public interface vistaIngresarMesa {
    public void mostrarMesas(ArrayList<Mesa> mesas);
    
    public void mostrarJugador();
    
    public void limpiarDetallesJugador();
    
    public void limpiarDetallesMesa();
    
    public void mostrarDetallesMesa(int numeroMesa, int cantidadJugadores, int jugadores, int luz, int comision);

    public void mostrarError(String message);
}
