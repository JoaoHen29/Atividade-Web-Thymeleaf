package com.example.demo.model;

import java.util.List;

// Representa um projeto exibido na seção "Projetos" do portfólio
public class Projeto {

    private String titulo;
    private String descricao;
    private String categoria;
    private List<String> tecnologias;
    private String link;

    public Projeto(String titulo, String descricao, String categoria, List<String> tecnologias, String link) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.tecnologias = tecnologias;
        this.link = link;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public List<String> getTecnologias() {
        return tecnologias;
    }

    public String getLink() {
        return link;
    }
}
