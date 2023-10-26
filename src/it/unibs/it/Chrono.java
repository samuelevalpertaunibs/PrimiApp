package it.unibs.it;

public class Chrono {
    public static final long TO_SECOND = 1000000000;
    public static final long TO_MILLI  = 1000000;

    private Long start;
    private Long stop;

    public Chrono() {
        start();
    }

    public void start() {
        start = System.nanoTime();
        stop = null;
    }

    public long elapsed() {
        return (stop == null) ? System.nanoTime() - start : stop - start;
    }

    public long stop() {
        return (stop = System.nanoTime()) - start;
    }

    public String elapsedTime() {
        return format(elapsed()/TO_MILLI);
    }

    public static String format(long dtms) {
        long ms =  dtms % 1000; 	dtms /= 1000;
        long s = dtms % 60; 		dtms /= 60;

        return (dtms > 0) ? String.format("%02d:%02d.%03d", dtms, s, ms) :
                String.format("%02d.%03d", s, ms);
    }

    public String toString() {
        return elapsedTime();
    }
}