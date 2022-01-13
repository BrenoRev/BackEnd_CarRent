package com.dev.rev.prova.Enums;

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
