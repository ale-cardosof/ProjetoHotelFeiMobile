package com.example.alexandrecardoso.projetohotelfei;

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

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
