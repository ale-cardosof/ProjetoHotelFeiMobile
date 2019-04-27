package com.example.alexandrecardoso.projetohotelfei;

import android.util.Log;

// Fila Generica
public class Fila<T>  {

    public int i; // inicio da Fila
    public int f; // indice de preenchimento do vetor
    public int MAX; // Tamanho da Fila
    public T v[]; // Vetor Generico

    // Construtor da Fila
    // Parametros : MAX = Tamanho da Fila
    public Fila(int MAX) {
        v = (T[])new Object[MAX];
        i = 0;
        f = 0;
        this.MAX = MAX;
    }

    // Enfileira um novo numero caso f não seja igual ao i (Lista Cheia)
    // Parametros : x = Conteudo a ser enfileirado
    public boolean enfileira(T x){
        if(((f + 1) % MAX) == i)
            return false;
        v[f] = x;
        f = (f + 1) % MAX;
        return true;
    }
    // Desenfileira caso f não seja igual ao i (Lista Vazia)
    // Parametros : x = Conteudo a ser enfileirado
    public boolean desenfileira(){
        if(i == f)
            return false;
        i = (i + 1) % MAX;
        return true;
    }

    // Imprime a Fila completa
    public void imprime(){
        int x;
        for(x = i; x != f; x = (x+1) % MAX){
            String TAG = "Fila Class";
            Log.d(TAG, "v["+x+"] = " + v[x]);
        }
    }

    // Define i e f = 0 (Lista vazia)
    public void limpa(){
        i = f = 0;
    }
}
