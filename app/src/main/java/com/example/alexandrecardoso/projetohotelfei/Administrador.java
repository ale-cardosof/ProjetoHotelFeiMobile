package com.example.alexandrecardoso.projetohotelfei;

import java.util.ArrayList;

public class Administrador extends Pessoa {
    /* Atributos */
    private Hotel meuHotel = new Hotel(20);

    /* Métodos */
    // 0. Construtor
    public Administrador(String username, String nome, String cpf, String dataNascimento, String email, String celular, String senha) {
        super( username, nome, cpf, dataNascimento, email, celular, senha);
    }
    // 1. Cria Quarto
    Quarto criaQuarto(int numeroPorta, double valorDiaria, int qntdCamas, int qntdChuveiro, boolean possuiTv){
        Quarto novoQuarto = new Quarto(numeroPorta,valorDiaria,qntdCamas,qntdChuveiro,possuiTv);
        return novoQuarto;
    }
    // 2. Insere novo Quarto
    ArrayList<Integer> insereQuarto(int numeroPorta, double valorDiaria, int qntdCamas, int qntdChuveiro, boolean possuiTv){
        ArrayList<Integer> erros = new ArrayList(); // Vetor de Erros
        // Verifica se o numero de Porta escolhido já existe
        if(meuHotel.verificaExistenciaPorta(numeroPorta)){
            erros.add(1); // Erro 1: Sinaliza que ocorreu erro no número de Porta
        }else{
            // Caso o número de porta não exista, criamos o quarto.
            Quarto novoQuarto = criaQuarto(numeroPorta,valorDiaria,qntdCamas,qntdChuveiro,possuiTv);
            if(meuHotel.insereQuarto(novoQuarto)){
                // Quarto inserido com sucesso
            }else{
                erros.add(2); // Erro 2: Sinaliza que ocorreu erro na capacidade do quarto
            }
        }
        return erros; // Retorna um vetor de erros, assim, podemos empilhar vários sinalizadores
    }
    // 3. Retorna Hotel
    public Hotel getMeuHotel() {
        return meuHotel;
    }
    // 4. Exibe Solicitações
    void exibeSolicita(){

    }

}
