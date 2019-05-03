package com.example.alexandrecardoso.projetohotelfei;

import java.util.Date;

public class Reserva {

    private Date dtEntrada, dtSaida;
    private double valor;
    private Quarto quartoReserva;
    private boolean avaliada;

    public Reserva(Date dtEntrada,Date dtSaida, Quarto quartoReserva, double valor){
        this.dtEntrada = dtEntrada;
        this.dtSaida = dtSaida;
        this.quartoReserva = quartoReserva;
        this.valor = valor;
    }

    public Date getDtEntrada() {
        return dtEntrada;
    }

    public void setDtEntrada(Date dtEntrada) {
        this.dtEntrada = dtEntrada;
    }

    public Date getDtSaida() {
        return dtSaida;
    }

    public void setDtSaida(Date dtSaida) {
        this.dtSaida = dtSaida;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Quarto getQuartoReserva() {
        return quartoReserva;
    }

    public boolean isAvaliada() {
        return avaliada;
    }

    public void setAvaliada(boolean avaliada) {
        this.avaliada = avaliada;
    }

    public void setQuartoReserva(Quarto quartoReserva) {
        this.quartoReserva = quartoReserva;
    }
}
