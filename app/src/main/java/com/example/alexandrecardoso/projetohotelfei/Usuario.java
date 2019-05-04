package com.example.alexandrecardoso.projetohotelfei;

// Implementar Futuramente
public class Usuario extends Pessoa {

    private LDE<Reserva> ldeMinhasReservas = new LDE<>();
    // Construtor

    public Usuario() {
    }

    public Usuario(String username, String nome, String cpf, String dataNascimento, String email, String celular, String senha) {
        super(username, nome, cpf, dataNascimento, email, celular, senha);
    }

    public LDE<Reserva> getMinhasReservas() {
        return ldeMinhasReservas;
    }

    public Reserva getMinhasReservas(int posicao) {
        return ldeMinhasReservas.getByIndex(posicao);
    }

    public void setMinhasReservas(Reserva novaReserva) {
        this.ldeMinhasReservas.insere(novaReserva);
    }
}
