package Qapitol.com;

import java.util.Random;

public class FlipACoinMultipleTimes {

    public static void main(String[] args) {

        int numFlips = 25;
        Random random = new Random();
        for (int i = 0; i < numFlips; i++) {
            int flipResult = random.nextInt(3);
            if (flipResult == 0) {
                System.out.println("Flip " + (i + 1) + ": Heads");
            }
             else {
                 System.out.println("Flip " + (i + 1) +": Tails");

            }
        }
    }
}




