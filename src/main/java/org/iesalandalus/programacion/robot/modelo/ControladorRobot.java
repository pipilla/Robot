package org.iesalandalus.programacion.robot.modelo;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControladorRobot {
    private Robot robot;

    public ControladorRobot(Robot robot) {
        Objects.requireNonNull(robot,"El robot no puede ser nulo.");
        this.robot = new Robot(robot);
    }

    public Robot getRobot() {
        return new Robot(robot);
    }

    public void ejecutar(char comando) throws OperationNotSupportedException {
        switch (comando) {
            case 'A', 'a' -> robot.avanzar();
            case 'D', 'd' -> robot.girarALaDerecha();
            case 'I', 'i' -> robot.girarALaIzquierda();
            default -> throw new OperationNotSupportedException("Comando desconocido.");
        }
    }

    public void ejecutarCadena(String comando) throws OperationNotSupportedException {
        if (comando.matches("[AaDdIi]+")) {
            for (char c : comando.toCharArray()) {
                try {
                    ejecutar(c);
                } catch (OperationNotSupportedException e) {
                    System.out.println(e.getMessage());
                }

            }
        } else {
            throw new OperationNotSupportedException("Comando desconocido.");
        }
    }
}
