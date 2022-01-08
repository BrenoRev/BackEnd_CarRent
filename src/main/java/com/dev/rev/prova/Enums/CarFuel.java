package com.dev.rev.prova.Enums;

import lombok.Getter;

@Getter
public enum CarFuel {
    DIESEL("Diesel"),
    FLEX("Flex"),
    GASOLINA("Gasolina"),
    HIBRIDO("Híbrido");

    private String type;

    private CarFuel(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
