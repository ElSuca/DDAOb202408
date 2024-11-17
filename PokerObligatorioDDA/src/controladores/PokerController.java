/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.util.ArrayList;
import modelo.EstadoMesa;
import modelo.EventosGenerales;
import modelo.Fachada;
import modelo.Mesa;
import modelo.TipoFigura;
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
    private ArrayList<TipoFigura> figuras;
    private Mesa mesa;
    
    public PokerController(JugarPoker vista, Mesa m) {
        Fachada.getInstancia().agregarObservador(this);
        this.vista = vista;
        this.mesa = m;
        inicializarVista();
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento.equals(EventosGenerales.eventos.cambioListaJugadores)){
            vista.mostrarJugadores();
        }
        else if(evento.equals(EventosGenerales.eventos.cambioEstadoMesa)){
            if(mesa.getEstado() == EstadoMesa.Abierta){
                vista.mostrarDatosMesa(figuras);
            }
            else if(mesa.getEstado() == EstadoMesa.Iniciada){
                vista.iniciarPartida();
            }
        }
        else if(evento.equals(EventosGenerales.eventos.cambioSaldoJugador)){
            vista.mostrarJugador();
        }
        else if(evento.equals(EventosGenerales.eventos.cambiaronCartas)){
            vista.cargarCartas();
        }
        
    }

    private void inicializarVista() {
        figuras = Fachada.getInstancia().getFiguras();
        vista.mostrarDatosMesa(figuras);
    }
    
    public void salirMesa(UsuarioJugador usuario){
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
    
}
