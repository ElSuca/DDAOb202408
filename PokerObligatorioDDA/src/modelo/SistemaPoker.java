/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;
import java.util.List;

public class SistemaPoker {
    ArrayList<Mesa> mesas = new ArrayList<Mesa>();
    public ArrayList<Mesa> getMesas() {
        return mesas;
    }

    void agregarMesa(String jugadores, String luz, String comision) {
        try{
            int cantJugadores = Integer.parseInt(jugadores);
            int luzNum = Integer.parseInt(luz);
            int comisionNum = Integer.parseInt(comision);
            mesas.add(new Mesa(mesas.size()+1,  luzNum, comisionNum, cantJugadores ));
        }
        catch(NumberFormatException ex){
            
        }
    }
    
}
