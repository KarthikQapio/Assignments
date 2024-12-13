package Qapitol.com;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the range (n) to generate multiplication tables (1 to n): ");
        int n = 20;
        if (n < 1) {
            System.out.println("Please enter a number greater than or equal to 1.");
        } else {
            for (int i = 1; i <= n; i++) {
                System.out.println("\nMultiplication Table for " + i + ":");
                for (int j = 1; j <= 10; j++) {
                    System.out.println(i + " * " + j + " = " + (i * j));  // Use '*' instead of 'x'
                }
            }
        }

        sc.close();
    }
}
