package com.amazon.ata.immutabilityandfinal.classroom.primephoto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A class representing a PrimePhoto - contains dimensions, and a list of Pixels that make up the image.
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


public  final class PrimePhoto {
    private final List<Pixel> pixels;
    private final int height;
    private final int width;
    // used when saving to a buffered image
    private final int type;
// The following constructor creates a defensive copy of the pixelList because it
// contains mutable objects reference parameters.
    //Which are the reference parameters?
    // pixelList, height, width, type
    //List is a class an object a reference type.
    public PrimePhoto(List<Pixel> pixelList, int height, int width, int type) {
        if (pixelList.size() != (height * width)) {
            throw new IllegalArgumentException("Not enough pixels for the dimensions of the image.");
        }
        // Create a copy of the pixelList
        //this.pixels = pixelList; replaced w defensive copy
        this.pixels = new ArrayList<>(pixelList);// copy the parameter to a new ArrayList variable
        this.height = height;
        this.width = width;
        this.type = type;
    }
    // This return a reference to the internal state of the object List which is an object reference type
    public List<Pixel> getPixels() {
       // return pixels;
        return new ArrayList<>(pixels);// returning a new instance of the List with the same content

    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getType() {
        return type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pixels, height, width, type);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        PrimePhoto photo = (PrimePhoto) obj;

        return photo.height == this.height && photo.width == this.width &&
            photo.type == photo.type && Objects.equals(photo.pixels, this.pixels);
    }

}
