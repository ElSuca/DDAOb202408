/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iuGrafica;

import excepciones.LoginException;
import java.awt.Frame;
import modelo.Administrador;
import modelo.Fachada;
import modelo.Sesion;
import vistaAdministrador.AdministrarMesas;

/**
 *
 * @author Usuario
 */
public class LoginAdmin extends Login {

    public LoginAdmin(Frame parent, boolean modal) {
        super(parent, modal, "Login como ADMINISTRADOR");
    }

    @Override
    public Object llamarLogin(Sesion sesion, String ci, String password) throws LoginException{
        return Fachada.getInstancia().loginAdministrador(sesion, ci, password);
    }

    @Override
    public void proximoCasoUso(Sesion sesion, Object usuario) {
        new AdministrarMesas(null, false, (Administrador) usuario, sesion).setVisible(true);
    }

}
