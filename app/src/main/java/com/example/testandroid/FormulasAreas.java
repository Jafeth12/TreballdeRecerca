package com.example.testandroid;

public class FormulasAreas {

    public final double bh(double b, double h) {
        return b*h;
    }

    public final double bhCalcB(double a, double h) {
        return a/h;
    }

    public final double bhCalcH(double a,  double b) {
        return a/b;
    }
//**************************************************************************************************

    public final double tri(double b, double h) {
        return (b*h)/2;
    }

    public final double triCalcB(double a, double h) {
        return (2*a)/h;
    }

    public final double triCalcH(double a, double b) {
        return (2*a)/b;
    }

//**************************************************************************************************
    public final double cir(double r) {
        double pi = Math.PI;
        return pi*(r*r);
    }

    public final double cirCalcR(double a) {
        double pi = Math.PI;
        return Math.sqrt(a/pi);
    }
}
