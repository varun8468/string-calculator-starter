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
        assertThrows(Exception.class,() -> stringCalculator.add("-5,2,-9"),"negative not allowed"+"-5 -9");
        assertThrows(Exception.class,() -> stringCalculator.add("-1"),"negative not allowed"+"-1");
    }
    @Test
    void get_count_of_add_called() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.getCalledCount());
        stringCalculator.add("//:\n1:2:3");
        assertEquals(1,stringCalculator.getCalledCount());
    }
    @Test
    void numbers_bigger_than_1000_should_be_ignored() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(2, stringCalculator.add("2,1001"));
    }
    @Test
    void string_with_any_length_delimiter() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(18, stringCalculator.add("//[***]\n2***10***6"));
    }

}
