package com.vladromanchenko.areacalculator;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AreaCalculatorTest {

    @Test
    public void circleTest(){
        int[] circleRadius = {10};
        App app = new App(Shapes.CIRCLE, circleRadius);
        assertEquals(app.calculate(), 314.1592653589793, 0.00000001);
    }

    @Test
    public void triangleTest(){
        int[] dimentions = {3,4,5};
        App app = new App(Shapes.TRIANGLE, dimentions);
        assertEquals(app.calculate(), 6.0, 0.00000001);
    }

    @Test
    public void invalidDimentionsLengthTest(){
        int[] dimentions = {10};

        Throwable exception = assertThrows(IllegalArgumentException.class, ()-> {
            new App(Shapes.TRIANGLE, dimentions);
        });
        assertTrue(exception.getMessage().contains("Shape value or dimensions number is incorrect"));
    }

    @Test
    public void invalidDimentionTest(){
        int[] dimentions = {-2, 4, 5};
        Throwable exception = assertThrows(IllegalArgumentException.class, ()-> {
            new App(Shapes.TRIANGLE, dimentions);
        });
        assertTrue(exception.getMessage().contains("Shape value or dimensions number is incorrect"));
    }

}
