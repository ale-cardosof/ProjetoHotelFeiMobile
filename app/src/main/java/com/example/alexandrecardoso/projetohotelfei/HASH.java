package com.example.alexandrecardoso.projetohotelfei;

public class HASH{
    // Vetor em que cada posição é uma LDE diferente
    public LDE<Integer> vetorHash[];
    public int numInseridos;
    public int MAX;

    // Construtor
    public HASH(int MAX){
        vetorHash = (LDE<Integer>[]) new Object[MAX];
        this.numInseridos = 0;
        this.MAX = MAX;
    }

    // Função Insere
    boolean insere(int x){
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
    int hash(int x){
        return ( x % MAX);
    }

    // Função Imprime
    void imprime(){
        System.out.println("---- My Hash Table ---- ");
        for(int i=0 ; i < MAX ; i++){
            vetorHash[i].imprime();
        }
        System.out.println("---- Finish ---- ");
    }

    // Função Busca
    NoLDE<Integer> busca(int x){
        int posicaoHash = this.hash(x);
        return (vetorHash[posicaoHash].getByValor(x)); // Busca pelo valor e traz No
    }

    // Função Remove
    boolean remove(int x){
        int posicaoHash = this.hash(x);
        return (vetorHash[posicaoHash].removeByNo(x)); // Remove pelo valor e retorna int
    }

};