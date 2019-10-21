package com.example.testandroid;

public class FormulasMRUyMCU {

//**************************************************************************************************
//FÓRMULAS DE V BÁSICAS

    public final double calcVMRU(double x, double t) {
        return x/t;
    }

    public final double calcXMRU(double v, double t) {
        return v*t;
    }

    public final double calcTMRU(double v, double x) {
        return x/v;
    }

//**************************************************************************************************
//FÓRMULAS X = X0 + V(T-T0)

    public final double calcV(double x1, double x0, double t1, double t0) {
        return (x1-x0)/(t1-t0);
    }

    public final double calcX1(double x0, double v, double t1, double t0) {
        return x0+v*(t1-t0);
    }

    public final double calcT1(double x1, double x0, double v, double t0) {
        return ((x1-x0)+(v*t0))/v;
    }

    public final double calcT0(double x1, double x0, double v, double t1) {
        return -1*(((x1-x0)-(v*t1))/v);
    }

    public final double calcX0(double x1, double v, double t1, double t0) {
        return x1-(v*(t1-t0));
    }

//**************************************************************************************************
//FÓRMULAS DE MCU

    public final double calcSecc(double phi, double R){
        return phi*R;
    }

    public final double calcSeccPhi(double s, double R) {
        return s/R;
    }

    public final double calcSeccR(double phi, double s) {
        return s/phi;
    }

}
