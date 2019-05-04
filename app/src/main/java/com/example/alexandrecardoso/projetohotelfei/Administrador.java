package com.example.alexandrecardoso.projetohotelfei;

import android.util.Log;

import java.util.ArrayList;

public class Administrador extends Pessoa {
    /* Atributos */
    private Administrador pai;
    private Administrador esquerda; // Usados na árvore
    private Administrador direita;
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

    public Administrador getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Administrador esquerda) {
        this.esquerda = esquerda;
    }

    public Administrador getDireita() {
        return direita;
    }

    public void setDireita(Administrador direita) {
        this.direita = direita;
    }

    public Administrador getPai() {
        return pai;
    }

    public void setPai(Administrador pai) {
        this.pai = pai;
    }

    public void copiaUser(Administrador clone){
        this.setUsername(clone.getUsername());
        this.setNome(clone.getNome());
        this.setCpf(clone.getCpf());
        this.setDataNascimento(clone.getDataNascimento());
        this.setEmail(clone.getEmail());
        this.setCelular(clone.getCelular());
        this.setSenha(clone.getSenha());
        this.setUsernameASC(clone.getUsernameASC());

    }

    // Fila Generica
    public static class Fila<T>  {

        public int i; // inicio da Fila
        public int f; // indice de preenchimento do vetor
        public int MAX; // Tamanho da Fila
        public T v[]; // Vetor Generico

        // Construtor da Fila
        // Parametros : MAX = Tamanho da Fila
        public Fila(int MAX) {
            v = (T[])new Object[MAX];
            i = 0;
            f = 0;
            this.MAX = MAX;
        }

        // Enfileira um novo numero caso f não seja igual ao i (Lista Cheia)
        // Parametros : x = Conteudo a ser enfileirado
        public boolean enfileira(T x){
            if(((f + 1) % MAX) == i)
                return false;
            v[f] = x;
            f = (f + 1) % MAX;
            return true;
        }
        // Desenfileira caso f não seja igual ao i (Lista Vazia)
        // Parametros : x = Conteudo a ser enfileirado
        public boolean desenfileira(){
            if(i == f)
                return false;
            i = (i + 1) % MAX;
            return true;
        }

        // Imprime a Fila completa
        public void imprime(){
            int x;
            for(x = i; x != f; x = (x+1) % MAX){
                String TAG = "Fila Class";
                Log.d(TAG, "v["+x+"] = " + v[x]);
            }
        }

        // Define i e f = 0 (Lista vazia)
        public void limpa(){
            i = f = 0;
        }
    }
}
