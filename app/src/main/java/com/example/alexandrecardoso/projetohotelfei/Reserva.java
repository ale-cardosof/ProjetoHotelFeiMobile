package com.example.alexandrecardoso.projetohotelfei;

import java.util.Date;

public class Reserva {

    private Date dtEntrada, dtSaida;
    private double valor;
    private Quarto quartoReserva;
    private boolean avaliada;
    private static int IDRESERVA = 0;
    private int idReserva = 0;
    private String usuario;
    private boolean checkin = false;
    private boolean checkout = false;

    public Reserva(){

    }

    public Reserva(String usuario, Date dtEntrada,Date dtSaida, Quarto quartoReserva, double valor){
        this.dtEntrada = dtEntrada;
        this.dtSaida = dtSaida;
        this.quartoReserva = quartoReserva;
        this.valor = valor;
        this.usuario = usuario;
        this.idReserva = IDRESERVA++;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getDtEntrada() {
        return dtEntrada;
    }

    public int getIdReserva() {
        return idReserva;
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

    public boolean isCheckin() {
        return checkin;
    }

    public void setCheckin(boolean checkin) {
        this.checkin = checkin;
    }

    public boolean isCheckout() {
        return checkout;
    }

    public void setCheckout(boolean checkout) {
        this.checkout = checkout;
    }
}
