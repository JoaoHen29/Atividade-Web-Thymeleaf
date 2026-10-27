package com.example.demo.model;

import java.util.List;

// Representa um grupo de habilidades (ex.: Back-end -> Java, Spring Boot...)
public class Habilidade {

    private String categoria;
    private List<String> itens;

    public Habilidade(String categoria, List<String> itens) {
        this.categoria = categoria;
        this.itens = itens;
    }

    public String getCategoria() {
        return categoria;
    }

    public List<String> getItens() {
        return itens;
    }
}
