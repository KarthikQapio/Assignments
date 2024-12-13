package Qapitol.com;

public class SkipEvenNumbersAndStartTheLoop {
    public static void main(String[] args) {
        for (int i = 1; i < 30; i++) {
            if (i % 2 == 0) {
                continue;
            }
            if (i > 20) {
                break;
            }
            System.out.println(i);
        }
    }
}

