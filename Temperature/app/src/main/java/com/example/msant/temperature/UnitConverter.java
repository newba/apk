package com.example.msant.temperature;

/**
 * Created by msant on 2017-09-06.
 */

public class UnitConverter {

    public static double celsius2Farenheit (double c){
        return 32 + c * 9/5;
    }

    public static double farenheit2Celsius (double f){
        return (f-32)*5/9;
    }
}
