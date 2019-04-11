package com.example.alexandrecardoso.projetohotelfei;

abstract public class Pessoa {
    private String username;
    private String nome;
    private int cpf;
    private String dataNascimento;
    private String email;
    private String celular;
    private String senha;

    public Pessoa(String username, String nome, int cpf, String dataNascimento, String email, String celular, String senha) {
        this.username = username;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.celular = celular;
        this.senha = senha;
    }
}
