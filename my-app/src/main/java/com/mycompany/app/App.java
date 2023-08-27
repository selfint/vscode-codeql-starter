package com.mycompany.app;

/**
 * Hello world!
 *
 */
public class App 
{
    private static String getSecret() {
        return "The answer to life is 42";
    }
    
    public static void main( String[] args )
    {
        String secret = getSecret();
        System.out.println( "The secret is: " + secret );
    }
}
