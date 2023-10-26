package it.unibs.it;

public class Factors {
    private final long a;
    private final long b;

    public Factors(long a, long b) {
        this.a = a;
        this.b = b;
    }

    public long getA() {
        return a;
    }

    public long getB() {
        return b;
    }

    public long eval() {
        return a * b;
    }
}
