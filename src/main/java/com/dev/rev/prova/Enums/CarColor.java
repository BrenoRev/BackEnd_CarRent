package com.dev.rev.prova.Enums;

import lombok.Getter;

@Getter
public enum CarColor {

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

    private String color;

    private CarColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return this.color;
    }
}
