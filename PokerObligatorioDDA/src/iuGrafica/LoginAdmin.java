/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iuGrafica;

import java.awt.Frame;
import modelo.Administrador;
import modelo.Fachada;
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
    public Object llamarLogin(String ci, String password) {
        return Fachada.getInstancia().loginAdministrador(ci, password);
    }

    @Override
    public void proximoCasoUso(Object usuario) {
        new AdministrarMesas(null, false, (Administrador) usuario).setVisible(true);
    }

}
