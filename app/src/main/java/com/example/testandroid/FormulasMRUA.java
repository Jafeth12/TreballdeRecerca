package com.example.testandroid;

public class FormulasMRUA {


    public final double calcV(double v0, double a, double x1, double x0) {
        return (v0*v0)+(2*a)*(x1-x0);
    }

    public final double calcA(double v, double v0, double x1, double x0) {
        return (v-(v0*v0))/((x1-x0)*2);
    }

    public final double calcV0(double v, double a, double x1, double x0) {
        return Math.sqrt(v-2*a*(x1-x0));
    }

    public final double calcX1(double v, double v0, double x0, double a) {
        return (v-(v0*v0)+(2*a*x0))/(2*a);
    }

    public final double calcX0(double v, double v0, double x1, double a) {
        return ((v0*v0)-v+(2*a)*x1)/(2*a);
    }


}
