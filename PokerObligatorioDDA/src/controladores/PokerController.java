/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import excepciones.PokerException;
import java.util.ArrayList;
import modelo.EstadoMesa;
import modelo.EventosGenerales;
import modelo.Fachada;
import modelo.Figura;
import modelo.Mesa;
import modelo.UsuarioJugador;
import observador.Observable;
import observador.Observador;
import vistaJugador.JugarPoker;
import vistas.vistaJugarPoker;

/**
 *
 * @author Usuario
 */
public class PokerController implements Observador {

    private vistaJugarPoker vista;
    private ArrayList<Figura> figuras;
    private Mesa mesa;

    public PokerController(JugarPoker vista, Mesa m) {
        Fachada.getInstancia().agregarObservador(this);
        this.vista = vista;
        this.mesa = m;
        inicializarVista();
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        if (evento.equals(EventosGenerales.eventos.cambioListaJugadores)) {
            vista.mostrarJugadores();
        } else if (evento.equals(EventosGenerales.eventos.cambioEstadoMesa)) {
            if (mesa.getEstado() == EstadoMesa.Abierta) {
                vista.mostrarDatosMesaAbierta(figuras);
            } else if (mesa.getEstado() == EstadoMesa.Iniciada) {
                vista.iniciarPartida(figuras);
            }
        } else if (evento.equals(EventosGenerales.eventos.cambioPozo)) {
            vista.actualizarPozo(mesa.getPozo());
        } else if (evento.equals(EventosGenerales.eventos.cambioSaldoJugador)) {
            vista.mostrarJugador();
        } else if (evento.equals(EventosGenerales.eventos.cambiaronCartas)) {
            vista.cargarCartas();
        } else if (evento.equals(EventosGenerales.eventos.cambioSituacionJugador)) {
            vista.mostrarDatosMesa(figuras);
        }

    }

    private void inicializarVista() {
        figuras = Fachada.getInstancia().getFiguras();
        if (mesa.getEstado() == EstadoMesa.Abierta) {
            vista.mostrarDatosMesaAbierta(figuras);
        } else if (mesa.getEstado() == EstadoMesa.Iniciada) {

            vista.mostrarDatosMesa(figuras);
        }

    }

    public void salirMesa(UsuarioJugador usuario) {
        Fachada.getInstancia().salirMesa(usuario, mesa);
    }

    public void pagarLuz() {
        Fachada.getInstancia().pagarLuz(mesa);
    }

    public void barajarCartas() {
        Fachada.getInstancia().barajarCartas(mesa);
    }

    public void repartirCartas() {
        Fachada.getInstancia().repartirCartas(mesa);
    }

    public void iniciarMano() {
        Fachada.getInstancia().iniciarMano(mesa);
    }

    public void figuraMasAlta(UsuarioJugador usuario) {
        Fachada.getInstancia().figuraMasAlta(usuario);
    }

    public void realizarApuesta(UsuarioJugador usuario, String monto) {
        try {
            Fachada.getInstancia().realizarApuesta(usuario, mesa, monto);
        } catch (PokerException ex) {
            vista.mostrarError(ex.getMessage());
        }
    }

}
