package com.example.alexandrecardoso.projetohotelfei.Classes;

import android.util.Log;

import java.util.ArrayList;

public class Administrador extends Pessoa {
    /* Atributos */
    private Administrador pai;
    private Administrador esquerda;
    private Administrador direita;

    /* Métodos */
    // 0. Construtor
    public Administrador(String username, String nome, String cpf, String dataNascimento, String email, String celular, String senha) {
        super( username, nome, cpf, dataNascimento, email, celular, senha);
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

}
