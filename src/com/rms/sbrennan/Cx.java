package com.rms.sbrennan;

public class Cx {
    long re;
    long im;
    //private static long M = 2147483648L;
    //private static long M = 16777216L;
    //private static long M = 16384;
    //private static long M = 4099;
    //private static long M = 32719;


    public Cx(long re, long im) {
        this.re = re;
        this.im = im;
    }

    public static Cx mul(Cx a, Cx b, long M) {
        //System.out.println("mul: " + a + " x " + b);
        //System.out.println("ar: " + a.re + " ai: " + a.im);
        //System.out.println("br: " + b.re + " bi: " + b.im);
        long r = (a.re * b.re - a.im * b.im) % M;
        long i = (a.re * b.im + a.im * b.re) % M;
        //System.out.println("res: " + r + " , " + i);
        return new Cx(r, i);
    }

    int toInt() {
        long ax = (re < 0)? -re : re;
        long ai= (im < 0)? -im : im;
        int aa = (int) ax & 0xff;
        int ab = (int) (ai & 0xff) << 16;
        return ab | aa;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cx)) return false;
        Cx c = (Cx) o;
        return (c.re == re && c.im == im);
    }

    @Override
    public int hashCode() {
        return (int) (43 * re + im);
    }

    @Override
    public String toString() {
        return "" + re + ", " + im + " i";
    }
} // class Cx