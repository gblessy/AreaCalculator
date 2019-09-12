package com.vladromanchenko.areacalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static com.vladromanchenko.areacalculator.ArgumentsChecker.checkShape;
import static com.vladromanchenko.areacalculator.ArgumentsChecker.checkDimensions;
import static com.vladromanchenko.areacalculator.ArgumentsChecker.checkArguments;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Area Calculator")
public class AreaCalculatorTest {

    @Test
    @DisplayName("Calculates correct area for Circle")
    public void circleTest(){
        int[] circleRadius = {10};
        AreaCalculator areaCalculator = new AreaCalculator(Shapes.CIRCLE, circleRadius);
        assertEquals(areaCalculator.calculate(), 314.1592653589793, 0.00000001);
    }

    @Test
    @DisplayName("Calculates correct area for Triangle")
    public void triangleTest(){
        int[] dimentions = {3,4,5};
        AreaCalculator areaCalculator = new AreaCalculator(Shapes.TRIANGLE, dimentions);
        assertEquals(areaCalculator.calculate(), 6.0, 0.00000001);
    }

    @Test
    @DisplayName("Throws correct exception for incorrect number of dimensions")
    public void invalidDimentionsLengthTest(){
        int[] dimentions = {10};

        Throwable exception = assertThrows(IllegalArgumentException.class, ()-> {
            new AreaCalculator(Shapes.TRIANGLE, dimentions);
        });
        assertTrue(exception.getMessage().contains("Shape value or dimensions number is incorrect"));
    }

    @Test
    @DisplayName("Throws correct exception for incorrect dimensions values")
    public void invalidDimentionTest(){
        int[] dimentions = {-2, 4, 5};
        Throwable exception = assertThrows(IllegalArgumentException.class, ()-> {
            new AreaCalculator(Shapes.TRIANGLE, dimentions);
        });
        assertTrue(exception.getMessage().contains("Shape value or dimensions number is incorrect"));
    }

    @Test
    @DisplayName("checkShape returns correct shape for Circle")
    public void checkShapeTest(){
        assertTrue(checkShape("Circle").equals(Shapes.CIRCLE));
    }

    @Test
    @DisplayName("checkShape returns correct shape for ciRcle")
    public void checkCircleShapeTest(){
        assertTrue(checkShape("ciRcle").equals(Shapes.CIRCLE));
    }

    @Test
    @DisplayName("checkShape returns correct shape for triANGLE")
    public void checkTriangleShapeTest(){
        assertTrue(checkShape("triANGLE").equals(Shapes.TRIANGLE));
    }

    @Test
    @DisplayName("checkShape throws correct excepton for incorrect shape")
    public void checkExceptionShapeTest(){
        Throwable exception = assertThrows(IllegalArgumentException.class, ()-> {
            checkShape("triangl");
        });
        assertTrue(exception.getMessage().contains("Shape value or dimensions number is incorrect"));
    }

    @Test
    @DisplayName("checkDimensions returns correct dimension for circle")
    public void checkCircleDimensionsTest(){
        String[] dimensions = {"10"};
        int[] expectedArray = {10};
        assertArrayEquals(checkDimensions(Shapes.CIRCLE, dimensions), expectedArray);
    }

    @Test
    @DisplayName("checkDimensions returns correct dimension for triangle")
    public void checkTriangleDimensionsTest(){
        String[] dimensions = {"3", "4", "5"};
        int[] expectedArray = {3, 4, 5};
        assertArrayEquals(checkDimensions(Shapes.TRIANGLE, dimensions), expectedArray);
    }


    @Test
    @DisplayName("checkDimensions throws correct excepton for incorrect dimensions for tringle")
    public void checkExceptionDimensionsTest(){
        String[] dimensions = {"3", "4"};
        Throwable exception = assertThrows(IllegalArgumentException.class, ()-> {
            checkDimensions(Shapes.TRIANGLE, dimensions);
        });
        assertTrue(exception.getMessage().contains("Shape value or dimensions number is incorrect"));
    }

    @Test
    @DisplayName("checkDimensions throws correct excepton for negative dimensions for tringle")
    public void checkNegativeNumberExceptionDimensionsTest(){
        String[] dimensions = {"3", "-4", "5"};
        Throwable exception = assertThrows(IllegalArgumentException.class, ()-> {
            checkDimensions(Shapes.TRIANGLE, dimensions);
        });
        assertTrue(exception.getMessage().contains("Shape value or dimensions number is incorrect"));
    }

    @Test
    @DisplayName("checkArguments returns correct value for correct input")
    public void checkArgumentsTriangleTest(){
        int[] dimensions = {3, 4, 5};
        assertTrue(checkArguments(Shapes.TRIANGLE, dimensions));
    }

    @Test
    @DisplayName("checkArguments returns false for incorrect input")
    public void checkArgumentsExceptionTest(){
        int[] dimensions = {3, 4, -5};
        assertFalse(checkArguments(Shapes.TRIANGLE, dimensions));
    }


    /*
     * We could add test to check border values for integers and some weird strings
     * but this amount of tests is fully sufficient and already gives us 100% coverage
     * with some methods tested separately and as part of e2e test for library
     */
}
