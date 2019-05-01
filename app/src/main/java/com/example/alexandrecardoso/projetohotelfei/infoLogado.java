package com.example.alexandrecardoso.projetohotelfei;
import static com.example.alexandrecardoso.projetohotelfei.menuUsuario.admsCadastrados;
public class infoLogado {
    // Diz em qual vetor devemos procura-lo
    public String username;
    public int tipoUser; // 0 - Deslogado, 1 - Adm, 2 - Usuario
    public int posicao; // Posição na referência

    public infoLogado(String username, int tipoUser, int posicao) {
        this.username = username;
        this.tipoUser = tipoUser;
        this.posicao = posicao;
    }

    public void atualizaPosicao(){
        posicao = admsCadastrados.buscaPos(this.username);
    }

    public void desloga(){
        this.username = "";
        this.tipoUser = 0;
        this.posicao = -1;
    }


}
