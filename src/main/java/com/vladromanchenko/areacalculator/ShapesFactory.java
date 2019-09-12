package com.vladromanchenko.areacalculator;

public class ShapesFactory {

    static Shape getShape(Shapes shape, int[] dimensions) {
        switch(shape){
            case CIRCLE:
                return new Circle(dimensions);
            case TRIANGLE:
                return new Triangle(dimensions);
            default:
                throw new IllegalArgumentException("Shape value or dimensions number is incorrect");
        }
    }
}