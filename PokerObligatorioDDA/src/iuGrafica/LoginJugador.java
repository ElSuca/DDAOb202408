/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iuGrafica;

import excepciones.LoginException;
import java.awt.Frame;
import modelo.Fachada;
import modelo.Sesion;
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
    public Object llamarLogin(Sesion sesion, String ci, String password) throws LoginException{
        return Fachada.getInstancia().loginJugador(sesion, ci, password);
    }

    @Override
    public void proximoCasoUso(Sesion sesion, Object usuario) {
        new IngresarMesa(null, false,(UsuarioJugador)usuario, sesion).setVisible(true);
    }
    
    
    
}
