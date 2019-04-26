package com.example.alexandrecardoso.projetohotelfei;

public class Quarto {
    private int numPorta; // Chave
    private double valorDiaria;
    private double avaliacao;
    private int qntdCamas;
    private int qntdChuveiros;
    private boolean possuiTv;
    private int status; // 0 - Desocupado, 1 - Pré-Reservado, 2 - Reservado
    private int diasReservado; // Dias de reserva
    private int imagemQuarto; // Estudar maneira de armazenar a imagem do quarto
    //private Imagens fotos;

    public Quarto(){

    }
    public Quarto(int numeroPorta, double valorDiaria, int qntdCamas, int qntdChuveiro, boolean possuiTv) {
        this.numPorta = numeroPorta;
        this.valorDiaria = valorDiaria;
        this.avaliacao = -1; // -1 Representa sem avaliações
        this.qntdCamas = qntdCamas;
        this.qntdChuveiros = qntdChuveiro;
        this.possuiTv = possuiTv;
        this.status = 0;
        this.diasReservado = 0;
    }

    public int getImagemQuarto() {
        return imagemQuarto;
    }

    public void setImagemQuarto(int imagemQuarto) {
        this.imagemQuarto = imagemQuarto;
    }
    /*
    public boolean adicionarImagem(int referencia){
        fotos.getReferencias().insere(referencia);
        return true;
    }

    public boolean removerImagem(int referencia){
        fotos.getReferencias().removeN(referencia);
        return true;
    }*/

    public int getNumPorta() {
        return numPorta;
    }

    public void setNumPorta(int numPorta) {
        this.numPorta = numPorta;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public int getQntdCamas() {
        return qntdCamas;
    }

    public void setQntdCamas(int qntdCamas) {
        this.qntdCamas = qntdCamas;
    }

    public int getQntdChuveiros() {
        return qntdChuveiros;
    }

    public void setQntdChuveiros(int qntdChuveiros) {
        this.qntdChuveiros = qntdChuveiros;
    }

    public boolean isPossuiTv() {
        return possuiTv;
    }

    public void setPossuiTv(boolean possuiTv) {
        this.possuiTv = possuiTv;
    }
}
