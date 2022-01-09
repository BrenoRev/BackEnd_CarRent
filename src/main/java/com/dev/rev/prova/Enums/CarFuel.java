package com.dev.rev.prova.Enums;


import com.fasterxml.jackson.annotation.JsonValue;

public enum CarFuel {
    DIESEL("Diesel"),
    FLEX("Flex"),
    GASOLINA("Gasolina"),
    HIBRIDO("Híbrido");

    private String type;

    @JsonValue
    public String getType() {
        return type;
    }

    private CarFuel(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
