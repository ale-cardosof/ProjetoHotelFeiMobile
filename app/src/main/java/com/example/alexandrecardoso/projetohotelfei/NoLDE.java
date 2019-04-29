package com.example.alexandrecardoso.projetohotelfei;

public class NoLDE <T> {

    T valor;
    NoLDE<T> prox;

    public NoLDE() {
        this.valor = null;
        this.prox = null;
    }
}
