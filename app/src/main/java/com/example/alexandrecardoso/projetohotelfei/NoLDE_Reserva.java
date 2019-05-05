package com.example.alexandrecardoso.projetohotelfei;

public class NoLDE_Reserva {

    private Reserva valor;
    private No<Reserva> prox;
    private No<Reserva>  noPrim;
    private int tam;

    public NoLDE_Reserva() {
        this.valor = null;
        this.prox = null;
        this.noPrim = null;
        valor = null;
    }

    public Reserva getValor() {
        return valor;
    }

    public void setValor(Reserva valor) {
        this.valor = valor;
    }

    public No<Reserva>  getProx() {
        return prox;
    }

    public void setProx(No<Reserva>  prox) {
        this.prox = prox;
    }


    //Insere um No à LDE a partir do Objeto recebido
    void insereNo(Reserva valor) {
        No<Reserva>  noAtual = new No<>(valor);
        noAtual.setValor(valor);

        No<Reserva>  noProx = noPrim;
        No<Reserva>  noAnt = null;

        while (noProx != null) {
            noAnt = noProx;
            noProx = noProx.getProximo();
        }
        if (noAnt != null) {
            noAnt.setProximo(noAtual);
        } else {
            noPrim = noAtual;
        }
        tam++;
    }

    // Retorna um objeto pelo indice
    No<Reserva> getByIndex(int i) { ;
        No<Reserva> noAtual = noPrim;
        int iAtual = 0;
        while (noAtual != null) {
            if (i == iAtual) {
                return noAtual;
            }
            else if (iAtual > i) {
                return null;
            }
            noAtual = noAtual.getProximo();
            iAtual++;
        }
        return null;
    }

    Reserva buscaById(int id){
        No<Reserva> noAux = noPrim;
            while(noAux != null){
                if(noAux.getValor().getIdReserva() == id)
                    return noAux.getValor();
                noAux = noAux.getProximo();
            }
        return null; // Busca pelo valor e traz No
    }

    Reserva getByValor(Reserva noBusca) {
        No<Reserva> noAtual = noPrim;
        while (noAtual != null) {
            if (noBusca == noAtual.getValor())
                return noAtual.getValor();
            noAtual = noAtual.getProximo();
        }
        return null;
    }


    // Remove um No pelo indice
    boolean removeByIndex(int i) {
        if (i >= tam || i < 0)
            return false;

        No<Reserva> noAtual = noPrim;
        No<Reserva> noAnt = null;
        int iAtual = 0;
        while (noAtual != null) {
            if (i == iAtual) {
                if (noAnt != null)
                    noAnt.setProximo(noAtual.getProximo());
                else
                    noPrim = noAtual.getProximo();
                noAtual = null;
                tam--;
                return true;
            }
            noAnt = noAtual;
            noAtual = noAtual.getProximo();
            iAtual++;
        }
        return false;
    }

    boolean removeByNo(Reserva noRemove) {

        No<Reserva> noAtual = noPrim;
        No<Reserva> noAnt = null;

        while (noAtual != null) {
            if (noRemove == noAtual.getValor()) {
                if (noAnt != null)
                    noAnt.setProximo(noAtual.getProximo());
                else
                    noPrim = noAtual.getProximo();
                noAtual = null;
                tam--;
                return true;
            }
            noAnt = noAtual;
            noAtual = noAtual.getProximo();
        }
        return false;
    }

    // retorna o tamanho da funcao
    int getSize(){
        return tam;
    }
}
