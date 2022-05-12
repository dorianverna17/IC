package TestingModule;

import Code.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class TestingFile {
    @Test
    public void getTotalAmountWithZeroTips() throws Exception {
        Calculator calculator = new Calculator();
        assertEquals(10, calculator.calculate(10, 0));
    }

    @Test
    public void getTotalAmountWithTips() throws Exception {
        Calculator calculator = new Calculator();
        assertEquals(85.8, calculator.calculate(78, 10));
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, 10, 100, 78, 20})
    public void getTotalAmountWithTips2(Double amount) throws Exception {
        Calculator calculator = new Calculator();
        System.out.println("Amount " + amount + " with tips 10 = " + calculator.calculate(amount, 10));
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "10, 11",
            "100, 110",
            "78, 85.8",
            "20, 22",
    })
    public void getTotalAmountWithTips3(Double amount, Double expected) throws Exception {
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.calculate(amount, 10));
    }

    @ParameterizedTest
    @CsvSource({
            "-1, 0",
            "1, -1",
    })
    public void negativeSumTips(Double amount, Double tips) {
        Calculator calculator = new Calculator();

        Exception exception = assertThrows(Exception.class, () -> {
            calculator.calculate(amount, tips);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "100, 10, 2, 55",
            "50, 20, 3, 20",
            "160, 25, 5, 40",
            "80, 12.5, 9, 10",
            "120, 50, 4, 45"
    })
    public void splitTips(Double amount, Double tips, int personNumber, Double expected) throws Exception {
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.calculate(amount, tips, personNumber));
    }

    @ParameterizedTest
    @CsvSource({
            "0,",
            "27, 1 2 3 10 4 7"
    })
    public void sumString(int expected, String str) {
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.getSum(str));
    }

    @Test
    public void sumStringNotOk() {
        Calculator calculator = new Calculator();
        assertEquals(27, calculator.getSum("1,2,3,10,4,7"));
    }

    @Test
    public void sumStringMultipleThings() {
        Calculator calculator = new Calculator();
        assertEquals(6568, calculator.getSum("1?,;12?Afy.as6432?!AV:YH123"));
    }
}
