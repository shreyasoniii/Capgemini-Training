package Calculator;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    static Calculator cal;
    @BeforeEach
    public void init(){
        cal=new Calculator();
        System.out.print("Calculator Object created");
    }
    @AfterAll
    public static void destory(){
        cal=new Calculator();
        System.out.print("Destory");
    }
    @Test
    @DisplayName("TESTING CALCULATE")
    public void calTest(){
        Calculator cal=new Calculator();
        assertEquals(10,cal.calcute(5,5));
    }


    @Timeout(value = 20000000,unit = TimeUnit.NANOSECONDS)
    @ParameterizedTest
    @ValueSource(ints ={12,34,45,55,63})
    public void isPrimetest(){
        Calculator cal=new Calculator();
        assertTrue(cal.isPrime(13));
        assertFalse(cal.isPrime(16));
        assertFalse(cal.isPrime(1));


    }
}
