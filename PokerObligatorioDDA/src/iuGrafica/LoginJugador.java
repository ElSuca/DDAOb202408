/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iuGrafica;

import java.awt.Frame;
import modelo.Fachada;
import modelo.UsuarioJugador;
import vistaJugador.IngresarMesa;

/**
 *
 * @author Usuario
 */
public class LoginJugador extends Login {
    
    public LoginJugador(Frame parent, boolean modal) {
        super(parent, modal, "Login como JUGADOR");
    }

    @Override
    public Object llamarLogin(String ci, String password) {
        return Fachada.getInstancia().loginJugador(ci, password);
    }

    @Override
    public void proximoCasoUso(Object usuario) {
        new IngresarMesa(null, false,(UsuarioJugador)usuario).setVisible(true);
    }
    
}
