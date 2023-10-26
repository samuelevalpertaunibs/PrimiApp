package it.unibs.it;

import java.util.*;
import java.util.concurrent.*;

public class PrimiApp {

    public static void main (String[] args) throws Exception {

        final int threadCount = 10;
        final int range = 100_000_000;
        final int step = range / threadCount;

        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        List<Callable<Long>> tasks = new ArrayList<>();

        for(int i = 0; i < threadCount; i++){
            final long start = i * step;
            final long end = (i + 1) * step;
            tasks.add(new PrimeTester(start, end));
        }

        Chrono chrono = new Chrono();

        List<Future<Long>> futures = executor.invokeAll(tasks);
        long totalPrimes = 0;

        for(Future<Long> future : futures){
            totalPrimes += future.get();
        }

        executor.shutdown();
        chrono.stop();

        System.out.printf("Primi trovati: %d [%s]\n", totalPrimes, chrono);
    }
}