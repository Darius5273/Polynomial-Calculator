package com.example.pt2024_30423_cornoc_dariusandrei_assignment_1.Data_Models;

import static java.lang.Math.abs;

public class Fraction {
    private int numerator,denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }


    public int getDenominator() {
        return denominator;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public Fraction add(Fraction fraction) {
        int resultNumerator = this.numerator * fraction.denominator + fraction.numerator * this.denominator;
        int resultDenominator = this.denominator * fraction.denominator;
        int gcd=gcd(resultNumerator,resultDenominator);
        return new Fraction(resultNumerator/gcd, resultDenominator/gcd);
    }

    public Fraction subtract(Fraction fraction) {
        int resultNumerator = this.numerator * fraction.denominator - fraction.numerator * this.denominator;
        int resultDenominator = this.denominator * fraction.denominator;
        int gcd=gcd(resultNumerator,resultDenominator);
        return new Fraction(resultNumerator/gcd, resultDenominator/gcd);
    }

    public Fraction multiply(Fraction fraction) {
        int resultNumerator = this.numerator * fraction.numerator;
        int resultDenominator = this.denominator * fraction.denominator;
        int gcd=gcd(resultNumerator,resultDenominator);
        return new Fraction(resultNumerator/gcd, resultDenominator/gcd);
    }

    public Fraction divide(Fraction fraction) {
        int resultNumerator = this.numerator * fraction.denominator;
        int resultDenominator = this.denominator * fraction.numerator;
        int gcd=gcd(resultNumerator,resultDenominator);
        return new Fraction(resultNumerator/gcd, resultDenominator/gcd);
    }

    public String toString()
    {
        String string;
        double doubleResult=this.numerator/(double)this.denominator;
        string =doubleResult>=0?"":"-";
        int integerResult=(int)doubleResult;
        int decimals = (int)(abs(doubleResult-integerResult)*10000);

        if(doubleResult!=0 && integerResult == 0 && decimals == 0)
            return string+abs(doubleResult);

        string+=abs(integerResult);
        if(doubleResult==integerResult)
            return string;

        if(decimals<10)
            return string+".000"+decimals;
        else if(decimals<100) {
            while(decimals%10==0)
                decimals/=10;
            return string + ".00" + decimals;
        }
        else if(decimals<1000) {
            while (decimals % 10 == 0)
                decimals /= 10;
            return string + ".0" + decimals;
        }
        else {
            while(decimals%10==0)
                decimals/=10;
            return string + "." + decimals;
        }
    }
}
