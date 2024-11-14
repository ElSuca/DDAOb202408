/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

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

    public Administrador loginAdministrador(String ci, String pwd) {
        return sAcceso.loginAdministrador(ci, pwd);
    }

    public void agregarJugador(String ci, String pwd, String nombreCompleto, int saldoInicial) {
        sAcceso.agregarJugador(ci, pwd, nombreCompleto, saldoInicial);
    }

    public UsuarioJugador loginJugador(String ci, String pwd) {
        return sAcceso.loginJugador(ci, pwd);
    }
}
