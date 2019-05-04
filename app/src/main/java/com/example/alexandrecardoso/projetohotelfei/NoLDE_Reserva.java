package com.example.alexandrecardoso.projetohotelfei;

public class NoLDE_Reserva {

    private Reserva valor;
    private NoLDE_Reserva prox;
    private NoLDE_Reserva noPrim;
    private int tam;
    public NoLDE_Reserva() {
        this.valor = null;
        this.prox = null;
        this.noPrim = null;
    }

    public Reserva getValor() {
        return valor;
    }

    public void setValor(Reserva valor) {
        this.valor = valor;
    }

    public NoLDE_Reserva getProx() {
        return prox;
    }

    public void setProx(NoLDE_Reserva prox) {
        this.prox = prox;
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
        if (noAnt != null) {
            noAnt.setProx(noAtual);
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

    Reserva buscaById(int id){
            NoLDE_Reserva noAux = noPrim;
            while(noAux != null){
                if(noAux.getValor().getIdReserva() == id)
                    return noAux.getValor();
                noAux = noAux.getProx();
            }
        return null; // Busca pelo valor e traz No
    }

    NoLDE_Reserva getByValor(Reserva noBusca) {
        NoLDE_Reserva noAtual = noPrim;
        while (noAtual != null) {
            if (noBusca == noAtual.getValor())
                return noAtual;
            noAtual = noAtual.getProx();
        }
        return null;
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
    }
}
