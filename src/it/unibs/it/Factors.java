package it.unibs.it;

public class Factors {
    private long a;
    private long b;

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
