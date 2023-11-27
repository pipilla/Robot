package org.iesalandalus.programacion.robot;

import org.iesalandalus.programacion.robot.modelo.ControladorRobot;
import org.iesalandalus.programacion.robot.modelo.Robot;
import org.iesalandalus.programacion.robot.vista.Consola;
import org.iesalandalus.programacion.utilidades.Entrada;

import javax.naming.OperationNotSupportedException;

public class Main {
    private static ControladorRobot controladorRobot;
    private static void ejecutarOpcion(int opcion) throws OperationNotSupportedException {
        switch (opcion) {
            case 1 -> controlarRobotDefecto();
            case 2 -> controlarRobotZona();
            case 3 -> controlarRobotZonaOrientacion();
            case 4 -> controlarRobotZonaOrientacionCoordenada();
            case 5 -> ejecutarComando();
            case 6 -> Consola.despedirse();
        }
    }
    private static void controlarRobotDefecto() throws OperationNotSupportedException {
        controladorRobot = new ControladorRobot(new Robot());
        Consola.mostrarRobot(controladorRobot);
        ejecutarOpcion(Consola.elegirOpcion());
    }

    private static void controlarRobotZona() throws OperationNotSupportedException {
        controladorRobot = new ControladorRobot(new Robot(Consola.elegirZona()));
        Consola.mostrarRobot(controladorRobot);
        ejecutarOpcion(Consola.elegirOpcion());
    }

    private static void controlarRobotZonaOrientacion() throws OperationNotSupportedException {
        controladorRobot = new ControladorRobot(new Robot(Consola.elegirZona(), Consola.elegirOrientacion()));
        Consola.mostrarRobot(controladorRobot);
        ejecutarOpcion(Consola.elegirOpcion());
    }

    private static void controlarRobotZonaOrientacionCoordenada() throws OperationNotSupportedException {
        controladorRobot = new ControladorRobot(new Robot(Consola.elegirZona(), Consola.elegirOrientacion(), Consola.elegirCoordenada()));
        Consola.mostrarRobot(controladorRobot);
        ejecutarOpcion(Consola.elegirOpcion());
    }

    private static void ejecutarComando() throws OperationNotSupportedException {
        controladorRobot.ejecutar(Consola.elegirComando());
        Consola.mostrarRobot(controladorRobot);
        ejecutarOpcion(Consola.elegirOpcion());
    }

    public static void main(String[] args) throws OperationNotSupportedException {
        ejecutarOpcion(Consola.elegirOpcion());
    }

}
