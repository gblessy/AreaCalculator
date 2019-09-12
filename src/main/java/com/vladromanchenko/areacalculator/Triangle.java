package com.vladromanchenko.areacalculator;

public class Triangle extends Shape {

    Triangle(int[] dimensions){
        this.dimensions = dimensions;
    }


    public double area() {

        double a = this.dimensions[0];
        double b = this.dimensions[1];
        double c = this.dimensions[2];

        double p = (a + b + c)/2;

        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
}
