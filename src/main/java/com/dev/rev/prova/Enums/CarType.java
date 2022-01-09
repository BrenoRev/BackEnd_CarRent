package com.dev.rev.prova.Enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public enum CarType {

    CONVERTIBLE("Convertible"),
    COUPE("Coupe"),
    HATCHBACK("Hatchback"),
    PICKUP("Pickup"),
    SEDAN("Sedan"),
    SUV("Suv"),
    VAN("Van");

    private String type;

    @JsonValue
    public String getType() {
        return type;
    }

    private CarType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
