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
        noAtual.setValor(valor);

        NoLDE<T> noProx = noPrim;
        NoLDE<T> noAnt = null;

        while (noProx != null) {
            noAnt = noProx;
            noProx = noProx.getProxNo();
        }

        if (noAnt != null) {
            noAnt.setValor(valor);
        } else {
            noPrim = noAtual;
        }

        tam++;
    }

    // Retorna um objeto pelo indice
    NoLDE<T> getByNo(int i) {
        NoLDE<T> noAtual = noPrim;
        int iAtual = 0;
        while (noAtual != null) {
            if (i == iAtual)
                return noAtual;
            else if (iAtual > i)
                return null;
            noAtual = noAtual.getProxNo();
            iAtual++;
        }
        return null;
    }

    // Imprime no LogCat (Para testes)
    void imprime() {
        NoLDE<T> noAtual = noPrim;

        while (noAtual != null) {
            Log.d("NOLDE", "Valor" + noAtual.getValor());
            noAtual = noAtual.getProxNo();
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
                    noAnt.setProxNo(noAtual.getProxNo());
                else
                    noPrim = noAtual.getProxNo();
                noAtual = null;
                tam--;
                return true;
            }
            noAnt = noAtual;
            noAtual = noAtual.getProxNo();
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
                    noAnt.setProxNo(noAtual.getProxNo());
                else
                    noPrim = noAtual.getProxNo();
                noAtual = null;
                tam--;
                return true;
            }
            noAnt = noAtual;
            noAtual = noAtual.getProxNo();
        }
        return false;
    }

    // retorna o tamanho da funcao
    int getSize(){
        return tam;
    }
}