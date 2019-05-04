package com.example.alexandrecardoso.projetohotelfei;


public class infoLogado {
    // Diz em qual vetor devemos procura-lo
    public Pessoa user;
    public String username;
    public Long usernameASC;
    public int tipoUser; // 0 - Deslogado, 1 - Adm, 2 - Usuario

    public infoLogado(String username, int tipoUser) {
        this.user = null;
        this.username = username;
        this.tipoUser = tipoUser;
    }

    public void desloga(){
        this.user = null;
        this.username = "";
        this.tipoUser = 0;
    }


}
