package com.dev.rev.prova.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CarTransmission {
	
    AUTOMATICO("Automatico"),
    MANUAL("Manual");

    private String type;

    @JsonValue
    public String getType() {
        return type;
    }

    private CarTransmission(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
