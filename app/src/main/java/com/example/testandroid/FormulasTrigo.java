package com.example.testandroid;

public class FormulasTrigo {
//**************************************************************************************************

    private static double cos(double a) {
        return Math.cos(Math.toRadians(a));
    }

    private static double sin(double a) {
        return Math.sin(Math.toRadians(a));
    }

//**************************************************************************************************
    public final double sumaSin(double a, double b) {
        return sin(a)*cos(b) + cos(a)*sin(b);
    }

    public final double restaSin(double a, double b) {
        return sin(a)*cos(b) - cos(a)*sin(b);
    }


    public final double sumaCos(double a, double b) {
        return cos(a)*cos(b) + sin(a)*sin(b);
    }

    public final double restaCos(double a, double b) {
        return cos(a)*cos(b) - sin(a)*sin(b);
    }



}
