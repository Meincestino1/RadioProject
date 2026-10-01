import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) //<- mit dem kann man etwas vereinfacht schreiben, siehe Methode thenThrowDemo
class CalculatorRandomTest {

    @Test
    void rollDice_returnsProviderValuePlusOne() {
        RandomProvider mockProvider = mock(RandomProvider.class);
        when(mockProvider.nextInt(6)).thenReturn(18);        // Antwort vorgeben -> programmiert eine Antwort für dieses Argument
        when(mockProvider.nextInt(2)).thenReturn(27); // wenn mit 6 aufgerufen wird übergebe 18, wenn mit 2 dann übergebe 27

        Calculator calculator = new Calculator(new FileLogger(), mockProvider);

        int result = calculator.rollDice(2);

        assertEquals(28, result);
    }

    // Der ganze kack funktioniert aus verschienen Gründen nicht, Mockito eigenheiten
    @Mock
    RandomProvider mockProvider;
    @Test
    void thenThrowDemo() {
        when(mockProvider.nextInt(6)).thenThrow(new Error("kaputt"));
        Calculator calculator = new Calculator(new FileLogger(), mockProvider);
        assertThrows(RuntimeException.class, () -> calculator.rollDice(7));
    }


    // Verify mit times, dann mit never und mit atLeastOnce
    @Test
    void add_logsExactlyOnce() {
        Logger mockLogger = mock(Logger.class);
        Calculator calculator = new Calculator(mockLogger);

        calculator.add(2, 3);   // ruft intern genau einmal logger.log(...) auf

        verify(mockLogger, times(1)).log(anyString());   // wurde log() genau einmal aufgerufen?
    }                                               // mit Eingabe 3 schlägt der Test fehl

    @Test
    void divide_doesNotLog() {
        Logger mockLogger = mock(Logger.class);
        Calculator calculator = new Calculator(mockLogger);

        calculator.divide(6, 3);   // divide ruft logger.log(...) gar nicht auf

        verify(mockLogger, never()).log(anyString());   // wurde log() NIE aufgerufen?
    }                       // mit add anstatt divide würde der Test fehlschlagen

    @Test
    void add_calledThreeTimes_logsAtLeastOnce() {
        Logger mockLogger = mock(Logger.class);
        Calculator calculator = new Calculator(mockLogger);

        calculator.add(1, 1);
        calculator.add(2, 2);
        calculator.add(3, 3);   // log() wird dabei insgesamt DREIMAL aufgerufen
        // calculator.divide(3, 2); <- mit divide und allen add's auskommentiert würde der Test fehlschlagen
        verify(mockLogger, atLeastOnce()).log(anyString());   // mindestens einmal reicht hier aus
    }

}