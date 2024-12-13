package Qapitol.com.ThreadsTrainingProgram;

public class ThreadDemoController {
    public static void main(String[] args) throws InterruptedException {

        System.out.println(" Main Methods "+Thread.currentThread().getName());


        Thread1 thread1 = new Thread1();

        Thread threadI1 = new Thread(thread1);
        Thread2  thread2 = new Thread2();
        threadI1.start();

        Thread.sleep(1000);
        Thread threadI2 = new Thread(thread2);

        threadI2.start();

        System.out.println(" Main Mehtod Done Successfully"); //

    }


}
