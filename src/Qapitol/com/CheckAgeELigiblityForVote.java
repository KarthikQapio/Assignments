package Qapitol.com;

import java.util.Scanner;

public class CheckAgeELigiblityForVote {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your age: ");
            int age = 27;

            if (age >= 18 && age <= 100) {
                System.out.println("Eligible for Vote");
            } else if (age < 18) {
                System.out.println("Not eligible for Vote");
            } else {
                System.out.println("Incorrect age");
            }

            scanner.close();
        }
    }




