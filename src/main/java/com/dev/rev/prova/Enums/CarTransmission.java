package com.dev.rev.prova.Enums;

import lombok.Getter;

@Getter
public enum CarTransmission {
    AUTOMATICO("Automatico"),
    MANUAL("Manual");

    private String type;

    private CarTransmission(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
