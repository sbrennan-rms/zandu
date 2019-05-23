package com.rms.sbrennan;

public class BucketTest {

    private zandu z;
    public BucketTest(zandu inz) {
        z = inz;
    }

    public double stddev(int[] buff, long samps) {
        long expected_size =  samps / buff.length;
        long accum = 0;
        System.out.println("Expected size:" + expected_size + " samps:" + samps + " bufflen:" + buff.length);
        for (int i = 0; i < buff.length; i++) {
            long diff = buff[i] - expected_size;
            accum += diff * diff;
        }
        accum /= buff.length;
        return Math.sqrt((double) accum);
    }

    public void RunBucketTest(int numBuckets) {
        z.init();
        int bs = numBuckets;
        int[] buckets = new int[bs];

        for (int i = 0; i < bs; i++) {
            buckets[i] = 0;
        }
        long sampsize = bs * 90;
        long tmpsamp = sampsize;
        while (tmpsamp > 0) {
            z.iter();
            int f = z.toInt();
            int idx = f % bs;
            buckets[idx]++;
            tmpsamp--;
        }
        double std = stddev(buckets, sampsize);
        double expected_sized =  (double) sampsize / bs;
        double quality = std / expected_sized;
        System.out.println("Buckets [" + numBuckets + " ] Stddev:" + std);
        System.out.println("  Quality (std / expected_size) " +  quality);
        for (int i = 0; i < bs; i++) {
            System.out.println("Bucket " + i + " :" + buckets[i]);
            if (i > 5) break;
        }
    }
}
