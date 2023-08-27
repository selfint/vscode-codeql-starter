package com.mycompany.app;

import java.util.logging.*;

public class App {
    private static String getSecret() {
        return "secret";
    }
    
    public static void main( String[] args ) {
        Logger logger = Logger.getLogger("logger");

        String password = getSecret();

        // BAD: user password is written to debug log
        logger.info("User password is " + password);

        // GOOD: user password is never written to debug log
        logger.info("User password changed");
    }
}
