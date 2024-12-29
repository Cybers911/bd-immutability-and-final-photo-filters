package com.amazon.ata.immutabilityandfinal.classroom.primephoto.model;

import java.util.Objects;

/**
 * Represents a single point in an image. Each pixel has a location in the image, and an associated RGB color.
 */

//Make this class immutable
//1 Make class final
//2 Make instance fields final
//Check constructors for reference parameters and replace assignments with
// copies of the parameters.(defensive copies)
//Make sure any reference returned are defensive copies (return copies of the data)
//Then Ensure there is not setters, THIS CLASS DOESNT HAVE SETTERS
//Modify exixting code so no instance variables are changed (fix compile errors
// due to making final keyword)
    //Make sure there are no side effects in constructors (no changes to the state of the object)
//Make sure the class does not have any methods that modify the state of the object (no setters)
public final class Pixel {
    private final int x;
    private final int y;
    private final RGB rgb;

    public Pixel(int x, int y, RGB rgb) { // receiving a reference to the RGB object,
        // so we create a defensive copy.
        this.x = x;
        this.y = y;
        //this.rgb = rgb;
        this.rgb = new RGB(rgb.getRed(), rgb.getGreen(), rgb.getBlue(), rgb.getTransparency());
        //using the parameter data and not the reference. to create a new RGB object.
        //defensive copy.
    }
    // This returns a reference to an Object so we have to create a defensive copy of the RGB object.
    // defensive copy.
    public RGB getRGB() {
        //return rgb;
        return new RGB(rgb.getRed(), rgb.getGreen(), rgb.getBlue(), rgb.getTransparency());
        //returning a defensive copy of the RGB object.
        //defensive copy.
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, rgb);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Pixel pixel = (Pixel) obj;

        return pixel.x == this.x && pixel.y == this.y &&
           Objects.equals(pixel.rgb, this.rgb);
    }
}
