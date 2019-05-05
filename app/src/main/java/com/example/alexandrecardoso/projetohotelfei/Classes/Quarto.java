package com.example.alexandrecardoso.projetohotelfei.Classes;

import android.graphics.Bitmap;

import com.example.alexandrecardoso.projetohotelfei.Classes.Avaliacao;
import com.example.alexandrecardoso.projetohotelfei.Estruturas_.LDE;

public class Quarto {
    private int numPorta; // Chave
    private double valorDiaria;
    private float mediaAvaliacao = -1;
    private int qntdCamas;
    private int qntdChuveiros;
    private boolean possuiTv;
    private int status; // 0 - Desocupado, 1 - Pré-Reservado, 2 - Reservado
    private int diasReservado; // Dias de reserva
    private int imagemQuarto; // Estudar maneira de armazenar a imagem do quarto
    private LDE<Avaliacao> ldeAvaliacoes = new LDE<>();
    private Bitmap teste[] = new Bitmap[5];

    //private Imagens fotos;

    public Quarto(){
        // SÓ PARA TESTES
    }
    public Quarto(int numeroPorta, double valorDiaria, int qntdCamas, int qntdChuveiro, boolean possuiTv) {
        this.numPorta = numeroPorta;
        this.valorDiaria = valorDiaria;
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

    private float calculaMedia(){
        float media = 0;
        int nAval = ldeAvaliacoes.getSize();
        for(int i = 0; i < nAval; i++ ){
            media += ldeAvaliacoes.getByIndex(i).getNota();
        }
        return media/nAval;
    }

    public double getMediaAvaliacao() {
        return mediaAvaliacao;
    }

    public LDE<Avaliacao> getAvaliacoes() {
        return ldeAvaliacoes;
    }

    public void setAvaliacoes(Avaliacao avaliacao) {
        this.ldeAvaliacoes.insere(avaliacao);
        mediaAvaliacao = calculaMedia();
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



    public void adicionaImagem(Bitmap foto, int position) {
        //imagensQuarto.get(position);
        this.teste[position] = foto;
    }

    public Bitmap retornaImagem(int position){

        //return this.imagensQuarto.get(position);
        return  this.teste[position];
    }


}
