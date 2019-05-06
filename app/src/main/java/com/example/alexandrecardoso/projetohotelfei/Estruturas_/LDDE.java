package com.example.alexandrecardoso.projetohotelfei.Estruturas_;

class No<T>{
    T valor;
    No<T> proximo;
    No<T> anterior;

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public No<T> getProximo() {
        return proximo;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }

    public No<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(No<T> anterior) {
        this.anterior = anterior;
    }

    No(T valorNo){
        valor = valorNo;
        proximo = anterior = null;
    }
}

public class LDDE<T> {

    private No<T> primeiro,ultimo;
    private int numeroNo;

    public No<T> getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(No<T> primeiro) {
        this.primeiro = primeiro;
    }

    public No<T> getUltimo() {
        return ultimo;
    }

    public void setUltimo(No<T> ultimo) {
        this.ultimo = ultimo;
    }

    public int getNumeroNo() {
        return numeroNo;
    }

    public void setNumeroNo(int numeroNo) {
        this.numeroNo = numeroNo;
    }

    public LDDE(){
        primeiro = ultimo = null;
        numeroNo =0;
    }

    public void insereNo(T valor){
        No<T> novoNo = new No(valor);
        novoNo.setProximo(null);
        novoNo.setAnterior(ultimo);
        if(primeiro==null)
            primeiro = novoNo;
        if(ultimo!=null)
            ultimo.setProximo(novoNo);
        numeroNo++;
    }

    public T buscarNoIndice(int indice){
        No tempNo = primeiro;
        for(int i =0; (i<indice) && tempNo !=null; i++)
            tempNo = tempNo.getProximo();

        return (T)tempNo.getValor();
    }

    public void excluirNoIndice(int indice){
        if(indice==0){
            primeiro = primeiro.getProximo();
            if(primeiro!= null)
                primeiro.setAnterior(null);
        }else{
            No<T> tempNO = new No<T>(buscarNoIndice(indice));
            tempNO.getAnterior().setProximo(tempNO.getProximo());
            if(tempNO!= ultimo)
                tempNO.getProximo().setAnterior(tempNO.getAnterior());
            else
                ultimo = tempNO;
        }
        numeroNo++;
    }
}
