package com.conversions.conversion.exception.model;

public class InvalidEntryException  extends RuntimeException {

    private static final long serialVersionUID = 8624344810222702368L;

    private final String errorDetails;

    public InvalidEntryException(String message, String details) {
        super(message);
        errorDetails = details;
    }

    public String getErrorDetails() {
        return errorDetails;
    }

}
