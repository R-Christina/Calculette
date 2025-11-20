package com.example;

public class Calculatrice {
    public double a;
    public double b;
    public double c;

     public Calculatrice(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }
    public void setA(double a) {
        this.a = a;
    }
    public double getB() {
        return b;
    }
    public void setB(double b) {
        this.b = b;
    }
    public double getC() {
        return c;
    }
    public void setC(double c) {
        this.c = c;
    }

    public double[] CalculSecondDegre()
    {
        double delta = b*b-(4*a*c);

        if(delta>0)
        {
            double solution1 = (-b+Math.sqrt(delta))/(2.0*a);
            double solution2 = (-b-Math.sqrt(delta))/(2.0*a);
            return new double[] {delta, solution1, solution2};
        } else if(delta==0)
        {
            double solution = -b/2.0*a;
            return new double[] {delta,solution};
        } else
        {
             return null;
        }
    }
}
