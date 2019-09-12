package com.vladromanchenko.consoleapp;
import com.vladromanchenko.areacalculator.AreaCalculator;
import com.vladromanchenko.areacalculator.Shapes;
import static com.vladromanchenko.areacalculator.ArgumentsChecker.checkShape;
import static com.vladromanchenko.areacalculator.ArgumentsChecker.checkDimensions;


import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleApp {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Input type of shape available types are circle and triangle: ");
        Shapes shape = checkShape(in.nextLine());

        System.out.print("Input comma separated list of dimensions for triangle or radius for circle: ");
        int[] intDimensions = checkDimensions(shape, in.nextLine().split(","));
        in.close();

        AreaCalculator ac = new AreaCalculator(shape, intDimensions);
        System.out.println(ac.calculate());
    }
}
