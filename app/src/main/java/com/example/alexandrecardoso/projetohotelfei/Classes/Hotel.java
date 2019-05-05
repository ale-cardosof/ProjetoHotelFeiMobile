package com.example.alexandrecardoso.projetohotelfei.Classes;

import com.example.alexandrecardoso.projetohotelfei.Estruturas_.LDE;

import java.util.ArrayList;

public class Hotel {
    private String nome;
    public  LDE<Quarto> quartos = new LDE<>();
    private int capacidade;
    private int numQuartosExistentes;
    private int numQuartosDisponiveis;
    private int numQuartosPreReservados;
    private int numQuartosReservados;
    // Construtor
    public Hotel(int capacidade){
        this.capacidade = capacidade;
        numQuartosExistentes = 0;
        numQuartosReservados = 0;
        numQuartosPreReservados = 0;
        numQuartosDisponiveis = 0;
    }

    public LDE<Quarto> getQuartos(){
        return quartos;
    }

    public void setQuartos (Quarto novoQuarto){
        this.quartos.insere(novoQuarto);
        Estruturas.ldeQuartos.insere(novoQuarto);
    }


    public int getNumQuartosExistentes() {
        return numQuartosExistentes;
    }
    public int getNumQuartosDisponiveis() {
        return numQuartosDisponiveis;
    }
    public int getNumQuartosPreReservados() {
        return numQuartosPreReservados;
    }
    public int getNumQuartosReservados() {
        return numQuartosReservados;
    }
}
