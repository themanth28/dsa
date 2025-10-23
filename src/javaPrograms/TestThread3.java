package javaPrograms;

import java.util.concurrent.*;

public class TestThread3 {

   public static void main(final String[] arguments) throws InterruptedException {
      final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
//      ExecutorService executorService = Executors.newFixedThreadPool(1);

      final ScheduledFuture<?> beepHandler = 
         scheduler.scheduleAtFixedRate(new BeepTask(), 2, 2, TimeUnit.SECONDS);

      scheduler.schedule(new Runnable() {

         @Override
         public void run() {
            beepHandler.cancel(true);
            scheduler.shutdown();			
         }
      }, 10, TimeUnit.SECONDS);
   }

   static class BeepTask implements Runnable {
      
      public void run() {
         System.out.println("beep");      
      }
   }
}