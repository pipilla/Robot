package org.iesalandalus.programacion.robot.modelo;

public class ControladorRobot {
    private Robot robot;

    ControladorRobot(Robot robot) {
        this.robot = new Robot(robot);
    }

    public Robot getRobot() {
        return new Robot(robot);
    }

    public void ejecutar(char comando) {
        switch (comando) {
            case 'A', 'a' -> robot.avanzar();
            case 'D', 'd' -> robot.girarALaDerecha();
            case 'I', 'i' -> robot.girarALaIzquierda();
        }
    }
}