package com.example.pt2024_30423_cornoc_dariusandrei_assignment_1;

import com.example.pt2024_30423_cornoc_dariusandrei_assignment_1.Data_Models.Fraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    private Fraction fraction1;
    private Fraction fraction2;

    @BeforeEach
    void setUp() {
        fraction1 = new Fraction(3, 4);
        fraction2 = new Fraction(1, 2);
    }

    @Test
    void add() {
        Fraction sum = fraction1.add(fraction2);
        assertTrue(sum.getNumerator() == 5 && sum.getDenominator() == 4);
    }

    @Test
    void subtract() {
        Fraction difference = fraction1.subtract(fraction2);
        assertTrue(difference.getNumerator() == 1 && difference.getDenominator() == 4);
    }

    @Test
    void multiply() {
        Fraction product = fraction1.multiply(fraction2);
        assertTrue(product.getNumerator() == 3 && product.getDenominator() == 8);
    }

    @Test
    void divide() {
        Fraction quotient = fraction1.divide(fraction2);
        assertTrue(quotient.getNumerator() == 3 && quotient.getDenominator() == 2);
    }

    @Test
    void gcd() {
        int result = Fraction.gcd(12, 8);
        assertEquals(4, result);
    }
}