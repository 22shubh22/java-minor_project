package com.example.demo;

import com.codahale.shamir.Scheme;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Map;

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
        final byte[] secret = "hello there".getBytes(StandardCharsets.UTF_8);
        final Map<Integer, byte[]> parts = scheme.split(secret); 
        final byte[] recovered = scheme.join(parts);
        System.out.println(new String(recovered, StandardCharsets.UTF_8));
      }
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SetPixels setpixel = new SetPixels();
        try{
            setpixel.main();
        } catch(Exception e){

        }
        
    }
}
