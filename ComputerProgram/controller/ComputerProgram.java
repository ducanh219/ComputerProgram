package controller;

import java.util.Scanner;

public class ComputerProgram {
    private static final Scanner in = new Scanner(System.in);

    public static int Menu() {
        System.out.println("========= Calculator Program =========");
        System.out.println("1. Normal Calculator ");
        System.out.println("2. BMI Calculator ");
        System.out.println("3. Exit");
        System.out.print("Please choice one option");
        int choices = InputInt(1, 3);
        return choices;
    }

    public static int InputInt(int min, int max) {
        // checklimit
        while (true) {
            try {
                int input = Integer.parseInt(in.nextLine().trim());
                if (input < min || input > max) {
                    throw new NumberFormatException();
                }
                return input;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    public static double InputDouble() {
        // checkdouble
        while (true) {
            try {
                double input = Double.parseDouble(in.nextLine());
                return input;
            } catch (NumberFormatException e) {
                System.err.println("Please input double");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String InputOperator() {
        // checkchar
        while (true) {
            String input = in.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Not empty");
            } else if (input.equalsIgnoreCase("+") || input.equalsIgnoreCase("-")
                    || input.equalsIgnoreCase("*") || input.equalsIgnoreCase("/")
                    || input.equalsIgnoreCase("^") || input.equalsIgnoreCase("=")) {
                return input;
            } else {
                System.err.println("Please input (+, -, *, /, ^)");
            }
            System.out.print("Enter again: ");
        }
    }

    public static double InputNumber() {
        System.out.print("Enter number: ");
        double number = InputDouble();
        return number;
    }

    public static void normalCalculator() {
        double memory;
        System.out.print("Enter number: ");
        memory = InputDouble();
        while (true) {
            System.out.print("Enter operator: ");
            String operator = InputOperator();
            if (operator.equalsIgnoreCase("+")) {
                memory += InputNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("-")) {
                memory -= InputNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("*")) {
                memory *= InputNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("/")) {
                double num;
                do {
                    num = InputNumber();
                } while (num == 0);
                memory /= num;
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("^")) {
                memory = Math.pow(memory, InputNumber());
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("=")) {
                System.out.println("Result: " + memory);
                return;
            }
        }

    }

    // display result BMI status
    public static String BMIStatus(double bmi) {
        if (bmi < 19) {
            return "Under-standard.";
        } else if (bmi >= 19 && bmi < 25) {
            return "Standard.";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight.";
        } else if (bmi >= 30 && bmi < 40) {
            return "Fat-should lose weight";
        } else {
            return "Very fat - should lose weight immediately";
        }
    }

    // allow user BMI calculator
    public static void BMICalculator() {
        System.out.print("Enter Weight(kg): ");
        double weight = InputDouble();
        System.out.print("Enter Height(cm): ");
        double height = InputDouble();
        double bmi = weight * 10000 / (height * height);
        System.out.printf("BMI number: %.2f\n", bmi);
        System.out.println("BMI Status: " + BMIStatus(bmi));
    }
}
