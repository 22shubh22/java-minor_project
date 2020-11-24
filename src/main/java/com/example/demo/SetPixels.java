package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
public class SetPixels {
   public void main()throws IOException {
      //Reading the image
      File file= new File("C:\\Users\\USER\\Desktop\\java_project\\test1.png");
      BufferedImage img = ImageIO.read(file);
      for (int y = 0; y < img.getHeight(); y++) {
         for (int x = 0; x < img.getWidth(); x++) {
            //Retrieving contents of a pixel
            int pixel = img.getRGB(x,y);
            //Creating a Color object from pixel value
            Color color = new Color(pixel, true);
            //Retrieving the R G B values
            int red = color.getRed();
            int green = color.getGreen();
            int blue = color.getBlue();
            //Modifying the RGB values
            green = 150;
            blue = 150;
            //Creating new Color object
            color = new Color(red, green, blue);
            //Setting new Color object to the image
            img.setRGB(x, y, color.getRGB());
         }
      }
      //Saving the modified image
      file = new File("C:\\Users\\USER\\Desktop\\java_project\\new_demo.png");
      ImageIO.write(img, "png", file);
      System.out.println("Done...");
   }
}