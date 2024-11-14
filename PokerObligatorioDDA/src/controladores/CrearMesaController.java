/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import modelo.Administrador;
import modelo.EventosGenerales;
import modelo.Fachada;
import observador.Observable;
import observador.Observador;
import vistaAdministrador.CrearMesa;
import vistas.vistaCrearMesa;

/**
 *
 * @author Usuario
 */
public class CrearMesaController implements Observador{

    private vistaCrearMesa vista;
    public CrearMesaController(vistaCrearMesa vista) {
        this.vista = vista;
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento.equals(EventosGenerales.eventos.cambioListaMesas)){
            vista.mostrarMesas();
        }
    }

    public void crearMesa(String jugadores, String luz, String comision) {
        try{
        Fachada.getInstancia().agregarMesa(jugadores, luz, comision);
        }catch(NumberFormatException ex){
            vista.mostrarError(ex.getMessage());
        }
    }
}
