/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inicio;

import modelo.Fachada;

/**
 *
 * @author Usuario
 */
public class DatosPrueba {
    /*
        Administradores:
            Cédula: “100” - Password: “100” - Nombre Completo: “A 100”
            Cédula: “200” - Password: “101” - Nombre Completo: “A 200”
        Jugadores:
            Cédula: “0” - Password: “0” - Nombre Completo: “J0” - Saldo 0
            Cédula: “1” - Password: “1” - Nombre Completo: “J1” - Saldo 1000
            Cédula: “2” - Password: “2” - Nombre Completo: “J2” - Saldo 2000
            Cédula: “3” - Password: “3” - Nombre Completo: “J3” - Saldo 3000
            Cédula: “4” - Password: “4” - Nombre Completo: “J4” - Saldo 4000
            Cédula: “5” - Password: “5” - Nombre Completo: “J5” - Saldo 5000
            Cédula: “6” - Password: “6” - Nombre Completo: “J6” - Saldo 6000
            Cédula: “7” - Password: “7” - Nombre Completo: “J7 - Saldo 7000
            Cédula: “8” - Password: “8” - Nombre Completo: “J8” - Saldo 8000
            Cédula: “9” - Password: “9” - Nombre Completo: “J9” - Saldo 9000
            NOTA: Puede cargar además de los anteriores otros usuarios que ud. considere.
        Figuras: - Información básica: Nombre;
            En esta primera versión se deberán implementar y cargar las siguientes figuras:
            ● Poker: Cuatro cartas de igual valor sin importar el palo.
            ● Escalera: Cinco cartas cuyo valor está en escalera sin importar el palo.
            ● Pierna: Tres cartas de igual valor sin importar el palo.
            ● Par: Dos cartas de igual valor sin importar el palo.
            ● Sin figura: Las cartas no cumplen ninguno de los juegos anteriores
    */
    public static void cargar(){
        Fachada fachada = Fachada.getInstancia();

        fachada.agregarAdministrador("100", "100", "A 100");
        fachada.agregarAdministrador("200", "101", "A 200");

        fachada.agregarJugador("0", "0", "J0", 0);
        fachada.agregarJugador("1", "1", "J1", 1000);
        fachada.agregarJugador("2", "2", "J2", 2000);
        fachada.agregarJugador("3", "3", "J3", 3000);
        fachada.agregarJugador("4", "4", "J4", 4000);
        fachada.agregarJugador("5", "5", "J5", 5000);
        fachada.agregarJugador("6", "6", "J6", 6000);
        fachada.agregarJugador("7", "7", "J7", 7000);
        fachada.agregarJugador("8", "8", "J8", 8000);
        fachada.agregarJugador("9", "9", "J9", 9000);
        fachada.agregarJugador("10", "10", "El Tuki", 27478);
        fachada.agregarJugador("11", "11", "El Tiki", 99999);
    }
}
