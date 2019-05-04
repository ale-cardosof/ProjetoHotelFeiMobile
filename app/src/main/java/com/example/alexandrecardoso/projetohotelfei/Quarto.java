package com.example.alexandrecardoso.projetohotelfei;

public class Quarto {
    private int numPorta; // Chave
    private double valorDiaria;
    private int qntdCamas;
    private int qntdChuveiros;
    private boolean possuiTv;
    private int status; // 0 - Desocupado, 1 - Pré-Reservado, 2 - Reservado
    private int diasReservado; // Dias de reserva
    private int imagemQuarto; // Estudar maneira de armazenar a imagem do quarto
    private LDE<Avaliacao> ldeAvaliacoes = new LDE<>();

    //private Imagens fotos;

    public Quarto(){
        // SÓ PARA TESTES
        addAvaliacoes();
    }
    public Quarto(int numeroPorta, double valorDiaria, int qntdCamas, int qntdChuveiro, boolean possuiTv) {
        this.numPorta = numeroPorta;
        this.valorDiaria = valorDiaria;
        this.qntdCamas = qntdCamas;
        this.qntdChuveiros = qntdChuveiro;
        this.possuiTv = possuiTv;
        this.status = 0;
        this.diasReservado = 0;

        // SÓ PARA TESTES
        addAvaliacoes();
    }

    // SÓ PARA TESTES - REMOVERRR
    private void addAvaliacoes() {

        Avaliacao av = new Avaliacao("Otimo Quarto!", 5.0, "Otimo Quarto! Cabe toda a Familia, só os buscapés, nordestino sem dente.");
        ldeAvaliacoes.insere(av);
        av = new Avaliacao("Bom pra suruba!", 5.0, "Por que tudo depende do quanto voce quer comer alguém.");
        ldeAvaliacoes.insere(av);
        av = new Avaliacao("Sem spoiler", 1.0, "Thanos morre no final.");
        ldeAvaliacoes.insere(av);

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

    public LDE<Avaliacao> getAvaliacoes() {
        return ldeAvaliacoes;
    }

    public void setAvaliacoes(Avaliacao avaliacao) {
        this.ldeAvaliacoes.insere(avaliacao);
    }

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
