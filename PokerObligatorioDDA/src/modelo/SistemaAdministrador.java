/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.List;

public class SistemaAdministrador {
    private List<Administrador> administradores;

    public List<Administrador> getAdministradores() {
        return administradores;
    }
    
    public void AgregarAdministradores(Administrador admin){
        this.administradores.add(admin);
    }
}
