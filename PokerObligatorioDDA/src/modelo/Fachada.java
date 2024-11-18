/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import excepciones.CrearMesaException;
import excepciones.LoginException;
import excepciones.PokerException;
import java.util.ArrayList;
import modelo.EventosGenerales.eventos;
import observador.Observable;
import vistaAdministrador.AdministrarMesas;

/**
 *
 * @author Usuario
 */
public class Fachada extends Observable {

    private SistemaAcceso sAcceso = new SistemaAcceso();
    private SistemaPoker sPoker = new SistemaPoker();

    private static Fachada instancia = new Fachada();

    public static Fachada getInstancia() {
        return instancia;
    }

    private Fachada() {
    }

    public void agregarAdministrador(String ci, String pwd, String nombreCompleto) {
        sAcceso.agregarAdministrador(ci, pwd, nombreCompleto);
    }

    public Administrador loginAdministrador(Sesion sesion, String ci, String pwd) throws LoginException {
        return sAcceso.loginAdministrador(sesion, ci, pwd);
    }

    public void agregarJugador(String ci, String pwd, String nombreCompleto, int saldoInicial) {
        sAcceso.agregarJugador(ci, pwd, nombreCompleto, saldoInicial);
    }

    public UsuarioJugador getJugador(UsuarioJugador jugador) {
        return sAcceso.getJugador(jugador);
    }

    public UsuarioJugador loginJugador(Sesion sesion, String ci, String pwd) throws LoginException {
        return sAcceso.loginJugador(sesion, ci, pwd);
    }

    public ArrayList<Mesa> getMesas() {
        return sPoker.getMesas();
    }

    public void agregarMesa(String jugadores, String luz, String comision) throws CrearMesaException {
        sPoker.agregarMesa(jugadores, luz, comision);
        avisar(eventos.cambioListaMesas);
    }

    public void ingresarMesa(UsuarioJugador usuario, Mesa seleccionada) throws PokerException {
        sPoker.ingresarMesa(usuario, seleccionada);
        avisar(eventos.cambioEstadoMesa);
        avisar(eventos.cambioListaJugadores);
    }

    public void logout(Sesion s) {
        sAcceso.logout(s);
    }

    public void agregarFigura(Figura figura) {
        sPoker.agregarFigura(figura);
    }

    public ArrayList<Figura> getFiguras() {
        return sPoker.getFiguras();
    }

    public void salirMesa(UsuarioJugador usuario, Mesa seleccionada) {
        sPoker.salirMesa(usuario, seleccionada);
        avisar(eventos.cambioListaJugadores);
        avisar(eventos.cambioEstadoMesa);
    }

    public void pagarLuz(Mesa mesa) {
        sPoker.pagarLuz(mesa);
        avisar(eventos.cambioSaldoJugador);
    }

    public void barajarCartas(Mesa mesa) {
        sPoker.barajarCartas(mesa);
    }

    public void repartirCartas(Mesa mesa) {
        sPoker.repartirCartas(mesa);
        avisar(eventos.cambiaronCartas);
    }

    public void iniciarMano(Mesa mesa) {
        sPoker.iniciarMano(mesa);
        avisar(eventos.cambioEstadoMano);
    }

    public void figuraMasAlta(UsuarioJugador usuario) {
        sPoker.figuraMasAlta(usuario);
    }

    public void realizarApuesta(UsuarioJugador usuario, Mesa mesa, String monto) throws PokerException {
        sPoker.realizarApuesta(usuario, mesa, monto);
        avisar(eventos.cambioPozo);
        avisar(eventos.cambioEstadoMano);
        avisar(eventos.cambioSaldoJugador);
        avisar(eventos.cambioSituacionJugador);

    }

    public void noRealizarApuesta(UsuarioJugador usuario, Mesa mesa, String pozo) throws PokerException {
        sPoker.noRealizarApuesta(usuario, mesa, pozo);
        avisar(eventos.cambioPozo);
        avisar(eventos.cambioEstadoMano);
        avisar(eventos.cambioSituacionJugador);
    }

    public void pagarApuesta(UsuarioJugador usuario, String monto, Mesa mesa) throws PokerException {
        sPoker.pagarApuesta(usuario, monto, mesa);
        avisar(eventos.cambioPozo);
        avisar(eventos.cambioEstadoMano);
        avisar(eventos.cambioSaldoJugador);
        avisar(eventos.cambioSituacionJugador);
    }

    public void pasarApuesta(UsuarioJugador usuario, Mesa mesa) throws PokerException {
        sPoker.pasarApuesta(usuario, mesa);
        avisar(eventos.cambioEstadoMesa);
        avisar(eventos.cambioSituacionJugador);
    }
}
