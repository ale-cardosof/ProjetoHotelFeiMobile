package com.example.alexandrecardoso.projetohotelfei.Estruturas_;

import android.util.Log;

//Estrutura de dado LDE
public class LDE<T> {

    private NoLDE<T> noPrim; // Primeiro No da LDE
    private int tam; // tamanho da LDE

    //Construtor que define as inicia as variaveis da LDE
    public LDE() {
        noPrim = null;
        tam = 0;
    }

    //Insere um No à LDE a partir do Objeto recebido
    public void insere(T valor) {
        NoLDE<T> noAtual = new NoLDE<>();
        noAtual.setValor(valor);

        NoLDE<T> noProx = noPrim;
        NoLDE<T> noAnt = null;

        while (noProx != null) {
            noAnt = noProx;
            noProx = noProx.getProx();
        }

        if (noAnt != null) {
            noAnt.setProx(noAtual);
        } else {
            noPrim = noAtual;
        }

        tam++;
    }

    // Retorna um objeto pelo indice
    public T getByIndex(int i) {
        NoLDE<T> noAtual = noPrim;
        int iAtual = 0;
        while (noAtual != null) {
            if (i == iAtual)
                return noAtual.getValor();
            else if (iAtual > i)
                return null;
            noAtual = noAtual.getProx();
            iAtual++;
        }
        return null;
    }

    public NoLDE<T> getByValor(T noBusca) {
        NoLDE<T> noAtual = noPrim;
        while (noAtual != null) {
            if (noBusca == noAtual.getValor())
                return noAtual;
            noAtual = noAtual.getProx();
        }
        return null;
    }


    // Imprime no LogCat (Para testes)
    public void imprime() {
        NoLDE<T> noAtual = noPrim;

        while (noAtual != null) {
            Log.d("NOLDE", "Valor" + noAtual.getValor());
            noAtual = noAtual.getProx();
        }
    }

    // Remove um No pelo indice
    public boolean removeByIndex(int i) {
        if (i >= tam || i < 0)
            return false;

        NoLDE<T> noAtual = noPrim;
        NoLDE<T> noAnt = null;
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

    public boolean removeByNo(T noRemove) {

        NoLDE<T> noAtual = noPrim;
        NoLDE<T> noAnt = null;

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


    // retorna o primeiro no No da LDE
    NoLDE<T> getPrimeiroNo(){
        return noPrim;
    }

    // retorna o tamanho da funcao
    public int getSize(){
        return tam;
    }
}