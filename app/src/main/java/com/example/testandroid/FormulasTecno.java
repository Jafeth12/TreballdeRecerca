package com.example.testandroid;

public class FormulasTecno {

    public final double ec(double m, double v) {
        return (m*(v*v))/2;
    }

    public final double ecCalcM(double ec, double v) {
        return (2*ec)/(v*v);
    }

    public final double ecCalcV(double ec, double m) {
        return Math.sqrt((2*ec)/(m));
    }


//**************************************************************************************************

    public final double ep(double m, double g, double h) {
        return m*g*h;
    }

    public final double epCalcM(double ep, double g, double h) {
        return ep/(g*h);
    }

    public final double epCalcG(double ep, double m, double h) {
        return ep/(m*h);
    }

    public final double epCalcH(double ep, double m, double g) {
        return ep/(m*g);
    }

//**************************************************************************************************

    public final double workCalcW(double f, double d, double cos1) {
        return f*d*Math.cos(Math.toRadians(cos1));
    }

    public final double workCalcF(double w, double d, double cos1) {
        return w/(d*Math.cos(Math.toRadians(cos1)));
    }

    public final double workCalcD(double w, double f, double cos1) {
        return w/(f*Math.cos(Math.toRadians(cos1)));
    }

    public final double workCalcCos(double w, double f, double d) {
        double res = w/(f*d);
        return Math.acos(res) * 180/Math.PI;
    }

//**************************************************************************************************

    public final double oCalcV(double i, double r) {
        return r*i;
    }

    public final double oCalcI(double v, double r) {
        return v/r;
    }

    public final double oCalcR(double i, double v) {
        return v/i;
    }


    public final double pCalcP(double v, double i) {
        return v*i;
    }

    public final double pCalcV(double p, double i) {
        return p/i;
    }

    public final double pCalcI(double p, double v) {
        return p/v;
    }
}
