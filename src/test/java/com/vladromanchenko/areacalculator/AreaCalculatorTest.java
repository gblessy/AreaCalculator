package com.vladromanchenko.areacalculator;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AreaCalculatorTest {

    @Test
    public void circleTest(){
        int[] circleRadius = {10};
        AreaCalculator areaCalculator = new AreaCalculator(Shapes.CIRCLE, circleRadius);
        assertEquals(areaCalculator.calculate(), 314.1592653589793, 0.00000001);
    }

    @Test
    public void triangleTest(){
        int[] dimentions = {3,4,5};
        AreaCalculator areaCalculator = new AreaCalculator(Shapes.TRIANGLE, dimentions);
        assertEquals(areaCalculator.calculate(), 6.0, 0.00000001);
    }

    @Test
    public void invalidDimentionsLengthTest(){
        int[] dimentions = {10};

        Throwable exception = assertThrows(IllegalArgumentException.class, ()-> {
            new AreaCalculator(Shapes.TRIANGLE, dimentions);
        });
        assertTrue(exception.getMessage().contains("Shape value or dimensions number is incorrect"));
    }

    @Test
    public void invalidDimentionTest(){
        int[] dimentions = {-2, 4, 5};
        Throwable exception = assertThrows(IllegalArgumentException.class, ()-> {
            new AreaCalculator(Shapes.TRIANGLE, dimentions);
        });
        assertTrue(exception.getMessage().contains("Shape value or dimensions number is incorrect"));
    }

}
