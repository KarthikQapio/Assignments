package Qapitol.com;

import java.util.Scanner;


public class Calculator {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            while (true) {

                System.out.print("Select an option (1-5): ");
                int choice = scanner.nextInt();

                if (choice == 1) {
                    // Addition
                    System.out.print("Enter the first number: ");
                    double num1 = scanner.nextDouble();
                    System.out.print("Enter the second number: ");
                    double num2 = scanner.nextDouble();
                    System.out.println("Result: " + (num1 + num2));
                } else if (choice == 2) {
                    // Subtraction
                    System.out.print("Enter the first number: ");
                    double num1 = scanner.nextDouble();
                    System.out.print("Enter the second number: ");
                    double num2 = scanner.nextDouble();
                    System.out.println("Result: " + (num1 - num2));
                } else if (choice == 3) {
                    // Multiplication
                    System.out.print("Enter the first number: ");
                    double num1 = scanner.nextDouble();
                    System.out.print("Enter the second number: ");
                    double num2 = scanner.nextDouble();
                    System.out.println("Result: " + (num1 * num2));
                } else if (choice == 4) {
                    // Division
                    System.out.print("Enter the first number: ");
                    double num1 = scanner.nextDouble();
                    System.out.print("Enter the second number: ");
                    double num2 = scanner.nextDouble();
                    if (num2 != 0) {
                        System.out.println("Result: " + (num1 / num2));
                    } else {
                        System.out.println("Error: Division by zero is not allowed.");
                    }
                } else if (choice == 5) {
                    System.out.println("Exiting the program.");
                    break;
                } else {
                    System.out.println("Invalid option. Please select a valid option from the menu.");
                }
            }

            scanner.close();
        }
    }


