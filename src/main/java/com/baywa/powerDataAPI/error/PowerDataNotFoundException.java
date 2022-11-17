package com.baywa.powerDataAPI.error;

public class PowerDataNotFoundException extends RuntimeException {

    public PowerDataNotFoundException(String id) {
        super("Could not find powerData " + id);
    }

}
