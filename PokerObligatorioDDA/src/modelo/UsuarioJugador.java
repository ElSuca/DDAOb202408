/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
public class UsuarioJugador extends Usuario{
    private int saldo;
    
    public UsuarioJugador(String ci, String password, String nombreCompleto, int saldo) {
        super(ci, password, nombreCompleto);
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    
}
