package com.tripenyazaraz.noita;

import static java.lang.Math.round;

public class Utils {

    public static int toInt(long lng) {
        return (int) lng;
    }

    public static int toInt(double dbl) {
        return (int) round(dbl);
    }

    public static int toInt(byte bt) {
        return (int) bt;
    }

    public static int toInt(short shrt) {
        return shrt;
    }

    public static int toInt(float flt) {
        return (int) round(flt);
    }

}
