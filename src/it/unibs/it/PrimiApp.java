package it.unibs.it;

public class PrimiApp {

    public static void main (String[] args) throws Exception {

        PrimeTester task = new PrimeTester(0, 100_000_000);

        Chrono chrono = new Chrono();

        long nprimes = task.call();

        chrono.stop();

        System.out.printf("Primi trovati: %d [%s]\n", nprimes, chrono);

//        long n = 132;
//        Factors factors = PrimeTester.factor(n);
//        System.out.printf("Fattori di %d: %d, %d\n", n, factors.getA(), factors.getB());


    }
}
