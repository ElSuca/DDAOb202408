/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import excepciones.PokerException;
import java.util.ArrayList;
import java.util.Random;
import modelo.EventosGenerales.eventos;
import observador.Observable;
import panelCartasPoker.CartaPoker;

/**
 *
 * @author Usuario
 */
public class Mesa extends Observable {

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

    // <editor-fold defaultstate="collapsed" desc="Getter & Setter">      
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
    // </editor-fold>   

    public void pagarLuz() {
        for (UsuarioJugador u : this.jugadores) {
            u.setSaldo(u.getSaldo() - this.getLuz());
            this.pozo += luz;
        }
        avisar(eventos.cambioSaldoJugador);
        avisar(eventos.cambioPozo);
    }

    public void barajarCartas() {
        this.getMazo().barajar();
    }

    public void repartirCartas() {
        for (UsuarioJugador j : this.getJugadores()) {
            reparteJugador(j);
        }
    }

    public void iniciarMano() {
        this.getManos().add(new Mano(this));
        for (UsuarioJugador j : this.getJugadores()) {
            j.setSituacion(SituacionJugador.AccionPendiente);
        }
        avisar(eventos.cambioEstadoMano);
    }

    public void realizarApuesta(UsuarioJugador usuario, String monto) throws PokerException {
        try {
            if (this.getManos().getLast().getEstado() != EstadoMano.EsperandoApuesta) {
                throw new PokerException("No se puede iniciar una apuesta");
            } else {
                int apuesta = Integer.parseInt(monto);
                if (usuario.getSaldo() < apuesta) {
                    throw new PokerException("Saldo insuficiente");
                }
                for (UsuarioJugador j : this.getJugadores()) {
                    if (j.getSituacion() != SituacionJugador.AccionPendiente) {
                        throw new PokerException("No se puede apostar ahora");
                    }
                }
                usuario.setSaldo(usuario.getSaldo() - apuesta);
                usuario.setSituacion(SituacionJugador.ApuestaIniciada);
                this.setPozo(this.getPozo() + apuesta);
                this.getManos().getLast().setEstado(EstadoMano.ApuestaIniciada);
            }
            avisar(eventos.cambioPozo);
            avisar(eventos.cambioEstadoMano);
            avisar(eventos.cambioSaldoJugador);
            avisar(eventos.cambioSituacionJugador);
        } catch (NumberFormatException ex) {
            throw new PokerException("Monto inválido");
        }
    }

    public void noRealizarApuesta(UsuarioJugador usuario, String pozo) throws PokerException {

        if (this.getManos().getLast().getEstado() != EstadoMano.EsperandoApuesta) {
            throw new PokerException("No es posible indicar que no deseas iniciar una apuesta en este momento.");
        } else {
            usuario.setSituacion(SituacionJugador.NoPagaApuesta);
            int pozoAntiguo = Integer.parseInt(pozo);
            boolean noInicianApuesta = true;
            for (UsuarioJugador j : this.getJugadores()) {
                if (j.getSituacion() == SituacionJugador.AccionPendiente
                        || j.getSituacion() == SituacionJugador.ApuestaIniciada) {
                    noInicianApuesta = false;
                }
            }
            if (noInicianApuesta) {
                this.getManos().getLast().setEstado(EstadoMano.Terminada);
            }
            avisar(eventos.cambioPozo);
            avisar(eventos.cambioEstadoMano);
            avisar(eventos.cambioSituacionJugador);
        }

    }

    public void pagarApuesta(UsuarioJugador usuario, String monto) throws PokerException {

        if (this.getManos().getLast().getEstado() != EstadoMano.ApuestaIniciada) {
            throw new PokerException("No es posible pagar una apuesta en este momento");
        } else {
            int apuesta = Integer.parseInt(monto);
            if (usuario.getSituacion() == SituacionJugador.ApuestaPagada) {
                throw new PokerException("Ya pagaste esta apuesta");
            } else {
                if (usuario.getSituacion() == SituacionJugador.ApuestaIniciada) {
                    throw new PokerException("Tu iniciaste esta apuesta");
                }
            }
            if (usuario.getSaldo() > apuesta) {
                usuario.setSaldo(usuario.getSaldo() - apuesta);
                this.setPozo(this.getPozo() + apuesta);
                usuario.setSituacion(SituacionJugador.ApuestaPagada);
                validarMano();
                avisar(eventos.cambioPozo);
                avisar(eventos.cambioSaldoJugador);
                avisar(eventos.cambioSituacionJugador);
            } else {
                throw new PokerException("Saldo insuficiente");
            }
        }

    }

    public void pasarApuesta(UsuarioJugador usuario) throws PokerException {
        if (this.getManos().getLast().getEstado() != EstadoMano.ApuestaIniciada) {
            throw new PokerException("No es posible pasar en este momento");
        } else {
            if (usuario.getSituacion() == SituacionJugador.NoPagaApuesta) {
                throw new PokerException("Ya Pasaste");
            }
            if (usuario.getSituacion() == SituacionJugador.ApuestaIniciada) {
                throw new PokerException("Tu iniciaste esta apuesta");
            }
        }
        usuario.setSituacion(SituacionJugador.NoPagaApuesta);
        validarMano();
        avisar(eventos.cambioSituacionJugador);
    }

