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
    private SistemaAdministrador sAdmin = new SistemaAdministrador();
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
    }

    public void logout(Sesion s) {
        sAcceso.logout(s);
    }
}
