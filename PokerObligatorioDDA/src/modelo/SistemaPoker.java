/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import excepciones.CrearMesaException;
import excepciones.PokerException;
import java.util.ArrayList;
import java.util.Random;
import panelCartasPoker.CartaPoker;

public class SistemaPoker {

    ArrayList<Mesa> mesas = new ArrayList<Mesa>();
    ArrayList<Figura> figuras = new ArrayList<Figura>();

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

    void ingresarMesa(UsuarioJugador usuario) throws PokerException {

        for (Mesa m : mesas) {
            for (UsuarioJugador j : m.getJugadores()) {
                int idxJ = m.getJugadores().indexOf(j);
                if (m.getJugadores().get(idxJ) == usuario) {
                    throw new PokerException("Ya estás en una partida");
                }
            }
        }
    }

    
    void agregarFigura(Figura figura) {
        this.figuras.add(figura);
    }

    ArrayList<Figura> getFiguras() {
        return figuras;
    }

    void figuraMasAlta(UsuarioJugador usuario) {
        for (Figura figura : figuras) {
            if (figura.validar(usuario.getCartas())) {
                usuario.setFigura(figura);
            }
        }
    }
   
}
