/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;

public class SistemaAcceso {
    private ArrayList<UsuarioJugador> jugadores = new ArrayList<UsuarioJugador>();
    private ArrayList<Administrador> administradores = new ArrayList<Administrador>();

    public ArrayList<UsuarioJugador> getJugadores() {
        return jugadores;
    }
    public void agregarJugador(String ci, String pwd, String nombre, int saldo) {
        this.jugadores.add(new UsuarioJugador(ci, pwd, nombre, saldo));
    }

    UsuarioJugador loginJugador(String ci, String pwd) {
        return (UsuarioJugador) login(ci, pwd, jugadores);
    }
    
    public ArrayList<Administrador> getAdministradores() {
        return administradores;
    }
    
    public void agregarAdministrador(String ci, String pwd, String nombre){
        this.administradores.add(new Administrador(ci, pwd, nombre));
    }

    Administrador loginAdministrador(String ci, String pwd) {
        return (Administrador) login(ci, pwd, administradores);
    }
    
    private Usuario login(String nom, String pwd, ArrayList lista){
        Usuario usuario;
        for(Object o:lista){
            usuario = (Usuario)o;
            if(usuario.getCi().equals(nom) && usuario.getPassword().equals(pwd)){
                return usuario;
            }
        }
        return null;
    }
}
