/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;
import java.util.ArrayList;
import modelo.EventosGenerales;
import modelo.Fachada;
import modelo.Mesa;
import modelo.UsuarioJugador;
import observador.Observable;
import observador.Observador;
import vistas.vistaIngresarMesa;

/**
 *
 * @author Usuario
 */
public class IngresarMesaController implements Observador {
    
    private vistaIngresarMesa vista;
    private UsuarioJugador resultadoJugador;
    private ArrayList<Mesa> resultadoMesas;
    private String filtro = "";

    @Override
    public void actualizar(Object evento, Observable origen) {
        if (evento.equals(EventosGenerales.eventos.cambioListaMesas) ||
                evento.equals(EventosGenerales.eventos.cambioSaldoJugador)) {
            resultadoMesas = Fachada.getInstancia().getMesas();
            vista.mostrarMesas(resultadoMesas);
            vista.mostrarJugador(Fachada.getInstancia().getJugador(resultadoJugador));
        }
    }
    
    public IngresarMesaController(vistaIngresarMesa vista) {
        this.vista = vista;
        Fachada.getInstancia().agregarObservador(this);
        inicializarVista();
    }
    
    private void inicializarVista() {
        resultadoMesas = Fachada.getInstancia().getMesas();
        vista.mostrarMesas(resultadoMesas);
    }
    
    public void saldoJugador(){
        if(resultadoJugador != null){
            vista.mostrarJugador(resultadoJugador);
        } else vista.limpiarDetallesJugador();
    }
    
    public void seleccionMesa(int indice) {
        if (resultadoMesas != null && indice >= 0) {
            Mesa seleccionada = resultadoMesas.get(indice);
            vista.mostrarDetallesMesa(
                    seleccionada.getNumeroMesa(),
                    seleccionada.getCantJugadores(),
                    seleccionada.getLuz(),
                    seleccionada.getComision()
            );
        }else vista.limpiarDetallesMesa();
    }

}
