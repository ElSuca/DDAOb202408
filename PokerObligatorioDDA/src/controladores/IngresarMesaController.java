/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import excepciones.PokerException;
import java.util.ArrayList;
import modelo.EventosGenerales;
import modelo.Fachada;
import modelo.Mesa;
import modelo.UsuarioJugador;
import observador.Observable;
import observador.Observador;
import vistaJugador.JugarPoker;
import vistas.vistaIngresarMesa;

/**
 *
 * @author Usuario
 */
public class IngresarMesaController implements Observador {

    private vistaIngresarMesa vista;
    private ArrayList<Mesa> resultadoMesas;

    @Override
    public void actualizar(Object evento, Observable origen) {
        if (evento.equals(EventosGenerales.eventos.cambioListaMesas)
                || evento.equals(EventosGenerales.eventos.cambioSaldoJugador)
                || evento.equals(EventosGenerales.eventos.cambioListaJugadores)) {
            resultadoMesas = Fachada.getInstancia().getMesas();
            vista.mostrarMesas(resultadoMesas);
            vista.mostrarJugador();
        }
    }

    public IngresarMesaController(vistaIngresarMesa vista) {
        this.vista = vista;
        Fachada.getInstancia().agregarObservador(this);
        inicializarVista();
    }

    private void inicializarVista() {
        resultadoMesas = Fachada.getInstancia().getMesas();
        vista.mostrarMesas(resultadoMesas);
    }

    public void seleccionMesa(int indice) {
        if (resultadoMesas != null && indice >= 0) {
            Mesa seleccionada = resultadoMesas.get(indice);
            vista.mostrarDetallesMesa(
                    seleccionada.getNumeroMesa(),
                    seleccionada.getCantJugadores(),
                    seleccionada.getJugadores().size(),
                    seleccionada.getLuz(),
                    seleccionada.getComision()
            );
        } else {
            vista.limpiarDetallesMesa();
        }
    }

    public void jugarPoker(UsuarioJugador usuario, int indice) {
        if (resultadoMesas != null && indice >= 0) {
            Mesa seleccionada = resultadoMesas.get(indice);
            try {
                Fachada.getInstancia().verificarMesa(usuario);
                seleccionada.ingresarMesa(usuario);
                new JugarPoker(null, false, (UsuarioJugador) usuario, seleccionada).setVisible(true);
            } catch (PokerException ex) {
                vista.mostrarError(ex.getMessage());
            }
        }
    }

}
