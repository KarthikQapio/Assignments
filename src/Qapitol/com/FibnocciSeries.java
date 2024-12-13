package Qapitol.com;

public class FibnocciSeries {
    public static void main(String[] args) {
        int n = 10, Karthik = 0, Rakshith = 1;
        System.out.print("Fibonacci Series: " + Karthik + ", " + Rakshith);
        for (int i = 1; i < n; i++) {
            int Manoj = Karthik + Rakshith;
            System.out.print(", " + Manoj);
            Karthik = Rakshith;
            Rakshith =  Manoj;
        }

    }
}
