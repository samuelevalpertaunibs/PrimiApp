package it.unibs.it;

public class PrimiApp {

    public static void main (String[] args) throws Exception {
        System.out.printf("Primi trovati: %d\n", PrimeTester.contaPrimi(0, 100));
        long n = 132;
        Factors factors = PrimeTester.factor(n);
        System.out.printf("Fattori di %d: %d, %d\n", n, factors.getA(), factors.getB());
    }
}
