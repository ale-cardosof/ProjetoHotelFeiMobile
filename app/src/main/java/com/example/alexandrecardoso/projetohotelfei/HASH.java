package com.example.alexandrecardoso.projetohotelfei;

import android.text.format.DateFormat;

public class HASH{
    // Vetor em que cada posição é uma LDE diferente
    //public LDE_Reserva[] vetorHash = new LDE_Reserva[31];
    private int MAX = 31;
    public NoLDE_Reserva vetorHash[] = new NoLDE_Reserva[MAX];
    public int numInseridos;

    // Construtor
    public HASH(){
        for(int i = 0; i < MAX; i++)
           vetorHash[i] = new NoLDE_Reserva();

        this.numInseridos = 0;
    }

    // Função Insere
    boolean insere(Reserva x){
        if (numInseridos < MAX){
            // Função Hash
            int posicao = this.hash(x);
            // Inserção
            vetorHash[posicao].insere(x);
            numInseridos++;
            return true;
        }else{
            return false;
        }
    }

    // Função Hash
    int hash(Reserva x){
        int dia  = Integer.parseInt((String)DateFormat.format("dd", x.getDtEntrada()));
        return ( dia % MAX);
    }

    // Função Busca
    NoLDE_Reserva busca(Reserva x){
        int posicaoHash = this.hash(x);
        return (vetorHash[posicaoHash].getByValor(x)); // Busca pelo valor e traz No
    }

    Reserva buscaById(int id){
        for(int i = 0; i < MAX; i++){
            Reserva reserAux = vetorHash[i].buscaById(id);
            if (reserAux != null)
                return reserAux;
        }
        return null; // Busca pelo valor e traz No
    }

    // Função Remove
    boolean remove(Reserva x){
        int posicaoHash = this.hash(x);
        return (vetorHash[posicaoHash].removeByNo(x)); // Remove pelo valor e retorna int
    }

    NoLDE_Reserva imprimeTodasReservas(){
        NoLDE_Reserva listaReserva = new NoLDE_Reserva();
        for(int i = 0; i < MAX; i++){
            NoLDE_Reserva reserAux = vetorHash[i];
            while (reserAux != null){
                if (reserAux.getValor() != null)
                    listaReserva.insere(reserAux.getValor());
                reserAux = reserAux.getProx();
            }
        }
        return listaReserva; // Busca pelo valor e traz No
    }
};