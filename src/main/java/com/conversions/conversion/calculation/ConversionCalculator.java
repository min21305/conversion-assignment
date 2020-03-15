package com.conversions.conversion.calculation;

import org.springframework.stereotype.Component;

@Component
public class ConversionCalculator {

    final public static double Kelvin_Celsius_Formula = 273.15d;
    final public static double Miles_Kilometers_Value = 0.62137d;

    final public static long getStartTime() {

        return System.currentTimeMillis();
    }

    final public static long getEndTime(final long startTime) {

        return (System.currentTimeMillis() - startTime);
    }
}
