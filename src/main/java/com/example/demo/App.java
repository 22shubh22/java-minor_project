package com.example.demo;

import com.codahale.shamir.Scheme;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Map;
import java.util.Arrays;

// class Example {
//   void doIt() {
//     final Scheme scheme = new Scheme(new SecureRandom(), 5, 3);
//     final byte[] secret = "hello there".getBytes(StandardCharsets.UTF_8);
//     final Map<Integer, byte[]> parts = scheme.split(secret);
//     final byte[] recovered = scheme.join(parts);
//     System.out.println(new String(recovered, StandardCharsets.UTF_8));
//   } 
// }


/**
 * Hello world!
 *
 */
public class App 
{
    public static void doIt() {
        final Scheme scheme = new Scheme(new SecureRandom(), 5, 3);
        int red = 0;
        final byte[] secret_red = (Integer.toString(red)).getBytes(StandardCharsets.UTF_8);
            System.out.println("Integer Red :" + Integer.toString(red));
            System.out.println("secret_red :" + Arrays.toString(secret_red));
        final Map<Integer, byte[]> parts_red = scheme.split(secret_red);
        System.out.println("Done"); 
        
      }
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //doIt();
        SetPixels setpixel = new SetPixels();
        try{
            setpixel.main();
        } catch(Exception e){

        }
        
    }
}
