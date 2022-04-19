package TESTS_AND_CODE;

import java.util.ArrayList;
import java.util.List;

public class MultiThreadedBigPrime {
    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        Results results = new Results();
        Runnable status = new CurrentStatus(results);
        Thread statusTask = new Thread(status);
        statusTask.start();


        Runnable task = new PrimeGenerator(results);

        List<Thread> threads = new ArrayList<>();
        for(int i=0 ; i <100 ; i++)
        {
            Thread t = new Thread(task);
            threads.add(t);
            t.start();
        }

        for(Thread t : threads)
        {
            t.join();
        }

        results.print();

        long end = System.currentTimeMillis();


        System.out.println("Took a : " +(end-start));
    }
}
