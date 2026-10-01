import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CalculatorLoggerTest {

    @Test
    void add_callsLoggerWithCorrectMessage() {
        Logger mockLogger = mock(Logger.class);              // 1: Attrappe bauen
        Calculator calculator = new Calculator(mockLogger);   // 2: echtes Calculator-Objekt, mit Attrappe statt echtem Logger

        int result = calculator.add(2, 3);                    // 3: normal aufrufen

        assertEquals(5, result);                               // 4: Rückgabewert wie gewohnt prüfen
        verify(mockLogger).log("add(2, 3) = 5");                // 5: NEU: wurde log() korrekt aufgerufen?
    }

}