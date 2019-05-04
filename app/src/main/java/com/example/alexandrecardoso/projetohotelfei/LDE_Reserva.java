package com.example.alexandrecardoso.projetohotelfei;

import android.util.Log;

public class LDE_Reserva extends LDE {
/*
    private NoLDE_Reserva noPrim; // Primeiro No da LDE
    private int tam; // tamanho da LDE

    //Construtor que define as inicia as variaveis da LDE
    public LDE_Reserva() {
        noPrim = new NoLDE_Reserva();
        tam = 0;
    }

    //Insere um No à LDE a partir do Objeto recebido
    void insere(Reserva valor) {
        NoLDE_Reserva noAtual = new NoLDE_Reserva();
        noAtual.setValor(valor);

        NoLDE_Reserva noProx = noPrim;
        NoLDE_Reserva noAnt = null;
        while (noProx != null) {
            noAnt = noProx;
            noProx = noProx.getProx();
        }
        noAnt.setProx(noAtual);
        if (noAnt != null) {
        } else {
            noPrim = noAtual;
        }
        tam++;
    }

    // Retorna um objeto pelo indice
    Reserva getByIndex(int i) { ;
        NoLDE_Reserva noAtual = noPrim;
        int iAtual = 0;
        while (noAtual != null) {
            if (i == iAtual) {
                return noAtual.getValor();
            }
            else if (iAtual > i) {
                return null;
            }
            noAtual = noAtual.getProx();
            iAtual++;
        }
        return null;
    }

    NoLDE_Reserva getByValor(Reserva noBusca) {
        NoLDE_Reserva noAtual = noPrim;
        Log.d("HASH", "" + "Busca" + noBusca.getIdReserva());

        while (noAtual != null) {
            Log.d("HASH", "" + "Busca noAtual" +noAtual.getValor().getIdReserva());
            if (noBusca == noAtual.getValor())
                return noAtual;
            noAtual = noAtual.getProx();
        }
        return null;
    }


    // Imprime no LogCat (Para testes)
    void imprime() {
        NoLDE_Reserva noAtual = noPrim;

        while (noAtual != null) {
            Log.d("NOLDE", "Valor" + noAtual.getValor());
            noAtual = noAtual.getProx();
        }
    }

    // Remove um No pelo indice
    boolean removeByIndex(int i) {
        if (i >= tam || i < 0)
            return false;

        NoLDE_Reserva noAtual = noPrim;
        NoLDE_Reserva noAnt = null;
        int iAtual = 0;
        while (noAtual != null) {
            if (i == iAtual) {
                if (noAnt != null)
                    noAnt.setProx(noAtual.getProx());
                else
                    noPrim = noAtual.getProx();
                noAtual = null;
                tam--;
                return true;
            }
            noAnt = noAtual;
            noAtual = noAtual.getProx();
            iAtual++;
        }
        return false;
    }

    boolean removeByNo(Reserva noRemove) {

        NoLDE_Reserva noAtual = noPrim;
        NoLDE_Reserva noAnt = null;

        while (noAtual != null) {
            if (noRemove == noAtual.getValor()) {
                if (noAnt != null)
                    noAnt.setProx(noAtual.getProx());
                else
                    noPrim = noAtual.getProx();
                noAtual = null;
                tam--;
                return true;
            }
            noAnt = noAtual;
            noAtual = noAtual.getProx();
        }
        return false;
    }

    // retorna o tamanho da funcao
    int getSize(){
        return tam;
    }*/
}
