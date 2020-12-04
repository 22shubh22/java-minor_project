package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import com.codahale.shamir.Scheme;

import org.w3c.dom.xpath.XPathNSResolver;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Map;

public class SetPixels {
   
   public void main()throws IOException {
      System.out.println("Started");
      //Reading the image
      File file= new File("C:\\Users\\USER\\Desktop\\java_project\\test1.png");
      BufferedImage img = ImageIO.read(file); 
      int width = img.getWidth();
      int height = img.getHeight(); 
      BufferedImage imgs[];
      imgs = new BufferedImage[6];

      final Scheme scheme = new Scheme(new SecureRandom(), 6, 3);

      for (int y = 0; y < 1/*img.getHeight()*/; y++) {
         for (int x = 0; x < 1/*img.getWidth()*/; x++) {
            System.out.println("Inside outer loop");
            //Retrieving contents of a pixel
            int pixel = img.getRGB(x,y);
            //Creating a Color object from pixel value
            Color color = new Color(pixel, true);
            //Retrieving the R G B values
            int red = color.getRed();
            int green = color.getGreen();
            int blue = color.getBlue();
            System.out.println("Original Red :" + red);
            System.out.println("Before Shamir");
            //Secret Shamir
            // TODO: Here is a error, I should try to convert Integer to byte directly
            final byte[] secret_red = (Integer.toString(red)).getBytes(StandardCharsets.UTF_8);
            System.out.println("Integer Red :" + Integer.toString(red));
            System.out.println("secret_red:" + Arrays.toString(secret_red));
            final byte[] secret_green = (Integer.toString(green)).getBytes(StandardCharsets.UTF_8);
            final byte[] secret_blue = (Integer.toString(blue)).getBytes(StandardCharsets.UTF_8);
         
            final Map<Integer, byte[]> parts_red = scheme.split(secret_red);
            final Map<Integer, byte[]> parts_green = scheme.split(secret_green);
            final Map<Integer, byte[]> parts_blue = scheme.split(secret_blue);
            System.out.print("parts_red" + parts_red);
            // red
            final byte[] values_red = new byte[parts_red.size()];
            int j = 0;
            for (Map.Entry<Integer, byte[]> part : parts_red.entrySet()) {
               values_red[j] = part.getValue()[0];
               System.out.println(values_red[j]);
               j++;
            }
            System.out.print("Red Done");
            // green
            final byte[] values_green = new byte[parts_green.size()];
            j = 0;
            for (Map.Entry<Integer, byte[]> part : parts_green.entrySet()) {
               values_green[j] = part.getValue()[0];
               System.out.println(values_green[j]);
               j++;
            }
            // blue
            final byte[] values_blue = new byte[parts_blue.size()];
            j = 0;
            for (Map.Entry<Integer, byte[]> part : parts_blue.entrySet()) {
               values_blue[j] = part.getValue()[0];
               System.out.println(values_blue[j]);
               j++;
            }
            
            //Image Formation
            System.out.println("Image Formation");
            for(int i=0;i<scheme.n();i++)
            {
               imgs[i] = new BufferedImage(width, height, 
                                    BufferedImage.TYPE_INT_RGB);
               String new_red = new String("" + values_red[i]);
               String new_green = new String("" + values_green[i]);
               String new_blue = new String("" + values_blue[i]);

               int redS = Integer.parseInt(new_red);
               int greenS = Integer.parseInt(new_green);
               int blueS = Integer.parseInt(new_blue);
               if(redS > 255) redS = 255;
               else if(redS< 0) redS = 0;

               if(greenS > 255) greenS = 255;
               else if(greenS< 0) greenS = 0;

               if(blueS > 255) blueS = 255;
               else if(blueS< 0) blueS = 0;
               //Creating new Color object
               color = new Color(redS, greenS, blueS);

               //Setting new Color object to the image
               imgs[i].setRGB(x, y, color.getRGB());
            }
         }
      }
      System.out.println("outside loop");
      //Saving the modified image
      file = new File("C:\\Users\\USER\\Desktop\\java_project\\new_demo" + "1" + ".png");
      ImageIO.write(imgs[1], "png", file);
      System.out.println("Done...");
   }
}