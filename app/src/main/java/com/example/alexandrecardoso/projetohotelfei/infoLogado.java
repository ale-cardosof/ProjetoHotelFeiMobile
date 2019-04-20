package com.example.alexandrecardoso.projetohotelfei;

public class infoLogado {
    // Diz em qual vetor devemos procura-lo
    public int tipoUser; // 0 - Deslogado, 1 - Adm, 2 - Usuario
    public int posicao;

    public infoLogado(int tipoUser, int posicao) {
        this.tipoUser = tipoUser;
        this.posicao = posicao;
    }
}
