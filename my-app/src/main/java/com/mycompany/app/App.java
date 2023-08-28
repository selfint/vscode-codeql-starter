package com.mycompany.app;

import java.util.logging.*;

public class App {
    private static String getSecret() {
        return "secret";
    }

    private static void method(String string) {
        Logger logger = Logger.getLogger("logger");

        // BAD: user password is written to debug log
        logger.info("Some value is " + string);

        // GOOD: user password is never written to debug log
        logger.info("Value written to log");
    }

    private static String method2(String string) {
        return string + "!";
    }
    
    public static void main( String[] args ) {
        Logger logger = Logger.getLogger("logger");

        String password = getSecret();

        String string = method2(password);
        method(string);

        // BAD: user password is written to debug log
        logger.info("User password is " + password);

        // GOOD: user password is never written to debug log
        logger.info("User password changed");
    }
}
