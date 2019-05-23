package com.rms.sbrennan;

public class Main {

    public static void main(String[] args) {
        zandu z = new zandu();
        z.init();
        //z.getPeriodSize();
        Imager imager = new Imager();
        imager.makeImage(z);
        /*
        Cx seed = new Cx(134, 124);
        z.setSeed(seed);
        BucketTest bucketTest = new BucketTest(z);
        for (int i = 8000; i < 8400; ) {
            if (i < 2) {
                i = 2;
            } else  if (i < 10) {
                i += 3;
            } else if (i < 100) {
                i += 31;
            } else  {
                i += 300;
            }
            bucketTest.RunBucketTest(i);
        }
        */
        //z.spewrandu(1000);
	// write your code here
    }
}
