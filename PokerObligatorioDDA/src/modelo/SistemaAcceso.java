/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import excepciones.LoginException;
import java.util.ArrayList;

public class SistemaAcceso {
    private ArrayList<UsuarioJugador> jugadores = new ArrayList<UsuarioJugador>();
    private ArrayList<Administrador> administradores = new ArrayList<Administrador>();
    private ArrayList<Sesion> sesiones = new ArrayList<Sesion>();

    public ArrayList<UsuarioJugador> getJugadores() {
        return jugadores;
    }
    public void agregarJugador(String ci, String pwd, String nombre, int saldo) {
        this.jugadores.add(new UsuarioJugador(ci, pwd, nombre, saldo));
    }

    UsuarioJugador loginJugador(Sesion sesion, String ci, String pwd) throws LoginException{
        return (UsuarioJugador) login(sesion, ci, pwd, jugadores);
    }
    
    public ArrayList<Administrador> getAdministradores() {
        return administradores;
    }
    
    public void agregarAdministrador(String ci, String pwd, String nombre){
        this.administradores.add(new Administrador(ci, pwd, nombre));
    }

    Administrador loginAdministrador(Sesion sesion, String ci, String pwd) throws LoginException{
        return (Administrador) login(sesion, ci, pwd, administradores);
    }
    
    private Usuario login(Sesion sesion, String nom, String pwd, ArrayList lista) throws LoginException{
        Usuario usuario;
        for(Object o:lista){
            usuario = (Usuario)o;
            if(usuario.getCi().equals(nom) && usuario.getPassword().equals(pwd)){
                for(Sesion s: sesiones){
                    if(s.ci.equals(usuario.getCi()) && s.pwd.equals(usuario.getPassword())) throw new LoginException("Acceso denegado");
                }
                sesiones.add(sesion);
                return usuario;
            }
        }
        return null;
    }

    public UsuarioJugador getJugador(UsuarioJugador jugador) {
        UsuarioJugador ret = null;
        for(UsuarioJugador j: jugadores){
            if(j.equals(jugador)){
                ret = jugador;
            }
        }
        return ret;
    }
    
    public void logout(Sesion s){
        sesiones.remove(s);
    }
    
}
