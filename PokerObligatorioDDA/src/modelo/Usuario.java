/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
public abstract class Usuario {
    private String ci;
    private String password;
    private String nombreCompleto;

    public Usuario(String ci, String password, String nombreCompleto) {
        this.ci = ci;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
    }

    public String getCi() {
        return ci;
    }

    public String getPassword() {
        return password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    @Override
    public String toString() {
        return "Usuario{" + "ci=" + ci + ", password=" + password + ", nombreCompleto=" + nombreCompleto + '}';
    }
}
