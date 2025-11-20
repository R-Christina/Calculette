package com.example;

public class Calculatrice {
    public float a;
    public float b;
    public float c;

    public float getA() {
        return a;
    }
    public void setA(float a) {
        this.a = a;
    }
    public float getB() {
        return b;
    }
    public void setB(float b) {
        this.b = b;
    }
    public float getC() {
        return c;
    }
    public void setC(float c) {
        this.c = c;
    }

    public float secondDegre()
    {
        int delta = b*b-(4*a*c);

        if(delta>0)
        {
            float solution1 = (-b+Math.sqrt(delta))/(2.0*a);
            float solution2 = (-b-Math.sqrt(delta))/(2.0*a);
            return new float[] {delta, solution1, solution2};
        } else if(delta==0)
        {
            float solution = -b/2.0*a;
            return new float[] {delta,solution};
        } else
        {
             return null;
        }
    }
    
}
