package org.iesalandalus.programacion.robot;

import org.iesalandalus.programacion.robot.modelo.ControladorRobot;
import org.iesalandalus.programacion.robot.modelo.Robot;
import org.iesalandalus.programacion.robot.vista.Consola;
import org.iesalandalus.programacion.utilidades.Entrada;

import javax.naming.OperationNotSupportedException;

public class Main {
    private static ControladorRobot controladorRobot;
    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> controlarRobotDefecto();
            case 2 -> controlarRobotZona();
            case 3 -> controlarRobotZonaOrientacion();
            case 4 -> controlarRobotZonaOrientacionCoordenada();
            case 5 -> ejecutarComando();
            case 6 -> ejecutarCadenaComandos();
            case 7 -> Consola.despedirse();
        }
    }
    private static void controlarRobotDefecto() {
        controladorRobot = new ControladorRobot(new Robot());
        Consola.mostrarRobot(controladorRobot);
        ejecutarOpcion(Consola.elegirOpcion());
    }

    private static void controlarRobotZona() {
        controladorRobot = new ControladorRobot(new Robot(Consola.elegirZona()));
        Consola.mostrarRobot(controladorRobot);
        ejecutarOpcion(Consola.elegirOpcion());
    }

    private static void controlarRobotZonaOrientacion() {
        controladorRobot = new ControladorRobot(new Robot(Consola.elegirZona(), Consola.elegirOrientacion()));
        Consola.mostrarRobot(controladorRobot);
        ejecutarOpcion(Consola.elegirOpcion());
    }

    private static void controlarRobotZonaOrientacionCoordenada() {
        controladorRobot = new ControladorRobot(new Robot(Consola.elegirZona(), Consola.elegirOrientacion(), Consola.elegirCoordenada()));
        Consola.mostrarRobot(controladorRobot);
        ejecutarOpcion(Consola.elegirOpcion());
    }

    private static void ejecutarComando() {
        if (controladorRobot != null) {
            try {
                controladorRobot.ejecutar(Consola.elegirComando());
            } catch (OperationNotSupportedException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        } else {
            System.out.println("No hay ningún robot creado.");
        }

        Consola.mostrarRobot(controladorRobot);
        ejecutarOpcion(Consola.elegirOpcion());
    }

    private static void ejecutarCadenaComandos() {
        if (controladorRobot != null) {
            try {
                controladorRobot.ejecutarCadena(Consola.elegirSecuenciaComandos());
            } catch (OperationNotSupportedException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        } else {
            System.out.println("No hay ningún robot creado.");
        }

        Consola.mostrarRobot(controladorRobot);
        ejecutarOpcion(Consola.elegirOpcion());
    }

    public static void main(String[] args) {
        ejecutarOpcion(Consola.elegirOpcion());
    }

    // Dudas, al ejecutar el programa se lanzan excepciones y termina el programa, preguntar si pasa lo mismo en su programa.

}
