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
    public static final Random generador = new Random();


    public Zona {
        validarAncho(ancho);
        validarAlto(alto);
        if (obstaculos == null) {
            obstaculos = new Coordenada[generador.nextInt(MINIMO_OBSTACULOS, MAXIMO_OBSTACULOS + 1)];
            obstaculos = generarObstaculos(obstaculos, ancho, alto);
        }
    }

    public Zona() {
        this(ANCHO_MINIMO, ALTO_MINIMO, null);
    }

    public Zona(int ancho, int alto) {
        this(ancho, alto, null);
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

    private static Coordenada[] generarObstaculos(Coordenada[] obstaculos, int ancho, int alto) {
        Coordenada coordenada;
        for (int i = 0; i < obstaculos.length; i++) {
            do {
                int xAleatoria = generador.nextInt(0, ancho + 1);
                int yAleatoria = generador.nextInt(0, alto + 1);
                coordenada = new Coordenada(xAleatoria, yAleatoria);
            } while (esObstaculo(obstaculos, coordenada));
            obstaculos[i] = coordenada;
        }
        return obstaculos;
    }
    public static boolean esObstaculo(Coordenada[] obstaculos ,Coordenada coordenada) {
        boolean esObstaculo = false;
        for (int i = 0; i < obstaculos.length && !esObstaculo; i++) {
            if (obstaculos[i] != null && coordenada.equals(obstaculos[i])){
                esObstaculo = true;
            }
        }
        return (esObstaculo);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zona zona = (Zona) o;
        return ancho == zona.ancho && alto == zona.alto && Arrays.equals(obstaculos, zona.obstaculos);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(ancho, alto);
        result = 31 * result + Arrays.hashCode(obstaculos);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Zona[ancho=%s, alto=%s, obstaculos=%s]", this.ancho, this.alto, Arrays.toString(this.obstaculos));
    }
}
