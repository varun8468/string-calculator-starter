package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorShould {

    @Test
    void empty_string_should_return_0() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.add(""));
    }
    @Test
    void string_with_single_number_should_return_number_as_int() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1, stringCalculator.add("1"));
    }
    @Test
    void string_with_comma_seperated_two_numbers() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3, stringCalculator.add("1,2"));
    }
    @Test
    void string_with_any_number() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6, stringCalculator.add("1,2,3"));
    }
    @Test
    void handle_new_lines_between_numbers() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6, stringCalculator.add("1,2\n3"));
    }
    @Test
    void handle_different_delimiters() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6, stringCalculator.add("//:\n1:2:3"));
        assertEquals(6, stringCalculator.add("//;\n1;2;3"));
    }
    @Test
    void string_with_negative_number() {
        StringCalculator stringCalculator = new StringCalculator();
        //assertThrows(Exception.class,() -> stringCalculator.add("-1,2,-3"),"negative not allowed"+"-1 -3");
        assertThrows(Exception.class,() -> stringCalculator.add("-1"),"negative not allowed"+"-1");
    }
}
