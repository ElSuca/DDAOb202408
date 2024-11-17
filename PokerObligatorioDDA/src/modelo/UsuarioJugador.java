/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import panelCartasPoker.CartaPoker;

public class UsuarioJugador extends Usuario{
    private int saldo;
    private ArrayList<CartaPoker> cartas;
    private Figura figura;
    private SituacionJugador situacion;
    
    public UsuarioJugador(String ci, String password, String nombreCompleto, int saldo) {
        super(ci, password, nombreCompleto);
        this.saldo = saldo;
        this.cartas = new ArrayList<CartaPoker>();
        this.figura = null;
        this.situacion = null;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    public ArrayList<CartaPoker> getCartas(){
        return this.cartas;
    }
    
    public void setCartas(ArrayList<CartaPoker> cartas){
        this.cartas = cartas;
    }

    public Figura getFigura() {
        return figura;
    }

    public void setFigura(Figura figura) {
        this.figura = figura;
    }

    public void setSituacion(SituacionJugador situacionJugador) {
        this.situacion = situacionJugador;
    }
    
    public SituacionJugador getSituacion(){
        return this.situacion;
    }
    
    
}
