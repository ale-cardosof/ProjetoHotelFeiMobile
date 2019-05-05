package com.example.alexandrecardoso.projetohotelfei.Estruturas_;

class No<T>{
    T valor;
    No proximo;
    No anterior;

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }

    No(T valorNo){
        valor = valorNo;
        proximo = anterior = null;
    }
}

public class LDDE<T> {

    private No primeiro,ultimo;
    private int numeroNo;

    public No getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(No primeiro) {
        this.primeiro = primeiro;
    }

    public No getUltimo() {
        return ultimo;
    }

    public void setUltimo(No ultimo) {
        this.ultimo = ultimo;
    }

    public int getNumeroNo() {
        return numeroNo;
    }

    public void setNumeroNo(int numeroNo) {
        this.numeroNo = numeroNo;
    }

    LDDE(){
        primeiro = ultimo = null;
        numeroNo =0;
    }

    void insereNo(No novoNo){
        novoNo.setProximo(null);
        novoNo.setAnterior(ultimo);
        if(primeiro==null)
            primeiro = novoNo;
        if(ultimo!=null)
            ultimo.setProximo(novoNo);
        numeroNo++;
    }

    No buscarNoIndice(int indice){
        No tempNo = primeiro;
        for(int i =0; (i<indice) && tempNo !=null; i++)
            tempNo = tempNo.getProximo();
        return tempNo;
    }

    void excluirNoIndice(int indice){
        if(indice==0){
            primeiro = primeiro.getProximo();
            if(primeiro!= null)
                primeiro.setAnterior(null);
        }else{
            No tempNO = buscarNoIndice(indice);
            tempNO.getAnterior().setProximo(tempNO.getProximo());
            if(tempNO!= ultimo)
                tempNO.getProximo().setAnterior(tempNO.getAnterior());
            else
                ultimo = tempNO;
        }
        numeroNo++;
    }
}