    public void salirMesa(UsuarioJugador usuario) {
        this.getJugadores().remove(usuario);
        this.setEstado(EstadoMesa.Abierta);
        usuario.setCartas(new ArrayList<CartaPoker>());
        avisar(eventos.cambioListaJugadores);
        avisar(eventos.cambioEstadoMesa);
    }

    public void ingresarMesa(UsuarioJugador usuario) throws PokerException {
        if (this.getLuz() * 10 < usuario.getSaldo()) {
            if (this.getCantJugadores() > this.getJugadores().size()) {
                this.getJugadores().add(usuario);
                if (this.getJugadores().size() == this.getCantJugadores()) {
                    this.setEstado(EstadoMesa.Iniciada);
                    avisar(eventos.cambioEstadoMesa);
                }
            } else {
                throw new PokerException("Ya ta llena");
            }
        } else {
            throw new PokerException("Usté' no tiene suficientes fondos");
        }
        avisar(eventos.cambioListaJugadores);
    }

    public void validarMano() {
        boolean pagan = false;
        for (UsuarioJugador j : this.getJugadores()) {
            if (j.getSituacion() == SituacionJugador.NoPagaApuesta) {
                pagan = true;
            }
        }
        if (pagan) {
            this.manos.getLast().setEstado(EstadoMano.Terminada);
        }
        boolean todosDecidieron = true;
        for (UsuarioJugador j : this.jugadores) {
            if (j.getSituacion() == SituacionJugador.AccionPendiente) {
                todosDecidieron = false;
            }
        }
        if (todosDecidieron) {
            this.manos.getLast().setEstado(EstadoMano.PidiendoCartas);
        }
        int losQuePiden = 0;
        for (UsuarioJugador j : this.jugadores) {
            if (j.getSituacion() != SituacionJugador.NoPagaApuesta
                    || j.getSituacion() != SituacionJugador.AccionPendiente) {
                losQuePiden++;
            }
        }
        if (losQuePiden == this.manos.getLast().getJugadores().size()) {
            this.manos.getLast().setEstado(EstadoMano.Terminada);
        }
        avisar(eventos.cambioEstadoMano);
    }

    public void reparteJugador(UsuarioJugador j) {
        Random random = new Random();
        if (j.getCartas().isEmpty()) {
            for (int i = 0; i < 5; i++) {
                int randomIdx = random.nextInt(1, this.getMazo().getCartas().size());
                j.getCartas().add(this.getMazo().getCartas().get(randomIdx));
                this.getMazo().getCartas().remove(randomIdx);
            }
        } else if (this.manos.getLast().getEstado() == EstadoMano.PidiendoCartas) {
            for (int i = 0; i < 5; i++) {
                int randomIdx = random.nextInt(this.getMazo().getCartas().size());
                if (!j.getCartas().get(i).estaVisible()) {
                    this.getMazo().getCartas().add(j.getCartas().get(i));
                    j.getCartas().set(i, this.getMazo().getCartas().get(randomIdx));
                    this.getMazo().getCartas().remove(randomIdx);
                }
            }
        }
        avisar(eventos.cambiaronCartas);
    }

    public void pedirCartas(UsuarioJugador usuario) throws PokerException{
        if(this.manos.getLast().getEstado() == EstadoMano.PidiendoCartas){
            if(usuario.getSituacion() == SituacionJugador.AccionPendiente 
                    || usuario.getSituacion() == SituacionJugador.NoPagaApuesta) throw new PokerException("Usted no puede pedir cartas");
        this.manos.getLast().getJugadores().add(new UsuarioJugador(usuario.getCi(), usuario.getPassword(),
                usuario.getNombreCompleto(), usuario.getSaldo(), usuario.getFigura(),  usuario.getCartas()));
        reparteJugador(usuario);
        validarMano();
        } else throw new PokerException("No se pueden pedir cartas en este momento");
    }

    public void determinarGanador() {
//        Figura laFiguraMasAlta;
//        UsuarioJugador ganador = null;
//        for(UsuarioJugador j: this.manos.getLast().getJugadores()){
//            if (ganador == null) {
//                ganador = j;
//            }
//
//            Figura figuraGanador = ganador.getFigura();
//            Figura figuraActual = j.getFigura();
//
//            // Compara las jerarquías de las figuras
//            if (figuraActual.getJerarquia() > figuraGanador.getJerarquia()) {
//                ganador = j;
//            } else if (figuraActual.getJerarquia() == figuraGanador.getJerarquia()) {
//                // Si las jerarquías son iguales, compara el valor más alto de la figura
//                int valorGanador = ganador.getMayorValorDeFigura();       // <--------------------
//                int valorActual = figuraActual.getMayorValorDeFigura(); // esto de acá es mi drama
//
//                if (valorActual > valorGanador) {
//                    ganador = j;
//                } else if (valorActual == valorGanador) {
//                    // Si el valor de la figura es igual, compara la carta más alta
//                    int cartaAltaGanador = ganador.getCartaMasAlta();
//                    int cartaAltaActual = j.getCartaMasAlta();
//
//                    if (cartaAltaActual > cartaAltaGanador) {
//                        ganador = j;
//                    }
//                }
//            }
//        }
    }

}
