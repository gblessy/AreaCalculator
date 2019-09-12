package com.vladromanchenko.areacalculator;
import java.util.HashMap;

public class App {
    private final Shapes shape;
    private final int[] dimensions;
    HashMap<Shapes, Integer> numberOfDimensions = new HashMap<Shapes, Integer>();

    public App(Shapes shape, int[] dimentions) {
        numberOfDimensions.put(Shapes.CIRCLE, 1);
        numberOfDimensions.put(Shapes.TRIANGLE, 3);

        if (checkArguments(shape, dimentions)) {
            this.shape = shape;
            this.dimensions = dimentions;
        } else {
            throw new IllegalArgumentException("Shape value or dimensions number is incorrect");
        }
    }

    private boolean checkArguments(Shapes shape, int[] dimensions ){

        if (numberOfDimensions.get(shape) != dimensions.length) return false;
        for (int i : dimensions) {
            if (i < 1) return false;
        }
        return true;
    }

    public double calculate(){
        Shape calculation = ShapesFactory.getShape(this.shape, this.dimensions);
        return calculation.area();
    }
}
