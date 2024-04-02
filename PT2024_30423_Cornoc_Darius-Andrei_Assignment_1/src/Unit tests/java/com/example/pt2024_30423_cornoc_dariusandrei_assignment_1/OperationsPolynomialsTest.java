package com.example.pt2024_30423_cornoc_dariusandrei_assignment_1;

import com.example.pt2024_30423_cornoc_dariusandrei_assignment_1.Business_logic.OperationsPolynomials;
import com.example.pt2024_30423_cornoc_dariusandrei_assignment_1.Data_Models.Polynomial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationsPolynomialsTest {

    private Polynomial p,q;

    @BeforeEach
    void setup()
    {
        p=new Polynomial("x^2+2x+3");
        q=new Polynomial("3x^2+2x+1");
    }

    @Test
    void add() {
        var sum= OperationsPolynomials.add(p,q);
        var expectedResult=new Polynomial("4x^2+4x+4");
        assertEquals(expectedResult.toString(),sum.toString());
    }

    @Test
    void subtract() {
        var diff= OperationsPolynomials.subtract(p,q);
        var expectedResult=new Polynomial("-2x^2+2");
        assertEquals(expectedResult.toString(),diff.toString());
    }

    @Test
    void multiply() {
        var product= OperationsPolynomials.multiply(p,q);
        var expectedResult=new Polynomial("3x^4+8x^3+14x^2+8x+3");
        assertEquals(expectedResult.toString(),product.toString());
    }

    @Test
    void derivate() {
        var derivate= OperationsPolynomials.derivate(p);
        var expectedResult=new Polynomial("2x+2");
        assertEquals(expectedResult.toString(),derivate.toString());
    }

    @Test
    void integrate() {
        var integral= OperationsPolynomials.integrate(q);
        var expectedResult=new Polynomial("x^3+x^2+x");
        assertEquals(expectedResult.toString(),integral.toString());
    }

    @Test
    void divide() {
        var result= OperationsPolynomials.divide(p,q);
        assertEquals(result[0].toString(),"0.3333");
        assertEquals("1.3333x+2.6666",result[1].toString());
    }
}