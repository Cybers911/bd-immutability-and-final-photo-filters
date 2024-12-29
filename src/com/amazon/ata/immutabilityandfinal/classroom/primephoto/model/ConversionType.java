package com.amazon.ata.immutabilityandfinal.classroom.primephoto.model;

/**
 * Image conversion types.
 */
public enum ConversionType {

    SEPIA("sepia"),
    GREYSCALE("greyscale"),
    INVERSION("inversion");

    private final String name;

    private ConversionType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
//esta clase define los tipos de conversiones posibles para las fotos primas
//Esta clase es final, lo que significa que no puede ser extendida en nuevas clases
