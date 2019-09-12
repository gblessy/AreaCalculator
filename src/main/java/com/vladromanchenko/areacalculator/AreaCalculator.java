package com.vladromanchenko.areacalculator;
import com.vladromanchenko.areacalculator.ArgumentsChecker.*;
import java.util.ArrayList;
import java.util.HashMap;

import static com.vladromanchenko.areacalculator.ArgumentsChecker.checkArguments;

public class AreaCalculator {
    private final Shapes shape;
    private final int[] dimensions;


    public AreaCalculator(Shapes shape, int[] dimentions) {

        if (checkArguments(shape, dimentions)) {
            this.shape = shape;
            this.dimensions = dimentions;
        } else {
            throw new IllegalArgumentException("Shape value or dimensions number is incorrect");
        }
    }


    public double calculate(){
        Shape calculation = ShapesFactory.getShape(this.shape, this.dimensions);
        return calculation.area();
    }
}
