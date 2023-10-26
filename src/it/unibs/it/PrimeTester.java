package it.unibs.it;

public class PrimeTester {
    static boolean isPrime(long n){
        if (n <= 1){
            return false;
        }
        for(int i = 2; i * i <= n; i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
    public static long contaPrimi(long min, long max){
        long count = 0;
        for (long i = min; i <= max; i++) {
            if (isPrime(i)) count++;
        }
        return count;
    }

    public static Factors factor(long n){
        if (n <= 1){
            throw new IllegalArgumentException("Invalid n");
        }
        for (int i = 2; i * i <= n; i++) {
            Factors factors;
            if(n % i == 0)
                return factors = new Factors(i, n/i);
        }
        return null;
    }
}
