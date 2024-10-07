package org.example;
import java.util.regex.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class StringProcessor {

    /**
     * Checks if the given password is strong.
     * A strong password must contain at least one uppercase letter, one lowercase letter,
     * one digit, and one special symbol.
     *
     * @param password The password to validate.
     * @return True if the password is strong, otherwise false.
     */
    public boolean isStrongPassword(String password) {
        if (password == null || password.length() < 8) {
            return false; // Optional minimum length check
        }

        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(ch)) {
                hasSpecialChar = true;
            }
        }

        return hasUppercase && hasLowercase && hasDigit && hasSpecialChar;
    }

    /**
     * Counts the number of digits in the given sentence.
     *
     * @param sentence The sentence in which to count the digits.
     * @return The count of digits in the sentence.
     */
    public int calculateDigits(String sentence) {
        if (sentence == null) {
            return 0;
        }

        int digitCount = 0;
        for (char ch : sentence.toCharArray()) {
            if (Character.isDigit(ch)) {
                digitCount++;
            }
        }
        return digitCount;
    }

    /**
     * Calculates the number of words in the given sentence.
     * Words are considered to be separated by spaces.
     *
     * @param sentence The sentence in which to count the words.
     * @return The count of words in the sentence.
     */
    public int calculateWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return 0;
        }

        // Split by one or more spaces
        String[] words = sentence.trim().split("\\s+");
        return words.length;
    }

    /**
     * Given a string containing a mathematical expression, evaluates and returns the result.
     * Assumes the expression is well-formed.
     *
     * @param expression The mathematical expression to evaluate.
     * @return The result of the evaluated expression.
     */
    public double calculateExpression(String expression) throws ScriptException {
        if (expression == null || expression.trim().isEmpty()) {
            throw new IllegalArgumentException("Expression cannot be null or empty");
        }

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        // Evaluate the expression
        return (double) engine.eval(expression);
    }
}