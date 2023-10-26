package it.unibs.it;

import java.util.*;
import java.util.concurrent.*;

import static it.unibs.it.PrimeTester.contaPrimi;
import static java.lang.Thread.sleep;

public class PrimiApp {

    public static void main (String[] args) throws Exception {

        final int threadCount = 10;
        final int range = 1_000_000_000;
        final int step = range / threadCount;

        long totalPrimes = 0;

        Chrono chrono = new Chrono();
        totalPrimes = contaPrimi(1, range);
        chrono.stop();

        System.out.printf("[Singlethread] Primi trovati: %d [%s]\n", totalPrimes, chrono);

        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        List<Callable<Long>> tasks = new ArrayList<>();
        totalPrimes = 0;

        for(int i = 0; i < threadCount; i++){
            final long start = i * step;
            final long end = Math.min((i + 1) * step, range); //Senza Math.min se la divisone non è intera l'ultimo thread potrebbe andare oltre il range
            tasks.add(new PrimeTester(start, end));
        }

        chrono.start();
        List<Future<Long>> futures = executor.invokeAll(tasks);

        for(Future<Long> future : futures){
            totalPrimes += future.get();
        }

        executor.shutdown();
        chrono.stop();

        System.out.printf("[Multithread] Primi trovati: %d [%s]\n", totalPrimes, chrono);

    }
}