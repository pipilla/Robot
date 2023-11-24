package org.iesalandalus.programacion.robot;

import org.iesalandalus.programacion.robot.modelo.ControladorRobot;
import org.iesalandalus.programacion.robot.modelo.Robot;
import org.iesalandalus.programacion.robot.vista.Consola;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Main {
    private ControladorRobot controladorRobot;
    private void ejecutarOpcion(int opcion){
        opcion = Consola.elegirOpcion();
        switch (opcion) {
            case 1 -> controlarRobotDefecto();
            case 2 -> controlarRobotZona();
            case 3 -> controlarRobotZonaOrientacion();
            case 4 -> controlarRobotZonaOrientacionCoordenada();
            case 5 -> ejecutarComando();
            case 6 -> Consola.despedirse();
        }
    }
    private void controlarRobotDefecto(){
        controladorRobot = new ControladorRobot(new Robot());
    }

    private void controlarRobotZona(){
        controladorRobot = new ControladorRobot(new Robot(Consola.elegirZona()));
    }

}
