package com.rms.sbrennan;

import java.util.Set;
import java.util.HashSet;

public class zandu {

    private Cx X;
    private Cx A;
    private long M;
    private Set<Cx> seen;
    private Cx seed;

    public zandu() {
        seed = new Cx(1, 1);
    }

    public void iter() {
        X = Cx.mul(X, A, M);
    }

    public void setSeed(Cx xin) {
        seed = xin;
    }

    public void init() {
        M = 4099;
        X = new Cx(seed.re, seed.im);
        A = new Cx(1014, 4);
       //  A = new Cx(3, 1);

        boolean randu = false;
        boolean ccc = false;
        //randu = true;
      //  ccc = true;
        if (randu) {
            M = 2147483648L;
            X = new Cx(1, 0);
            A = new Cx(65539, 0);
        }
        if (ccc) {
            M = 2147483647L;
            X = new Cx(1, 0);
            A = new Cx(48271, 0);
        }

    }

    public void getPeriodSize() {
        long maxp = -1L;
        long maxg = -1L;
        this.M = 4099;
        Cx oneone = new Cx(1, 1);
        for (int k = 1000; k < 10000; k++) {
            for (int j = 1; j < 5; j++) {
                X = new Cx(1, 1);
                A = new Cx(k, j);
                seen = new HashSet<>();
                long count = 0;
                while (!seen.contains(X) && count < 3000000000L) {
                    if (count % 10000000L == 1) {
                        System.out.println(":" + count + ">" + X);
                    }
                    seen.add(X);
                    iter();
                    count++;
                }
                if (count >= maxp) {
                    System.out.println("?? K:" + k + " J:" + j + " Period Length: " + count + " :" + X);
                    maxp = count;
                }
                if (count >= maxg && X.equals(oneone)) {
                    System.out.println("11 K:" + k + " J:" + j + " Period Length: " + count + " :" + X);
                    maxg = count;
                }
            }
            if (k % 100L == 1) {
                 System.out.println(":" + k + ">");
            }
        }
    }

    public void spew(int many) {
        long maxp = -1L;
        long maxg = -1L;
        this.M = 4099;
        X = new Cx(1, 1);
        A = new Cx(1014, 4);
        for (int k = 0; k < many; k++) {
            System.out.println("" + k + " : " + X.toInt());
            iter();
        }
    }

    public int toInt() {
        return X.toInt();
    }

    public void spewpoints(int many) {
        this.M = 4099;
        long maxp = -1L;
        long maxg = -1L;
        X = new Cx(1, 1);
        A = new Cx(1014, 4);
        for (int k = 0; k < many; k++) {
            System.out.print("" +  X.toInt());
            iter();
            System.out.println(" " +  X.toInt());
            iter();
        }
    }

    public void spewrandu(int many) {
        long maxp = -1L;
        long maxg = -1L;
        this.M = 2147483648L;
        X = new Cx(1, 0);
        A = new Cx(65539, 0);
        for (int k = 0; k < many; k++) {
            System.out.print("" +  X.re);
            iter();
            System.out.println(" " +  X.re);
            iter();
        }
    }
}
