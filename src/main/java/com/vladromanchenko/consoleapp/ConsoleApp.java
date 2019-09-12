package com.vladromanchenko.consoleapp;
import com.vladromanchenko.areacalculator.AreaCalculator;
import com.vladromanchenko.areacalculator.Shapes;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleApp {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Input type of shape available types are circle and triagle: ");
        String shape = in.nextLine();
        Shapes shapeForCalculation = null;
        if (shape.equalsIgnoreCase(Shapes.CIRCLE.toString())){
            shapeForCalculation = Shapes.CIRCLE;
        }
        System.out.print("Input comma separated list of dimentions for cirkle radius for triangle list of dimentions: ");
        String dinemsions = in.nextLine();
        in.close();
        String[] stringDimentions = dinemsions.split(",");
        ArrayList<Integer> intDimensions = new ArrayList<Integer>();

        for (String s : stringDimentions){
            intDimensions.add(Integer.parseInt(s));
        }

        AreaCalculator ac = new AreaCalculator(shapeForCalculation, intDimensions.stream().mapToInt(i -> i).toArray());
        System.out.println(ac.calculate());
    }
}
