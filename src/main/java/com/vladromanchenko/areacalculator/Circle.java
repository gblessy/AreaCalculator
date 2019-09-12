package com.vladromanchenko.areacalculator;

public class Circle extends Shape {

    public Circle(int[] dimensions){
        this.dimensions = dimensions;
    }


    public double area() {
        double doubleRadius = this.dimensions[0];
        return Math.PI * doubleRadius * doubleRadius;
    }
}