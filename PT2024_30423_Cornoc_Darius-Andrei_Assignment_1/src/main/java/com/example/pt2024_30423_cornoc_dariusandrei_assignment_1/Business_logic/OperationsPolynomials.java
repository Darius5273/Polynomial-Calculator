package com.example.pt2024_30423_cornoc_dariusandrei_assignment_1.Business_logic;

import com.example.pt2024_30423_cornoc_dariusandrei_assignment_1.Data_Models.Fraction;
import com.example.pt2024_30423_cornoc_dariusandrei_assignment_1.Data_Models.Polynomial;

import java.util.Iterator;
import java.util.Map;

public class OperationsPolynomials {
    public static Polynomial add(Polynomial p, Polynomial q)
    {
        var result=new Polynomial();
        var P=p.getMonomials();
        var Q=q.getMonomials();

        Iterator<Map.Entry<Integer, Fraction>> iterator1=P.entrySet().iterator();
        Iterator<Map.Entry<Integer,Fraction>> iterator2=Q.entrySet().iterator();

        if(!p.isZero()) {
            while (iterator1.hasNext()) {
                var entry1 = iterator1.next();
                int exponent1 = entry1.getKey();
                Fraction coefficient1 = entry1.getValue();

                if (Q.get(exponent1) != null) {
                    Fraction coefficient2 = Q.get(exponent1);
                    Fraction newCoefficient = coefficient1.add(coefficient2);

                    if (newCoefficient.getNumerator() != 0)
                        result.addMonomial(exponent1, newCoefficient);
                } else
                    result.addMonomial(exponent1, coefficient1);
            }
        }
        while(iterator2.hasNext())
        {
            var entry=iterator2.next();
            int exponent = entry.getKey();
            Fraction coefficient = entry.getValue();

            if(P.get(exponent)==null && coefficient.getNumerator()!=0)
                result.addMonomial(exponent,coefficient);
        }
        return result;
    }
    public static Polynomial subtract(Polynomial p,Polynomial q)
    {
        for (Map.Entry<Integer, Fraction> monomial : q.getMonomials().entrySet()) {
            var oppositeCoefficient=new Fraction(monomial.getValue().getNumerator() * -1,monomial.getValue().getDenominator());
            monomial.setValue(oppositeCoefficient);
        }
        return add(p,q);
    }
    public static Polynomial multiply(Polynomial p,Polynomial q)
    {
        var result=new Polynomial();
        for(Map.Entry<Integer, Fraction> monomial1 : p.getMonomials().entrySet())
        {
            var intermediaryResult = new Polynomial();

            for(Map.Entry<Integer, Fraction> monomial2 : q.getMonomials().entrySet())
            {
                Fraction coefficient = monomial1.getValue().multiply(monomial2.getValue());
                int exponent = monomial1.getKey()+monomial2.getKey();
                intermediaryResult.addMonomial(exponent,coefficient);
            }

            result=add(result,intermediaryResult);
        }
        return result;
    }
    public static Polynomial derivate(Polynomial p)
    {
        var result = new Polynomial();
        for(Map.Entry<Integer, Fraction> monomial : p.getMonomials().entrySet())
        {
            int newExponent=monomial.getKey()-1;
            var fractionExponent=new Fraction(monomial.getKey(),1);
            Fraction coefficient=monomial.getValue().multiply(fractionExponent);

            if(newExponent!=-1)
                result.addMonomial(newExponent,coefficient);
        }
        return result;
    }

    public static Polynomial integrate(Polynomial p)
    {
        var result = new Polynomial();
        for(Map.Entry<Integer, Fraction> monomial : p.getMonomials().entrySet())
        {
            int newExponent=monomial.getKey()+1;
            var fractionExponent=new Fraction(newExponent,1);
            Fraction coefficient=monomial.getValue().divide(fractionExponent);
            result.addMonomial(newExponent,coefficient);
        }
        return result;
    }

    public static Polynomial[] divide(Polynomial numerator,Polynomial denominator)
    {
        Polynomial[] result=new Polynomial[2];
        result[1]=numerator;
        result[0]=new Polynomial("0");
        var denominatorLeadingTerm=denominator.getLeadingTerm();
        var leadingTerm=result[1].getLeadingTerm();

        while(!result[1].isZero() && leadingTerm.getKey()>=denominatorLeadingTerm.getKey()) {
            var divisionOfLeadingTerms = new Polynomial();
            int exponent = leadingTerm.getKey() - denominatorLeadingTerm.getKey();
            Fraction coefficient = leadingTerm.getValue().divide(denominatorLeadingTerm.getValue());
            divisionOfLeadingTerms.addMonomial(exponent, coefficient);
            result[0] = OperationsPolynomials.add(divisionOfLeadingTerms, result[0]);
            result[1] = OperationsPolynomials.subtract(result[1], OperationsPolynomials.multiply(divisionOfLeadingTerms, denominator));
            leadingTerm=result[1].getLeadingTerm();
        }
        return result;
    }
}
