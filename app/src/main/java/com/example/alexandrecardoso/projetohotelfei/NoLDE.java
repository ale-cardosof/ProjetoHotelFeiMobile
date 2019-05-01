package com.example.alexandrecardoso.projetohotelfei;

public class NoLDE <T> {

    private T valor;
    private NoLDE<T> prox;

    public NoLDE() {
        this.valor = null;
        this.prox = null;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public NoLDE<T> getProx() {
        return prox;
    }

    public void setProx(NoLDE<T> prox) {
        this.prox = prox;
    }
}
