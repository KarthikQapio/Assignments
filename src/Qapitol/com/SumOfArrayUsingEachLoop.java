package Qapitol.com;

public class SumOfArrayUsingEachLoop {
    public static void main(String[] args) {
        int[] numbers = {78, 230, 370, 490, 569};
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println("Sum of array elements: " + sum);
    }
}


