package com.springcurso.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class User {

    private Long id;

    private String nome;

    private String sobrenome;

    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private LocalDate dtNascimento;

    public User() {
    }

    public User(Long id, String nome, String sobrenome) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public User(Long id, String nome, String sobrenome, LocalDate dtNascimento) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dtNascimento = dtNascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }


    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }
}
