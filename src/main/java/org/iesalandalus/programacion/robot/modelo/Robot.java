package org.iesalandalus.programacion.robot.modelo;

import java.util.Objects;

public class Robot {
    private Coordenada coordenada;
    private Orientacion orientacion;
    private Zona zona;
    public Robot() {
        zona = new Zona();
        coordenada = zona.getCentro();
        orientacion = Orientacion.NORTE;
    }

    public Robot(Zona zona) {
        this();
        setZona(zona);
        coordenada = zona.getCentro();
    }

    public Robot(Zona zona, Orientacion orientacion) {
        this(zona);
        this.orientacion = orientacion;
    }

    public Robot(Zona zona, Orientacion orientacion, Coordenada coordenada) {
        this(zona, orientacion);
        this.coordenada = coordenada;
    }

    public Robot(Robot robot) {
        coordenada = robot.getCoordenada();
        orientacion = robot.getOrientacion();
        zona = robot.getZona();
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        Objects.requireNonNull(zona, "Zona no puede ser nulo.");
        this.zona = zona;
    }

    public Orientacion getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(Orientacion orientacion) {
        Objects.requireNonNull(orientacion, "Orientacion no puede ser nulo.");
        this.orientacion = orientacion;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        Objects.requireNonNull(coordenada, "Coordenada no puede ser nulo.");
        if (zona.pertenece(coordenada)) {
            this.coordenada = coordenada;
        } else {
            throw new IllegalArgumentException("La coordenada no pertenece a la zona.");
        }
    }

    public void avanzar() {
        int nuevaCoordenadaX = 0;
        int nuevaCoordenadaY = 0;
        switch (orientacion) {
            case SUR -> nuevaCoordenadaY = coordenada.y() - 1;
            case SURESTE -> {
                nuevaCoordenadaX = coordenada.x() + 1;
                nuevaCoordenadaY = coordenada.y() - 1;
            }
            case ESTE -> nuevaCoordenadaX = coordenada.x() + 1;
            case NORESTE -> {
                nuevaCoordenadaX = coordenada.x() + 1;
                nuevaCoordenadaY = coordenada.y() + 1;
            }
            case NORTE -> nuevaCoordenadaY = coordenada.y() + 1;
            case NOROESTE -> {
                nuevaCoordenadaX = coordenada.x() - 1;
                nuevaCoordenadaY = coordenada.y() + 1;
            }
            case OESTE -> nuevaCoordenadaX = coordenada.x() - 1;
            case SUROESTE -> {
                nuevaCoordenadaX = coordenada.x() - 1;
                nuevaCoordenadaY = coordenada.y() - 1;
            }
        }
        setCoordenada(new Coordenada(nuevaCoordenadaX, nuevaCoordenadaY));

    }
    public void girarALaDerecha() {
        switch (orientacion) {
            case SUR -> setOrientacion(Orientacion.SUROESTE);
            case SUROESTE -> setOrientacion(Orientacion.OESTE);
            case OESTE -> setOrientacion(Orientacion.NOROESTE);
            case NOROESTE -> setOrientacion(Orientacion.NORTE);
            case NORTE -> setOrientacion(Orientacion.NORESTE);
            case NORESTE -> setOrientacion(Orientacion.ESTE);
            case ESTE -> setOrientacion(Orientacion.SURESTE);
            case SURESTE -> setOrientacion(Orientacion.SUR);
        }
    }

    public void girarALaIzquierda() {
        switch (orientacion) {
            case SUR -> setOrientacion(Orientacion.SURESTE);
            case SURESTE -> setOrientacion(Orientacion.ESTE);
            case ESTE -> setOrientacion(Orientacion.NORESTE);
            case NORESTE -> setOrientacion(Orientacion.NORTE);
            case NORTE -> setOrientacion(Orientacion.NOROESTE);
            case NOROESTE -> setOrientacion(Orientacion.OESTE);
            case OESTE -> setOrientacion(Orientacion.SUROESTE);
            case SUROESTE -> setOrientacion(Orientacion.SUR);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Robot robot = (Robot) o;
        return Objects.equals(coordenada, robot.coordenada) && orientacion == robot.orientacion && Objects.equals(zona, robot.zona);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordenada, orientacion, zona);
    }

    @Override
    public String toString() {
        return "Robot{" +
                "coordenada=" + coordenada +
                ", orientacion=" + orientacion +
                ", zona=" + zona +
                '}';
    }
}
