package com.example.pt2024_30423_cornoc_dariusandrei_assignment_1.Data_Models;

import java.util.*;

public class Polynomial {

    private HashMap<Integer, Fraction> monomials;
    public Polynomial()
    {
        monomials = new HashMap<>();
    }
    public Polynomial(String polynomial) {
        this();
        if(!polynomial.isEmpty() && containsValidMonomials(polynomial))
            this.parsePolynomial(polynomial);
        else
            this.monomials=null;
    }
    public HashMap<Integer, Fraction> getMonomials() {
        return monomials;
    }
    public void addMonomial(int exponent, Fraction coefficient) {
        monomials.put(exponent, coefficient);
    }

    public boolean isZero()
    {
        boolean ok=true;
        for(Map.Entry<Integer, Fraction> monomial : this.getMonomials().entrySet())
        {
            if(monomial.getValue().getNumerator()!=0) {
                ok = false;
                break;
            }
        }
        return ok;
    }

    private static boolean containsValidMonomials(String string)
    {
        String coefficientOfX="((1[0-9]+)?|[2-9][0-9]*)";
        String constantTerm="([1-9]+\\d*)";
        String exponentOfX="(1[0-9]+|[2-9][0-9]*)";
        String matcher="0|^(-?("+coefficientOfX+"x\\^"+exponentOfX+"|"+coefficientOfX+"x|"+constantTerm+"))"+
                "([+-]("+coefficientOfX+"x\\^"+exponentOfX+"|"+coefficientOfX+"x|"+constantTerm+"))*";
        return string.matches(matcher);
    }
    private void parsePolynomial(String polynomial) {

        polynomial=polynomial.replaceAll("-","+-");
        polynomial=polynomial.replaceAll("-x","-1x");
        polynomial=polynomial.replaceAll("\\+x|^x","+1x");
        String[] monomials = polynomial.split("\\+");

        for (String m : monomials) {
            int coefficient;
            int exponent;

            if (m.isEmpty())
                continue;

            if (m.contains("x"))
                exponent = 1;
            else
                exponent = 0;

            String[] parts = m.split("x\\^?");

            if (parts.length == 1 && !parts[0].isEmpty()) {
                coefficient = Integer.parseInt(parts[0]);
            } else {
                coefficient = Integer.parseInt(parts[0]);
                exponent = Integer.parseInt(parts[1]);
            }
            Fraction fractionCoefficient = new Fraction(coefficient, 1);
            if (this.getMonomials().get(exponent) == null)
                this.addMonomial(exponent, fractionCoefficient);
            else
            {
                this.monomials=null;
                break;
            }
        }
    }
    public Map.Entry<Integer,Fraction> getLeadingTerm()
    {
        int max=-1;
        Map.Entry<Integer,Fraction> entry=null;
        for(Map.Entry<Integer, Fraction> monomial : this.getMonomials().entrySet())
        {
            if(monomial.getKey()>max) {
                max = monomial.getKey();
                entry=monomial;
            }
        }
        return entry;
    }
    public String toString()
    {
        TreeMap<Integer,Fraction> treeMapPolynomial=new TreeMap<>(Comparator.reverseOrder());
        treeMapPolynomial.putAll(getMonomials());
        String string="";
        for(Map.Entry<Integer, Fraction> monomial : treeMapPolynomial.entrySet())
        {
            Fraction fractionCoefficient=monomial.getValue();
            double doubleCoefficient = fractionCoefficient.getNumerator()/ (double)fractionCoefficient.getDenominator();
            int exponent=monomial.getKey();

            if(!string.isEmpty() && doubleCoefficient>0)
                string+="+";

            if(doubleCoefficient==-1)
                string+="-";
            else if(doubleCoefficient!=1) string+=fractionCoefficient;

            if(exponent!=0) {
                if(exponent!=1)
                    string += "x^" +exponent;
                else
                    string+="x";
            }
            else if(doubleCoefficient==-1||doubleCoefficient==1)
                string+="1";
        }
        if(!string.isEmpty())
            return string;
        else
            return "0";
    }

}
