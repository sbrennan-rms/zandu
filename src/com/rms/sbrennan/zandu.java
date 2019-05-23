package com.rms.sbrennan;

import java.util.Set;
import java.util.HashSet;

public class zandu {

    private Cx X;
    private Cx A;
    private Set<Cx> seen;

    public zandu() {
    }

    public void iter(long m) {
        X = Cx.mul(X, A, m);
    }

    public void getPeriodSize() {
        long maxp = -1L;
        long maxg = -1L;
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
                    iter(4099);
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
        X = new Cx(1, 1);
        A = new Cx(1014, 4);
        for (int k = 0; k < many; k++) {
            System.out.println("" + k + " : " + X.toInt());
            iter(4099);
        }
    }
    public void spewpoints(int many) {
        long maxp = -1L;
        long maxg = -1L;
        X = new Cx(1, 1);
        A = new Cx(1014, 4);
        for (int k = 0; k < many; k++) {
            System.out.print("" +  X.toInt());
            iter(4099L);
            System.out.println(" " +  X.toInt());
            iter(4099L);
        }
    }

    public void spewrandu(int many) {
        long maxp = -1L;
        long maxg = -1L;
        X = new Cx(1, 0);
        A = new Cx(65539, 0);
        for (int k = 0; k < many; k++) {
            System.out.print("" +  X.re);
            iter(2147483648L);
            System.out.println(" " +  X.re);
            iter(2147483648L);
        }
    }
}
