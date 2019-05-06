package com.example.alexandrecardoso.projetohotelfei.Classes;

public class Avaliacao {

    private float nota;
    private String titulo;
    private String mensagem;

    public Avaliacao(String titulo, float nota, String mensagem){
        this.nota = nota;
        this.mensagem = mensagem;
        this.titulo = titulo;
    }

    public float getNota() {
        return nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }


}
