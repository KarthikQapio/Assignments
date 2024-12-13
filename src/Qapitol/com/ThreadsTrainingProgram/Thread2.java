package Qapitol.com.ThreadsTrainingProgram;

public class Thread2 implements Runnable {
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println("Running Thread1 " + i + " Thread Name -1 :: " + Thread.currentThread().getName());
        }
    }
}
