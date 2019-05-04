package com.example.alexandrecardoso.projetohotelfei;

// Implementar Futuramente
public class Usuario extends Pessoa {
    private Usuario pai;
    private Usuario esquerda; // Usados na árvore
    private Usuario direita;
    private LDE<Reserva> ldeMinhasReservas = new LDE<>();
    // Construtor

    public Usuario() {
    }

    public Usuario(String username, String nome, String cpf, String dataNascimento, String email, String celular, String senha) {
        super(username, nome, cpf, dataNascimento, email, celular, senha);
        pai = null;
        esquerda = null;
        direita = null;
    }

    public LDE<Reserva> getMinhasReservas() {
        return ldeMinhasReservas;
    }

    public void copiaUser(Usuario clone){
        this.setUsername(clone.getUsername());
        this.setNome(clone.getNome());
        this.setCpf(clone.getCpf());
        this.setDataNascimento(clone.getDataNascimento());
        this.setEmail(clone.getEmail());
        this.setCelular(clone.getCelular());
        this.setSenha(clone.getSenha());
        this.setUsernameASC(clone.getUsernameASC());

    }


    public void setMinhasReservas(Reserva novaReserva) {
        this.ldeMinhasReservas.insere(novaReserva);
    }

    public Usuario getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Usuario esquerda) {
        this.esquerda = esquerda;
    }

    public Usuario getDireita() {
        return direita;
    }

    public void setDireita(Usuario direita) {
        this.direita = direita;
    }

    public Usuario getPai() {
        return pai;
    }

    public void setPai(Usuario pai) {
        this.pai = pai;
    }
}
