package com.mycompany.app;

import java.util.logging.*;

public class App {
    private static String getSecret() {
        return "secret";
    }

    private static void log(String toLog) {
        Logger logger = Logger.getLogger("logger2");

        logger.info("Logging: " + toLog);
    }

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("logger");

        String password = getSecret();

        log(password);

        // BAD: user password is written to debug log
        logger.info("User password is " + password);

        // GOOD: user password is never written to debug log
        logger.info("User password changed");
    }
}

// https://github.com/github/codeql/blob/9957e2683b708f22a515323cfd650cf2625f8b84/java/ql/lib/semmle/code/java/security/SensitiveLoggingQuery.qll#L67
// https://github.com/github/codeql/blob/main/java/ql/src/Security/CWE/CWE-532/SensitiveInfoLog.ql