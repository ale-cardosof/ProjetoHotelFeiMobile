package com.example.alexandrecardoso.projetohotelfei;

public class Avaliacao {

    private double nota;
    private String titulo;
    private String mensagem;

    public Avaliacao(String titulo, double nota, String mensagem){
        this.nota = nota;
        this.mensagem = mensagem;
        this.titulo = titulo;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
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
