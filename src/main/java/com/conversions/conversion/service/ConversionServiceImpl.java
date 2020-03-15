package com.conversions.conversion.service;

import com.conversions.conversion.calculation.ConversionCalculator;
import org.springframework.stereotype.Service;

@Service
public class ConversionServiceImpl implements ConversionService {

    @Override
    public double getKtoC(double kelvin) {
        return (kelvin - ConversionCalculator.Kelvin_Celsius_Formula);

    }

    @Override
    public double getCtoK(double celsius) {
        return (celsius + ConversionCalculator.Kelvin_Celsius_Formula);
    }

    @Override
    public double getMtoK(double miles) {
        return (miles / ConversionCalculator.Miles_Kilometers_Value);
    }

    @Override
    public double getKtoM(double kilometers) {
        return (kilometers * ConversionCalculator.Miles_Kilometers_Value);
    }
}
