package org.iesalandalus.programacion.robot.vista;

import org.iesalandalus.programacion.robot.modelo.ControladorRobot;
import org.iesalandalus.programacion.robot.modelo.Coordenada;
import org.iesalandalus.programacion.robot.modelo.Orientacion;
import org.iesalandalus.programacion.robot.modelo.Zona;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
    private Consola(){

    }
    public static void mostrarMenuPrincipal() {
        System.out.println("Menú Principal");
        System.out.println();
        System.out.println("Opciones:");
        System.out.println();
        System.out.println("1. Controlar un robot por defecto");
        System.out.println("2. Controlar un robot indicando su zona");
        System.out.println("3. Controlar un robot indicando su zona y orientación");
        System.out.println("4. Controlar un robot indicando su zona, orientación y coordenada inicial");
        System.out.println("5. Ejecutar comando");
        System.out.println("6. Salir");
        System.out.println();
    }

    public static int elegirOpcion() {
        mostrarMenuPrincipal();
        int opcion;
        do {
            System.out.print("Elige una opción: ");
            opcion = Entrada.entero();
        } while (opcion < 1 || opcion > 6);
        return opcion;
    }

    public static Zona elegirZona(){
        int alto;
        int ancho;
        boolean existeZona;
        do {
            System.out.println("Dime el alto de la zona: ");
            alto = Entrada.entero();
            System.out.println("Dime el ancho de la zona: ");
            ancho = Entrada.entero();
            try {
                new Zona(ancho, alto);
                existeZona = true;
            } catch (IllegalArgumentException e) {
                existeZona = false;
            }
        } while (!existeZona);
        return new Zona(ancho, alto);
    }

    public static void mostrarMenuOrientacion() {
        System.out.println("Menú Orientación");
        System.out.println();
        System.out.println("Opciones:");
        System.out.println();
        System.out.println("1. Norte");
        System.out.println("2. Noreste");
        System.out.println("3. Este");
        System.out.println("4. Sureste");
        System.out.println("5. Sur");
        System.out.println("6. Suroeste");
        System.out.println("7. Oeste");
        System.out.println("8. Noroeste");
        System.out.println();
    }

    public static Orientacion elegirOrientacion() {
        mostrarMenuOrientacion();
        int nOrientacion;
        do {
            System.out.print("Elige una orientación: ");
            nOrientacion = Entrada.entero();
        } while (nOrientacion < 1 || nOrientacion > 8);
        Orientacion orientacion = Orientacion.NORTE;
        switch (nOrientacion) {
            case 1 -> {
                orientacion = Orientacion.NORTE;
            }
            case 2 -> {
                orientacion = Orientacion.NORESTE;
            }
            case 3 -> {
                orientacion = Orientacion.ESTE;
            }
            case 4 -> {
                orientacion = Orientacion.SURESTE;
            }
            case 5 -> {
                orientacion = Orientacion.SUR;
            }
            case 6 -> {
                orientacion = Orientacion.SUROESTE;
            }
            case 7 -> {
                orientacion = Orientacion.OESTE;
            }
            case 8 -> {
                orientacion = Orientacion.NOROESTE;
            }
        }
        return orientacion;
    }

    public static Coordenada elegirCoordenada() {
        System.out.print("Dime la componente x: ");
        int x = Entrada.entero();
        System.out.print("Dime la componente y: ");
        int y = Entrada.entero();
        return new Coordenada(x, y);
    }

    public static char elegirComando() {
        System.out.print("Elige el comando a ejecutar: ");
        return Entrada.caracter();
    }

    public static void mostrarRobot(ControladorRobot controladorRobot) {
        if (controladorRobot == null) {
            System.out.println("El robot es nulo");
        } else {
            System.out.println(controladorRobot.getRobot());
        }
    }

    public static void despedirse() {
        System.out.println("Hasta la próxima!");
    }
}
