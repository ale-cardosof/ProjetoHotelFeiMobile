package com.example.alexandrecardoso.projetohotelfei.Classes;

import java.util.ArrayList;

public class Hotel {
    private String nome;
    private ArrayList<Quarto> quartos = new ArrayList();
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

    // Adiciona um Quarto
    boolean insereQuarto(Quarto newQuarto){
        if(numQuartosExistentes < capacidade){
            quartos.add(newQuarto);
            numQuartosExistentes++;
            return true;
        }return false;
    }

    // Verifica se um número de porta já existe
    public boolean verificaExistenciaPorta(int numPorta){
        for(int i=0; i < numQuartosExistentes; i++){
            if(quartos.get(i).getNumPorta() == numPorta){
                return true; // Retorna true, sinalizando que existe aquele número.
            }
        }return false; // Retorna false, sinalizando que existe aquele número.
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
