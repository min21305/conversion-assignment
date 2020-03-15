package com.conversions.conversion.response;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Objects;

@ApiModel(description = "Generic Response", value = "Generic Response value")
public class CalculationResponse implements Serializable {

    private static final long serialVersionUID = -2009657402718117058L;

    private String calculatedValue;
    private long timeConsumed;

    public CalculationResponse(String calculatedValue, long timeConsumed) {
        this.calculatedValue = calculatedValue;
        this.timeConsumed = timeConsumed;
    }

    public CalculationResponse() {
    }

    public String getCalculatedValue() {
        return calculatedValue;
    }

    public void setCalculatedValue(String calculatedValue) {
        this.calculatedValue = calculatedValue;
    }

    public long getTimeConsumed() {
        return timeConsumed;
    }

    public void setTimeConsumed(long timeConsumed) {
        this.timeConsumed = timeConsumed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalculationResponse that = (CalculationResponse) o;
        return Objects.equals(calculatedValue, that.calculatedValue) &&
                Objects.equals(timeConsumed, that.timeConsumed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(calculatedValue, timeConsumed);
    }

    @Override
    public String toString() {
        return "CalculationResponse{" +
                "calculatedValue='" + calculatedValue + '\'' +
                ", timeConsumed='" + timeConsumed + '\'' +
                '}';
    }
}
