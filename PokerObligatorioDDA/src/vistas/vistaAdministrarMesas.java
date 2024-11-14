/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vistas;

import java.util.ArrayList;
import modelo.Mano;
import modelo.Mesa;

/**
 *
 * @author Usuario
 */
public interface vistaAdministrarMesas {

    public void mostrarMesas(ArrayList<Mesa> mesas);

    public void limpiarDetalles();

    public void mostrarDetallesMesa(ArrayList<Mano> manos, int numeroMesa, int size, int cantJugadores, int luz, int size0, int pozo, int comision, int totalRec, String toString);
    
}
