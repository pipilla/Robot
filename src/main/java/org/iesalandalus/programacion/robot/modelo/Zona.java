package org.iesalandalus.programacion.robot.modelo;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public record Zona(int ancho, int alto, Coordenada[] obstaculos) {
    public static final int ANCHO_MINIMO = 10;
    public static final int ANCHO_MAXIMO = 100;
    public static final int ALTO_MINIMO = 10;
    public static final int ALTO_MAXIMO = 100;

    public static final int MAXIMO_OBSTACULOS = 10;
    public static final int MINIMO_OBSTACULOS = 0;


    public Zona {
        validarAncho(ancho);
        validarAlto(alto);
        validarObstaculos(obstaculos);
    }

    public Zona() {
        this(ANCHO_MINIMO, ALTO_MINIMO, generarObstaculos());
    }

    public Zona(int ancho, int alto) {
        this(ancho, alto, generarObstaculos());
    }

    private void validarAncho(int ancho) {
        if (ancho < ANCHO_MINIMO || ancho > ANCHO_MAXIMO) {
            throw new IllegalArgumentException("Ancho no válido.");
        }
    }
    private void validarAlto(int alto) {
        if (alto < ALTO_MINIMO || alto > ALTO_MAXIMO) {
            throw new IllegalArgumentException("Alto no válido.");
        }
    }

    private void validarObstaculos(Coordenada[] obstaculos) {
        Objects.requireNonNull(obstaculos, "El obstáculo no puede ser nulo.");
    }

    private static Coordenada[] generarObstaculos() {
        Random generador = new Random();
        Coordenada[] obstaculos;

        int maxObstaculos = generador.nextInt(MINIMO_OBSTACULOS, MAXIMO_OBSTACULOS + 1);
        obstaculos = new Coordenada[MAXIMO_OBSTACULOS];
        Coordenada coordenada;
        int obstaculosGenerados = 0;
        for (int i = 0; i < maxObstaculos; i++) {

            do {
                int xAleatoria = generador.nextInt(ANCHO_MINIMO, ANCHO_MAXIMO + 1);
                int yAleatoria = generador.nextInt(ALTO_MINIMO, ALTO_MAXIMO + 1);
                coordenada = new Coordenada(xAleatoria, yAleatoria);
                obstaculos[i] = coordenada;
            } while (esObstaculo(obstaculos, coordenada));
        }
        return obstaculos;
    }
    public static boolean esObstaculo(Coordenada[] obstaculos ,Coordenada coordenada) {
        boolean obstaculo = false;
        for (int i = 0; i < MAXIMO_OBSTACULOS && !obstaculo; i++) {
            if (coordenada.equals(obstaculos[i]) || obstaculos[i] == null){
                obstaculo = true;
            }
        }
        return (obstaculo);
    }

    public Coordenada getCentro() {
        return new Coordenada(ancho / 2, alto / 2);
    }

    public boolean pertenece(Coordenada coordenada) {
        Objects.requireNonNull(coordenada, "La coordenada no puede ser nula.");
        return (perteneceX(coordenada.x()) && perteneceY(coordenada.y()));
    }

    private boolean perteneceX(int x) {
        return (ancho > x && x >= 0);
    }

    private boolean perteneceY(int y) {
        return (alto > y && y >= 0);
    }

    @Override
    public String toString() {
        return String.format("Zona[ancho=%s, alto=%s, obstaculos=%s]", this.ancho, this.alto, Arrays.toString(this.obstaculos));
    }
}
