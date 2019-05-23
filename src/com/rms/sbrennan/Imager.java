package com.rms.sbrennan;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Imager {
    static double MP23 = Math.PI * 2.0 / 3.0;
    static double MP43 = Math.PI * 4.0 / 3.0;


    private Color rainbow(double d) {
        double red = Math.sin(d);
        double green = Math.sin(d + MP23);
        double blue = Math.sin(d + MP43);
        red *= red;
        green *= green;
        blue *= blue;
        int ir = (int) (255.0 * red);
        int ig = (int) (255.0 * green);
        int ib = (int) (255.0 * blue);
        return new Color(ir, ig, ib);
    }

    public void makeImage(zandu z) {
        int width = 256;
        int height = 256;

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();

        // fill all the image with white
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, width, height);

        double timer = 0.0;
        //for (int y = 0; y < height; y++) {
          //  for (int x = 0; x < width; x++) {
                for (int q = 0; q < 123456; q++) {

                /*int r = timer % 255;
                int g = (timer + 87) % 255;
                int b = (timer + 174) % 255; */
                timer += 0.00006;
                Color c = rainbow(timer);
                g2d.setColor(c);
                z.iter();
                double xp =  (float) (z.toInt() & 0xFF) / 256.0;
                z.iter();
                double yp = (float) (z.toInt() & 0xFF) / 256.0;
                if (xp > 1.0 || yp > 1.0) {
                    continue;
                }
               // System.out.println("X?:" + (int)((double)width * xp) + " Y: " +  (int)((double) height * yp));
                bufferedImage.setRGB((int)((double)width * xp), (int)((double) height * yp), c.getRGB());
           // }
        }

        // Disposes of this graphics context and releases any system resources that it is using.
        g2d.dispose();

        // Save as PNG
        File file = new File("myimage.png");
        try {
            ImageIO.write(bufferedImage, "png", file);
        } catch (IOException ex) {
            System.err.println("Cannot write file: " + ex.getMessage());
        }
    }
}
