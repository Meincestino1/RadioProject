package tests;

import java.io.Console;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.sql.Time;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.stream.IntStream;

import static java.time.LocalTime.now;

public class SetOutTests {

    public static void main(String[] args) {

        Logger log = Logger.getLogger(SetOutTests.class.getName());
        Instant start = Instant.now();
        log.info("About to start");

        PrintStream originalOut = System.out;
        System.setOut(System.err);
        System.out.println("Hallo Welt");
        System.setOut(originalOut);

        System.out.println("getenv:");
        System.out.println(System.getenv("Path"));
        System.out.println(System.getProperty("user.home"));


        System.out.println(System.getProperty("java.io.tmpdir"));

        String[] isoCountries = Locale.getISOCountries();
        System.out.println(Arrays.toString(isoCountries));

        Locale xy = Locale.of("DE", "de");
        System.out.println(xy.getISO3Country());

        Locale zf = Locale.of("de", "DE", "Sauftirol");
        System.out.println(zf.getDisplayName());

        System.out.println(System.currentTimeMillis());
        System.out.println(Instant.now().getEpochSecond());

        long now = System.currentTimeMillis();
        long days = TimeUnit.MILLISECONDS.toDays(now);
        System.out.println(days);

        LocalDateTime mickyGeburt = LocalDateTime.of(1980, 12, 25, 19, 00);
        LocalDateTime jetzt = LocalDateTime.now();
        Period periode = Period.of(20, 1, 2);
        LocalDateTime result = mickyGeburt.plus(periode);
        System.out.println(result);
        System.out.println(Instant.now());
        System.out.println(LocalDate.ofEpochDay(20545));
        System.out.println(LocalDate.ofEpochDay(LocalDate.now().toEpochDay()).toEpochDay());
        System.out.println(LocalDate.of(1980, 12, 25).toEpochDay());
        System.out.println(LocalDate.of(2016, 11, 1).toEpochDay());
        System.out.println(LocalDate.of(2019, 9, 4).toEpochDay());

        // Logger ohne Namen, nur mit "" ist immer ein Root Logger, den man aber nicht explizit verwednen muss
        Logger logger = Logger.getLogger(""); // <--- Man kann Loggern aber auch einen Namen geben, die hängen dann am root
        // FileHandler benötigt Exception handling
        //FileHandler fileHandler = new FileHandler("logfile.log", true); //<--filename, true für appenden, false immer neues File
        //fileHandler.setLevel(Level.ALL); // auch dem FileHanlder sollte man ein Level übergeben (sonst wäre es default Level.INFO)
        //fileHandler.setFormatter(new SimpleFormatter()); //<--Formatter damit Ausgabe im File für Menschen lesbar wird
        //logger.addHandler(fileHandler); // Handler mit logger verbinden
        logger.setLevel(Level.ALL);  // Loglevel setzen, würde auch Level.FINEST oder was anderes gehen

        byte at = -128;
        byte it = (byte) Math.negateExact(at);

        BigInteger bigInteger = new BigInteger("101000011111010101010011100001111001010101010", 2);
        System.out.println(bigInteger);
        System.out.println(bigInteger.intValue());
        System.out.println(bigInteger.toString(2));

        int fuckingint = Integer.parseInt("10100001010111000", 2);
        System.out.println(fuckingint);
        System.out.println(Integer.valueOf(fuckingint).toString());

        System.out.println("do: ");
        System.out.println(BigInteger.valueOf(18).gcd(new BigInteger("12")));

        System.out.println(BigDecimal.ONE.divide(BigDecimal.valueOf(3),new MathContext(17)));
        //System.out.println(BigDecimal.ONE.divide(BigDecimal.valueOf(3)));

        Class<?> claus = RuntimeException.class;
        System.out.println(claus.getSuperclass());

        Console c = System.console();
        //String name = c.readLine("Wem kearsch du");
        //c.printf("Hallo %s!%n", name);

        String path = System.getenv("USERNAME");
        System.out.println(path);

        Runtime rt = Runtime.getRuntime();
        System.out.println(rt.maxMemory());
        System.out.println(rt.totalMemory());

        System.out.println(Runtime.getRuntime().availableProcessors());
        System.getProperties().list(System.out);
        System.out.println(System.getProperty("java.io.tmpdir"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperties());

        Boolean bul = Boolean.getBoolean("user.home");
        System.out.println(bul);

        System.out.println("Hier: ");
        System.out.println(System.lineSeparator());

        System.out.println("Hallo du kleiner " + System.lineSeparator() + "Typ");

        System.out.println(System.getenv("OS"));
        System.out.println(System.getProperty("os.name"));

        String text = "HELLO".toLowerCase(Locale.of("ja"));
        System.out.println(text);

        long secs = java.time.Instant.now().getEpochSecond();
        System.out.println(secs);

        System.out.println(TimeUnit.MILLISECONDS.toSeconds(1000));

        LocalDate myBirthday = LocalDate.of(1980, Month.DECEMBER, 25);
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        System.out.println(myBirthday.format(dtf));
        System.out.println(myBirthday.format(dtf.withLocale(Locale.CHINA)));

        LocalDate today = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        System.out.println(today);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE",Locale.CHINA);
        System.out.println(today.format(formatter));

        LocalDate nows = LocalDate.now();
        LocalDate firstDayOfYear = nows.minusYears(45);
        System.out.println(firstDayOfYear);

        System.out.println(Thread.currentThread());

        IntStream.range(0, 20).forEach(System.out::println);

        Thread.ofVirtual().start(() -> System.out.println("Hey"));


    }



    }


