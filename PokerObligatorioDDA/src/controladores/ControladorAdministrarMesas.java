/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.util.ArrayList;
import modelo.Administrador;
import modelo.EventosGenerales;
import modelo.Fachada;
import modelo.Mesa;
import observador.Observable;
import observador.Observador;
import vistaAdministrador.AdministrarMesas;
import vistas.vistaAdministrarMesas;

/**
 *
 * @author Usuario
 */
public class ControladorAdministrarMesas implements Observador {

    private vistaAdministrarMesas vista;
    private Administrador admin;
    private ArrayList<Mesa> resultado;
    private String filtro = "";

    public ControladorAdministrarMesas(vistaAdministrarMesas vista) {
        this.vista = vista;
        Fachada.getInstancia().agregarObservador(this);
        inicializarVista();
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        if (evento.equals(EventosGenerales.eventos.cambioListaMesas)) {
            resultado = Fachada.getInstancia().getMesas();
            vista.mostrarMesas(resultado);
        }
    }

    private void inicializarVista() {
        resultado = Fachada.getInstancia().getMesas();
        vista.mostrarMesas(resultado);
    }

    public void seleccionMesa(int indice) {
        if (resultado != null && indice >= 0) {
            Mesa seleccionada = resultado.get(indice);
            vista.mostrarDetallesMesa(
                    seleccionada.getManos(),
                    seleccionada.getNumeroMesa(),
                    seleccionada.getJugadores().size(),
                    seleccionada.getCantJugadores(),
                    seleccionada.getLuz(),
                    seleccionada.getManos().size(),
                    seleccionada.getPozo(),
                    seleccionada.getComision(),
                    seleccionada.getTotalRec(),
                    seleccionada.getEstado().toString()
            );
        }else vista.limpiarDetalles();
    }
}
