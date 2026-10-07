import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Man kann auch einen Displaynamen für die gesamte Klasse erstellen")
class CalculatorTest {

    // ==========================================================
    // GRUPPE 1: Grund-Setup — jeder Test braucht ein frisches Calculator-Objekt
    // ==========================================================

    private Calculator calculator;

    @BeforeEach
    void setUp() {

        calculator = new Calculator();
    }

    // test

    // ==========================================================
    // GRUPPE 2: Methoden mit Rückgabewert (add)
    // → Muster: aufrufen, Rückgabewert mit assertEquals vergleichen
    // ==========================================================

    @Test
    void add_returnSum() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    void add_withNegativeNumber() {
        assertEquals(-1, calculator.add(2, -3));
    }

    // dieselbe Prüfung, aber parametrisiert statt vieler Einzelmethoden
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "2, 3, 5",
            "2, -3, -1",
            "0, 0, 0",
            "-5, -5, -10"
    })
    void add_variousInputs(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 100})
    void add_withZero_returnSameNumber(int value) {
        assertEquals(value, calculator.add(value, 0));
    }


    // ==========================================================
    // GRUPPE 3: Methoden, die eine Exception werfen (divide)
    // → Muster: assertThrows mit Lambda
    // ==========================================================

    @Test
    void divideByZero_throwsException() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
    }


    // ==========================================================
    // GRUPPE 4: void-Methoden, die den Zustand ändern (store/recall)
    // → Muster: aufrufen, Wirkung über eine andere Methode prüfen
    // ==========================================================

    @Test
    void store_savesValue() {
        calculator.store(42);
        assertEquals(42, calculator.recall());
    }

    @Test
    void recall_initiallyZero() {
        assertEquals(0, calculator.recall());
    }


    // ==========================================================
    // GRUPPE 5: void-Methoden mit Konsolenausgabe (printResult)
    // → Muster: System.out umleiten, Puffer auslesen, danach zurückstellen
    // ==========================================================

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void redirectOut() {
        outContent.reset();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreOut() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("printResult schreibt den formatierten Text auf die Konsole")
    void printResult_printsToConsole() {
        calculator.printResult(5);
        assertEquals("Ergebnis: 5" + System.lineSeparator(), outContent.toString());
    }

    // ==========================================================
    // GRUPPE 6: Methoden mit Listen-Rückgabewert (getHistory)
    // → Muster: wie recall, nur der Rückgabewert ist eine Liste statt einer Zahl
    // → zusätzlich: assertAll bündelt mehrere Prüfungen in einem Test
    // ==========================================================

    @Test
    void getHistory_recordsAllAddResults() {
        calculator.add(2, 3);
        calculator.add(10, 5);
        assertEquals(List.of(5, 15), calculator.getHistory());
    }

    @Test
    void add_updatesResultAndHistory() {
        int result = calculator.add(2, 3);

        assertAll(
                () -> assertEquals(5, result),
                () -> assertEquals(List.of(5), calculator.getHistory())
        );
    }

    @Test
    void add_updatesResultAndHistory2() {
        int result = calculator.add(2, 3);
        assertEquals(5, result);
        assertEquals(List.of(5), calculator.getHistory());
    }


    // ==========================================================
    // GRUPPE 7: Methoden mit boolean-Rückgabewert (isEven)
    // → Muster: assertTrue / assertFalse statt assertEquals
    // ==========================================================

    @Test
    void isEven_evenNumber_isTrue() {
        assertTrue(calculator.isEven(4));
    }

    @Test
    void isEven_oddNumer_isFalse() {
        assertFalse(calculator.isEven(7));
    }

    // Randfälle: Null und negative Zahlen
    @ParameterizedTest (name = "isEven({0}) = {1}") // (name = "isEven({0}) = {1}") -> vergibt nur namen, kann man auch weglassen
    @CsvSource({
            "2, true",
            "3, false",
            "0, true",
            "-4, true",
            "-3, false"
    })
    void isEven_variousInputs(int value, boolean expected) {
        assertEquals(expected, calculator.isEven(value));
    }


    // ==========================================================
    // GRUPPE 8: Methoden mit double-Rückgabewert (percent)
    // → Muster: assertEquals mit DELTA (Toleranz) bei Kommazahlen
    // ==========================================================

    @Test
    void percent_oneOfFour_is25() {
        assertEquals(25.0, calculator.percent(1, 4));      // exakt darstellbar, kein Delta nötig
    }

    @Test
    void percent_oneOfThree_needsDelta() {
        // 1/3 = 33.333333..., nicht exakt darstellbar → Toleranz von 0.001
        assertEquals(33.333, calculator.percent(1, 3), 0.001);
    }

    @Test
    void percent_totalZero_isInfinity() {
        // bei double KEINE Exception, sondern Infinity (anders als bei int!)
        assertEquals(Double.POSITIVE_INFINITY, calculator.percent(1, 0));
    }

    @Test
    void maxFromHistory_emptyHistory_returnsNull() {
        assertNull(calculator.maxFromHistory()); // man könnte auch assertEquals(null, calculator.maxFromHistory()) schreiben,
                                                 // aber assertNull liest sich klarer und liefert eine passendere Fehlermeldung.
    }

    @Test
    void maxFromHistory_withValues_isNotNull() {
        calculator.add(3, 4);
        assertNotNull(calculator.maxFromHistory());
    }

    @Test
    void maxFromHistory_withValues_returnsMax() {
        calculator.add(2, 3);
        calculator.add(10, 1);
        calculator.add(1, 1);
        assertEquals(11, calculator.maxFromHistory());
    }

    @Test
    void getHistory_returnsSameListInstance() {
        List<Integer> first = calculator.getHistory();
        List<Integer> second = calculator.getHistory();
        assertSame(first, second); // dasselbe Objekt im Speicher?
        // assertEquals interessiert sich nur für den Inhalt der Kartons (Objekte), assertSame fragt, ob es derselbe Karton ist.
        // assertEquals nutzt intern equals(), assertSame nutzt ==.
        // Bei Zahlen und Strings meist egal (die sehen für == oft ohnehin gleich aus), bei eigenen Objekten/Listen macht es den Unterschied.
    }



}