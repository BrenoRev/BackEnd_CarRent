package com.dev.rev.prova.enums;

import com.fasterxml.jackson.annotation.JsonValue;


public enum CarColor{

    AMARELO("Amarelo"),
    AZUL("Azul"),
    BEGE("Bege"),
    BRANCO("Branco"),
    CINZA("Cinza"),
    DOURADO("Dourado"),
    LARANJA("Laranja"),
    MARROM("Marrom"),
    PRATA("Prata"),
    PRETO("Preto"),
    ROXO("Roxo"),
    VERDE("Verde"),
    VERMELHO("Vermelho"),
    OUTROS("Outros");

    private String cor;

    CarColor() {
    }

    @JsonValue
    public String getCor() {
        return cor;
    }

    private CarColor(String color) {
        this.cor = color;
    }

    @Override
    public String toString() {
        return this.cor;
    }


}
