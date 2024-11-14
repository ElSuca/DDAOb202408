/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import modelo.Administrador;
import observador.Observable;
import observador.Observador;
import vistaAdministrador.CrearMesa;
import vistas.vistaCrearMesa;

/**
 *
 * @author Usuario
 */
public class CrearMesaController implements Observador{

    public CrearMesaController(vistaCrearMesa vista) {
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
