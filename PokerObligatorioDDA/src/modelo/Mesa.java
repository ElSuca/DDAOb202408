/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Mesa {

    private int numeroMesa;
    private int luz;
    private ArrayList<UsuarioJugador> jugadores;
    private Mazo mazo;
    private ArrayList<Mano> manos;
    private EstadoMesa estado;
    private int pozo;
    private int comision;
    private int totalRec;
    private int cantJugadores;
    
    public Mesa(int numero, int luz, int comision, int cantJugadores) {
        this.numeroMesa = numero;
        this.luz = luz;
        this.cantJugadores = cantJugadores;
        this.jugadores = new ArrayList<UsuarioJugador>();
        this.mazo = new Mazo();
        this.manos = new ArrayList<Mano>();
        this.estado = EstadoMesa.Abierta;
        this.pozo = 0;
        this.comision = comision;
        this.totalRec = 0;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public int getLuz() {
        return luz;
    }

    public void setLuz(int luz) {
        this.luz = luz;
    }

    public ArrayList<UsuarioJugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<UsuarioJugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Mazo getMazo() {
        return mazo;
    }

    public void setMazo(Mazo mazo) {
        this.mazo = mazo;
    }

    public ArrayList<Mano> getManos() {
        return manos;
    }

    public void setManos(ArrayList<Mano> manos) {
        this.manos = manos;
    }

    public EstadoMesa getEstado() {
        return estado;
    }

    public void setEstado(EstadoMesa estado) {
        this.estado = estado;
    }

    public int getPozo() {
        return pozo;
    }

    public void setPozo(int pozo) {
        this.pozo = pozo;
    }

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }

    public int getTotalRec() {
        return totalRec;
    }

    public void setTotalRec(int totalRec) {
        this.totalRec = totalRec;
    }

    public int getCantJugadores() {
        return cantJugadores;
    }

    public void setCantJugadores(int cantJugadores) {
        this.cantJugadores = cantJugadores;
    }
    
    

}
