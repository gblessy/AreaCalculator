package com.vladromanchenko.areacalculator;

import java.util.ArrayList;
import java.util.HashMap;

public class ArgumentsChecker {
    static HashMap<Shapes, Integer> numberOfDimensions = new HashMap<Shapes, Integer>();

    private static void addDimentions() {
        numberOfDimensions.put(Shapes.CIRCLE, 1);
        numberOfDimensions.put(Shapes.TRIANGLE, 3);
    }
    static boolean checkArguments(Shapes shape, int[] dimensions ){
        addDimentions();
        if (numberOfDimensions.get(shape) != dimensions.length) return false;
        for (int i : dimensions) {
            if (i < 1) return false;
        }
        return true;
    }

    public static Shapes checkShape(String shape ){
        addDimentions();
        if (shape.equalsIgnoreCase(Shapes.CIRCLE.toString())){
            return Shapes.CIRCLE;
        } else if (shape.equalsIgnoreCase(Shapes.TRIANGLE.toString())){
            return Shapes.TRIANGLE;
        }
        throw new IllegalArgumentException("Shape value or dimensions number is incorrect");
    }

    public static int[] checkDimensions(Shapes shape, String[] dimensionsString ){

        ArrayList<Integer> intArrayDimensions = new ArrayList<Integer>();

        for (String s : dimensionsString){
            intArrayDimensions.add(Integer.parseInt(s));
        }

        if (numberOfDimensions.get(shape) != intArrayDimensions.size()) throw new IllegalArgumentException("Shape value or dimensions number is incorrect");

        for (int i : intArrayDimensions) {
            if (i < 1) throw new IllegalArgumentException("Shape value or dimensions number is incorrect");
        }
        return intArrayDimensions.stream().mapToInt(i -> i).toArray();
    }

}
