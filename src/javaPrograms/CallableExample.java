package javaPrograms;

import java.util.concurrent.*;

class CallableExample {
    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> result = service.submit(() -> 10 + 20);
        System.out.println(result.get()); // prints 30
        service.shutdown();
    }
}
