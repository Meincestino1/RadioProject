package tests;

import static java.time.Instant.now;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JULDemo {

    private static final Logger log = Logger.getLogger(JULDemo.class.getName());

    public static void main(String[] args) {

        System.out.print("Instant zeug:");
        Instant start = now();
        log.info("About to start");


        try{
            log.log(Level.INFO, "Let's try to throw {0}", "null");
            throw null;
        }
        catch (Exception e) {
            log.log(Level.SEVERE, "Oh Oh", e);
        }
        log.info( () -> String.format("Runtime: %s ms", start.until(now(), ChronoUnit.MILLIS)));


    }

}
