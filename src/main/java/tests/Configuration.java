package tests;

import java.io.FilterOutputStream;
import java.io.PrintStream;
import java.sql.Time;
import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.JapaneseChronology;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static java.lang.System.out;
import static java.util.Locale.*;

public enum Configuration {
    INSTANCE;
    private final java.util.Properties props = new Properties(System.getProperties());
    public String getVersion() {
        return "1.2";
    }

    public String getUserDir() {
        return props.getProperty("user.dir");
    }

    public static void main(String[] args) {
        System.out.println(Configuration.INSTANCE.getVersion());
        System.out.println(Configuration.INSTANCE.getUserDir());

        Class clazz1 = Integer.class;
        Class clazz2 = Integer.TYPE;
        System.out.println(clazz1);
        System.out.println(clazz2);
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(System.getProperty("os.name"));
        System.out.println("Des:");
        System.getProperties().list(System.out);
        System.out.println("dou:");
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.dir"));

        String wixkopf = "Iatsa";
        String wixtopf = System.getProperty(wixkopf);
        System.out.println(wixtopf);

        System.out.println("Linienseparator: ");
        String karauf = System.lineSeparator();
        System.out.println("[" + karauf + "]");

        // Umgebungsvariablen:
        System.out.println("Umgebungsvariablen: ");
        System.out.println("\n\n\n");
        Map<String,String> map = System.getenv();
        map.forEach( (k, v)-> System.out.printf( "%s=%s%n",k,v));

        // Einzelne Umgebungsvariablen:
        System.out.println("Einzelne Umgebungsvariablen: ");
        String uv = System.getenv("OS");
        System.out.println(uv);

        Locale myLocale = Locale.getDefault();
        String myCountry = myLocale.getDisplayCountry();
        System.out.println(myLocale.toString());
        System.out.println(myCountry);

        System.out.println("Available Locals: ");
        Locale[] avLocals = Locale.getAvailableLocales();
        Arrays.stream(avLocals).forEach(s -> System.out.println(s));

        double x = Double.parseDouble("2.5");
        System.out.println(x);

        out.println(GERMANY.getDisplayName(FRENCH));

        Date date = new Date(80, 11, 25); //deprecated
        out.println(date.toString());

        long actualMillis = System.currentTimeMillis();
        long actualHours = TimeUnit.MILLISECONDS.toHours(actualMillis);
        out.println(actualHours);
        out.println(TimeUnit.DAYS.toHours(1)); // 24

        //TimeUnit.MINUTES.convert(Duration.of(12)); // 720

        Period aaa = Period.of(25, 12, 1980);
        out.println(aaa);

        ChronoLocalDate now = JapaneseChronology.INSTANCE.dateNow();
        System.out.println(now);
        LocalDate stNow = LocalDate.from(now);
        out.println("Gregorian: " + stNow);

        LocalDate date1 = LocalDate.of(2026, 3, 11);
        boolean leap = date1.isLeapYear();

        LocalDate nowi = LocalDate.now();
        LocalDate nextMondy = nowi.with(TemporalAdjusters.next(DayOfWeek.MONDAY));

        LocalDate scheissdreck =  LocalDate.now().minusMonths(1);
        out.println(scheissdreck);
        LocalDate scheissdrecc =  LocalDate.now().plusMonths(-1);
        out.println(scheissdrecc);


    }
}
