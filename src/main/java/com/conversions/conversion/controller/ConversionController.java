package com.conversions.conversion.controller;

import com.conversions.conversion.calculation.ConversionCalculator;
import com.conversions.conversion.exception.model.InvalidEntryException;
import com.conversions.conversion.response.CalculationResponse;
import com.conversions.conversion.service.ConversionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conversions")
@Api(tags = "Conversion Service")
public class ConversionController {

    private static Logger logger = LoggerFactory.getLogger(ConversionController.class);

    @Autowired
    private ConversionService conversionService;

    /**
     * Ping for health check
     */
    @ApiOperation(value = "Ping for health check")
    @GetMapping(value = "/ping", produces = "application/json")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("Conversion Services are up and running.");
    }

    /**
     * @param kelvin
     * @return celsius
     */
    @ApiOperation(value = "Converts kelvin to Celsius")
    @GetMapping(path = "/KtoC", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CalculationResponse> convertKtoC(@RequestParam final double kelvin) {
        // Start the clock
        final long startTime = ConversionCalculator.getStartTime();
        final double celsius;

        if (kelvin != 0) {
            celsius = conversionService.getKtoC(kelvin);
        } else {
            throw new InvalidEntryException("Bad request", "Invalid kelvin entry " + kelvin);
        }

        logger.info("Execution Duration for ktoc : " + ConversionCalculator.getEndTime(startTime));

        return ResponseEntity.ok(new CalculationResponse("The Conversion of kelvin :" + kelvin + "  in Celsius is " + celsius, ConversionCalculator.getEndTime(startTime)));
    }

    /**
     * @param celsius
     * @return kelvin
     */
    @ApiOperation(value = "Converts Celsius to kelvin")
    @GetMapping(path = "/CtoK", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CalculationResponse> convertCtoK(@RequestParam final double celsius) {
        // Start the clock
        final long startTime = ConversionCalculator.getStartTime();
        final double kelvin;

        if (celsius != 0) {
            kelvin = conversionService.getCtoK(celsius);
        } else {
            throw new InvalidEntryException("Bad request", "Invalid Celsius entry " + celsius);
        }

        logger.info("Execution Duration for ctoK : " + ConversionCalculator.getEndTime(startTime));

        return ResponseEntity.ok(new CalculationResponse("The Conversion of Celsius :" + celsius + "  in kelvin is " + kelvin, ConversionCalculator.getEndTime(startTime)));
    }

    /**
     * @param miles
     * @return kilometers
     */
    @ApiOperation(value = "Converts miles to kilometers")
    @GetMapping(path = "/MtoK", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CalculationResponse> convertMtoK(@RequestParam final double miles) {
        // Start the clock
        final long startTime = ConversionCalculator.getStartTime();
        final double kilometers;

        if (miles != 0) {
            kilometers = conversionService.getMtoK(miles);
        } else {
            throw new InvalidEntryException("Bad request", "Invalid miles entry " + miles);
        }

        logger.info("Execution Duration for mtoK : " + ConversionCalculator.getEndTime(startTime));

        return ResponseEntity.ok(new CalculationResponse("The Conversion of miles :" + miles + "  in kilometers is " + kilometers, ConversionCalculator.getEndTime(startTime)));
    }

    /**
     * @param kilometers
     * @return miles
     */
    @ApiOperation(value = "Converts kilometers to miles")
    @GetMapping(path = "/KtoM", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CalculationResponse> convertKtoM(@RequestParam final double kilometers) {
        // Start the clock
        final long startTime = ConversionCalculator.getStartTime();
        final double miles;

        if (kilometers != 0) {
            miles = conversionService.getKtoM(kilometers);
        } else {
            throw new InvalidEntryException("Bad request", "Invalid kilometers entry " + kilometers);
        }

        logger.info("Execution Duration for KtoM : " + ConversionCalculator.getEndTime(startTime));

        return ResponseEntity.ok(new CalculationResponse("The Conversion of kilometers :" + kilometers + "  in miles is " + miles, ConversionCalculator.getEndTime(startTime)));
    }

}
