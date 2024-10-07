package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringProcessorTest {
    StringProcessor processor = new StringProcessor();

    // Test cases for isStrongPassword method
    @Test
    public void testIsStrongPassword() {
        assertTrue(processor.isStrongPassword("Abc!1234"));  // Strong password
        assertFalse(processor.isStrongPassword("weak"));     // No digit or special char
        assertFalse(processor.isStrongPassword("NoDigits!"));  // No digits
        assertFalse(processor.isStrongPassword("lower123!"));  // No uppercase letter
        assertFalse(processor.isStrongPassword("12345678"));   // No letters
    }

    // Test cases for calculateDigits method
    @Test
    public void testCalculateDigits() {
        assertEquals(3, processor.calculateDigits("Hello 123 World"));
        assertEquals(0, processor.calculateDigits("No digits here"));
        assertEquals(4, processor.calculateDigits("2021 is the year"));
        assertEquals(1, processor.calculateDigits("A digit: 7"));
        assertEquals(0, processor.calculateDigits(""));
    }

    // Test cases for calculateWords method
    @Test
    public void testCalculateWords() {
        assertEquals(2, processor.calculateWords("Hello World"));
        assertEquals(5, processor.calculateWords("Java is a great programming language"));
        assertEquals(1, processor.calculateWords("Single"));
        assertEquals(0, processor.calculateWords(""));
        assertEquals(3, processor.calculateWords("  Spaces   around "));
    }

    // Test cases for calculateExpression method
    @Test
    public void testCalculateExpression() throws Exception {
        assertEquals(4, processor.calculateExpression("2 + 2"));
        assertEquals(25, processor.calculateExpression("5 * 5"));
        assertEquals(6, processor.calculateExpression("(3 + 3)"));
        assertEquals(1.5, processor.calculateExpression("3 / 2"));
        assertEquals(0, processor.calculateExpression("0 * 100"));
    }

}