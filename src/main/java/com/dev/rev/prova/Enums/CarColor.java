package com.dev.rev.prova.Enums;

import lombok.Getter;

import java.io.Serializable;

@Getter
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

    private final String cor;

    private CarColor(String color) {
        this.cor = color;
    }

    @Override
    public String toString() {
        return this.cor;
    }


}
