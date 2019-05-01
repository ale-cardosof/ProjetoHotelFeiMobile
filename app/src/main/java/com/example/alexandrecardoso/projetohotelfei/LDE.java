package com.example.alexandrecardoso.projetohotelfei;

import android.util.Log;

//Estrutura de dado LDE
public class LDE<T> {

    private NoLDE<T> noPrim; // Primeiro No da LDE
    private int tam = 0; // tamanho da LDE

    //Construtor que define as inicia as variaveis da LDE
    public LDE() {
        noPrim = null;
        tam = 0;
    }

    //Insere um No à LDE a partir do Objeto recebido
    void insere(T valor) {
        NoLDE<T> noAtual = new NoLDE<>();
        noAtual.valor = valor;

        NoLDE<T> noProx = noPrim;
        NoLDE<T> noAnt = null;

        while (noProx != null) {
            noAnt = noProx;
            noProx = noProx.prox;
        }

        if (noAnt != null) {
            noAnt.prox = noAtual;
        } else {
            noPrim = noAtual;
        }

        tam++;
    }

    // Retorna um objeto pelo indice
    NoLDE<T> getByIndex(int i) {
        NoLDE<T> noAtual = noPrim;
        int iAtual = 0;
        while (noAtual != null) {
            if (i == iAtual)
                return noAtual;
            else if (iAtual > i)
                return null;
            noAtual = noAtual.prox;
            iAtual++;
        }
        return null;
    }

    // Imprime no LogCat (Para testes)
    void imprime() {
        NoLDE<T> noAtual = noPrim;

        while (noAtual != null) {
            Log.d("NOLDE", "Valor" + noAtual.valor);
            noAtual = noAtual.prox;
        }
    }

    // Remove um No pelo indice
    boolean removeByIndex(int i) {
        if (i >= tam || i < 0)
            return false;

        NoLDE<T> noAtual = noPrim;
        NoLDE<T> noAnt = null;
        int iAtual = 0;
        while (noAtual != null) {
            if (i == iAtual) {
                if (noAnt != null)
                    noAnt.prox = noAtual.prox;
                else
                    noPrim = noAtual.prox;
                noAtual = null;
                tam--;
                return true;
            }
            noAnt = noAtual;
            noAtual = noAtual.prox;
            iAtual++;
        }
        return false;
    }

    boolean removeByNo(NoLDE<T> noRemove){
        NoLDE<T> noAtual = noPrim;
        NoLDE<T> noAnt = null;
        while (noAtual != null) {
            if (noRemove == noAtual) {
                if (noAnt != null)
                    noAnt.prox = noAtual.prox;
                else
                    noPrim = noAtual.prox;
                noAtual = null;
                tam--;
                return true;
            }
            noAnt = noAtual;
            noAtual = noAtual.prox;
        }
        return false;
    }

    // retorna o tamanho da funcao
    int getSize(){
        return tam;
    }
}