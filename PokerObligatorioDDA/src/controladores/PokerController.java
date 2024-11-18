/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import excepciones.PokerException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.EstadoMano;
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
        m.agregarObservador(this);
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
                iniciarPartida();
            }
        } else if (evento.equals(EventosGenerales.eventos.cambioPozo)) {
            vista.actualizarPozo(mesa.getPozo());
        } else if (evento.equals(EventosGenerales.eventos.cambioSaldoJugador)) {
            vista.mostrarJugador();
        } else if (evento.equals(EventosGenerales.eventos.cambiaronCartas)) {
            vista.cargarCartas();
        } else if (evento.equals(EventosGenerales.eventos.cambioSituacionJugador)) {
            vista.mostrarDatosMesa(figuras);
        } else if (evento.equals(EventosGenerales.eventos.cambioEstadoMano)){
            if(mesa.getManos().getLast().getEstado() == EstadoMano.ApuestaIniciada){
                vista.mostrarJugadores();
                vista.actualizarPozo(mesa.getPozo());
            }
            if(mesa.getManos().getLast().getEstado() == EstadoMano.Terminada){
                determinarGanador();
                vista.mostrarDatosMesa(figuras);
            }
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

    void iniciarPartida(){
        pagarLuz();
        barajarCartas();
        repartirCartas();
        iniciarMano();
        vista.mostrarDatosMesa(figuras);
    }
    
    public void salirMesa(UsuarioJugador usuario) {
        mesa.salirMesa(usuario);
        Fachada.getInstancia().salirMesa();
    }

    public void pagarLuz() {
        mesa.pagarLuz();
    }

    public void barajarCartas() {
        mesa.barajarCartas();
    }

    public void repartirCartas() {
        mesa.repartirCartas();
    }

    public void iniciarMano() {
        mesa.iniciarMano();
    }

    public void figuraMasAlta(UsuarioJugador usuario) {
        Fachada.getInstancia().figuraMasAlta(usuario);
    }

    public void realizarApuesta(UsuarioJugador usuario, String monto) {
        try {
            mesa.realizarApuesta(usuario, monto);
        } catch (PokerException ex) {
            vista.mostrarError(ex.getMessage());
        }
    }

    public void noRealizarApuesta(UsuarioJugador usuario, String pozo) {
        try {
            mesa.noRealizarApuesta(usuario, pozo);
        } catch (PokerException ex) {
            vista.mostrarError(ex.getMessage());
        }
    }

    public void pagarApuesta(UsuarioJugador usuario, String monto) {
        try {
            mesa.pagarApuesta(usuario, monto);
        } catch (PokerException ex) {
            vista.mostrarError(ex.getMessage());
        }
    }

    public void pasarApuesta(UsuarioJugador usuario) {
        try {
            mesa.pasarApuesta(usuario);
        } catch (PokerException ex) {
            vista.mostrarError(ex.getMessage());
        }
    }

    public void pedirCartas(UsuarioJugador usuario) {
        try {
            mesa.pedirCartas(usuario);
        } catch (PokerException ex) {
            vista.mostrarError(ex.getMessage());
        }
    }

    private void determinarGanador() {
        mesa.determinarGanador();
    }

    
    
}
