package Qapitol.com;

import java.util.Scanner;

public class AreaOfRectangle {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the length of the rectangle: 5");
            double length = scanner.nextDouble();

            System.out.print("Enter the width of the rectangle: 10");
            double width = scanner.nextDouble();
            double area = length * width;

            System.out.println("The area of the rectangle is: " + area);
            scanner.close();
        }
    }


