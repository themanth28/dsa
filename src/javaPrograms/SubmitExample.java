package javaPrograms;

import java.util.concurrent.*;

public class SubmitExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<Integer> task = () -> {
            System.out.println("Calculating...");
            Thread.sleep(1000);
            return 10 + 20;
        };

        Future<Integer> future = executor.submit(task);
        System.out.println("Result: " + future.get()); // waits for result
        executor.shutdown();
    }
}
