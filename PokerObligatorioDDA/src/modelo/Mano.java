/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class Mano {
    private int numeroMano;
    private Figura figuraGanadora;
    private EstadoMano estado;
    private int valorMano;
    private Mesa mesa;

    public Mano(Figura figuraGanadora, EstadoMano estado, int valorMano, Mesa mesa) {
        this.numeroMano = mesa.getManos().size()+1;
        this.figuraGanadora = null;
        this.estado = EstadoMano.EsperandoApuesta;
        this.mesa = mesa;
        this.valorMano = mesa.getLuz();
    }

    public Figura getFiguraGanadora() {
        return figuraGanadora;
    }

    public void setFiguraGanadora(Figura figuraGanadora) {
        this.figuraGanadora = figuraGanadora;
    }

    public EstadoMano getEstado() {
        return estado;
    }

    public void setEstado(EstadoMano estado) {
        this.estado = estado;
    }

    public int getValorMano() {
        return valorMano;
    }

    public void setValorMano(int valorMano) {
        this.valorMano = valorMano;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public int getNumeroMano() {
        return numeroMano;
    }

    public void setNumeroMano(int numeroMano) {
        this.numeroMano = numeroMano;
    }

    
    
}
