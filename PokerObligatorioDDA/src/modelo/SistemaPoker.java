/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import excepciones.CrearMesaException;
import excepciones.PokerException;
import java.util.ArrayList;
import java.util.Random;

public class SistemaPoker {

    ArrayList<Mesa> mesas = new ArrayList<Mesa>();
    ArrayList<TipoFigura> figuras = new ArrayList<TipoFigura>();

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }

    void agregarMesa(String jugadores, String luz, String comision) throws CrearMesaException {
        int cantJugadores;
        int luzNum;
        int comisionNum;
        try {
            cantJugadores = Integer.parseInt(jugadores);
            luzNum = Integer.parseInt(luz);
            comisionNum = Integer.parseInt(comision);
            if (cantJugadores <= 5 && cantJugadores >= 2) {
                if (luzNum >= 1) {
                    if (comisionNum >= 1 && comisionNum <= 50) {
                        mesas.add(new Mesa(mesas.size() + 1, luzNum, comisionNum, cantJugadores));
                    } else {
                        throw new CrearMesaException("Comision inválida");
                    }
                } else {
                    throw new CrearMesaException("Apuesta base inválida");
                }
            } else {
                throw new CrearMesaException("Cantidad de jugadores no válida");
            }
        } catch (NumberFormatException ex) {
            throw new CrearMesaException("Uno de los valores no es un número");
        }
    }

    void ingresarMesa(UsuarioJugador usuario, Mesa seleccionada) throws PokerException {
        if (seleccionada.getLuz() * 10 < usuario.getSaldo()) {
            if (seleccionada.getCantJugadores() > seleccionada.getJugadores().size()) {
                seleccionada.getJugadores().add(usuario);
                if (seleccionada.getJugadores().size() == seleccionada.getCantJugadores()) {
                    seleccionada.setEstado(EstadoMesa.Iniciada);
                }
            } else throw new PokerException("Ya ta llena");
        } else {
            throw new PokerException("Usté' no tiene suficientes fondos");
        }
    }

    void salirMesa(UsuarioJugador usuario, Mesa seleccionada) {
        seleccionada.getJugadores().remove(usuario);
        seleccionada.setEstado(EstadoMesa.Abierta);
    }

    void agregarFigura(String figura) {
        this.figuras.add(new TipoFigura(figura));
    }

    ArrayList<TipoFigura> getFiguras() {
        return figuras;
    }

    void pagarLuz(Mesa mesa) {
        for(UsuarioJugador j: mesa.getJugadores()){
            j.setSaldo(j.getSaldo() - mesa.getLuz());
            mesa.setPozo(mesa.getPozo() + mesa.getLuz());
        }
    }

    void barajarCartas(Mesa mesa) {
        mesa.setMazo(new Mazo());
        mesa.getMazo().barajar();
    }

    void repartirCartas(Mesa mesa) {
        Random random = new Random();
        for(UsuarioJugador j: mesa.getJugadores()){
            for(int i = 0; i<5; i++){
                int randomIdx = random.nextInt(mesa.getMazo().getCartas().size());
                j.getCartas().add(mesa.getMazo().getCartas().get(randomIdx));
                mesa.getMazo().getCartas().remove(randomIdx);
            }
        }
    }

}
