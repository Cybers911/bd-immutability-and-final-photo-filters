package com.amazon.ata.immutabilityandfinal.classroom.primephoto.model;

import java.util.Objects;

/**
 * An object that represent colors. Each object represents the color as three integers that stand for primary color
 * values.
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
public final class RGB {//1 Make class final

    private final int red;  //1 Make class final
    private final int green;
    private final int blue;
    private final int transparency;
    // because we change those values to final we cant change no more assignments
    //(because final is used for immutability)
    //so we have to change the constructor to accept copies of the parameters
    //changeng the methods to return copies of the data assigned a new object every time
    //so we return a new object every time we call this method

    private void check(int red, int green, int blue, int transparency) {
        if (red < 0 || red > 255 ||
            green < 0 || green > 255 ||
            blue < 0 || blue > 255) {
            throw new IllegalArgumentException(String.format("Invalid values color values. Red, green, " +
                "and blue must be between 0 and 255: {red: %d , green: %d, blue: %d}", red, green, blue));
        }
        if (transparency < 0 || transparency > 255) {
            throw new IllegalArgumentException("Invalid transparency value: " + transparency);
        }
    }
  //In this case this constructor is not receiving reference parameters
  // so no defensive copy is needed
    public RGB(int red, int green, int blue, int transparency) {
        check(red, green, blue, transparency);
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.transparency = transparency;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public int getTransparency() {
        return transparency;
    }

    /**
     * Averages the red, blue, and green components, producing a grey color.
     */
    //public void toGreyScale( ){replaced to return a new RGB object since we
    //       cant change the values because we convereted to finals so we cant change the
             // internal state.
            public RGB toGreyScale() {
        int avg = (red + green + blue) / 3;

        // replace by returning a new RGB object instead of changing the current one
    // with the values we wanted to change and the exixting transparicing value
    return new RGB(avg, avg, avg, this.transparency);
        //red = avg;
       // green = avg;
       // blue = avg;
    }
    //Que hemmos cambiado aqui
    //Hemos cambiado la forma en la que se calculan los valores de newRed, newGreen y newBlue
    //Esto es para que no se puedan cambiar los valores internos de la clase
    //Para que los cambios sean defensivos y no se puedan cambiar los valores internos de la clase
    //En lugar de modificar los valores en el propio objeto, se crea un nuevo objeto con los valores deseados
    //y el mismo transparancy value


    /**
     * Converts the color to a reddish-brown color.
     */
    //public void toSepia( ) {
            public RGB toSepia() {
        int newRed = (int)(0.393 * red + 0.769 * green + 0.189 * blue);
        int newGreen = (int)(0.349 * red + 0.686 * green + 0.168 * blue);
        int newBlue = (int)(0.272 * red + 0.534 * green + 0.131 * blue);
       // replaced to return a new RGB object since we
                //       cant change the values because we convereted to finals so we cant change the
                // internal state.

        //red = Math.min(255, newRed);
       // green = Math.min(255, newGreen);
        //  blue = Math.min(255, newBlue);
                return new RGB(Math.min(255, newRed), Math.min(255, newGreen), Math.min(255, newBlue), this.transparency);

    }
    // What we did here? is that we created a new RGB object with the calculated values
    //and the same transparancy value for the new RGB object.
    //This is a defensive copy of the current RGB object, it creates a new object with the same values
    //but with inverted color values.


    /**
     * "Dark mode" - Assigns red, green, and blue, their current value subtracted from their max value (255).
     * This will turn white to black.
     */
   // public void invert() {
    public RGB invert() {
       //// red = 255 - red;
       // green = 255 - green;
       // blue = 255 - blue;
        // replaced to return a new RGB object since we
        //       cant change the values because we convereted to finals so we cant change the
                // internal state.
        return new RGB(255 - red, 255 - green, 255 - blue, this.transparency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(red, green, blue, this.transparency);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        RGB rgb = (RGB) obj;

        return rgb.red == this.red && rgb.green == this.green &&
            rgb.blue == this.blue && rgb.transparency == this.transparency;
    }
}

