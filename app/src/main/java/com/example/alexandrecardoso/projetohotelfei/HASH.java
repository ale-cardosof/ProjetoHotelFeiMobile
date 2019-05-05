package com.example.alexandrecardoso.projetohotelfei;
import android.text.format.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class HASH{
    // Vetor em que cada posição é uma LDE diferente
    private int MAX = 31;
    public NoLDE_Reserva vetorHash[] = new NoLDE_Reserva[MAX];

    // Construtor
    public HASH(){
    }

    // Função Insere
    boolean insereHash(Reserva x){
        // Função Hash
        int posicao = this.hash(x);
        // Inserção
        if (vetorHash[posicao] == null)
            vetorHash[posicao] = new NoLDE_Reserva();

        vetorHash[posicao].insereNo(x);
        return true;
    }

    // Função Hash
    int hash(Reserva x){
        int dia  = Integer.parseInt((String)DateFormat.format("dd", x.getDtEntrada()));
        return ( dia % MAX);
    }

    // Função Busca
    Reserva busca(Reserva x){
        int posicaoHash = this.hash(x);
        return (vetorHash[posicaoHash].getByValor(x)); // Busca pelo valor e traz No
    }

    Reserva buscaById(int id){
        for(int i = 0; i < MAX; i++){
            if ( vetorHash[i] != null) {
                Reserva reserAux = vetorHash[i].buscaById(id);
                if (reserAux != null)
                    return reserAux;
            }
        }
        return null; // Busca pelo valor e traz No
    }

    // Função Remove
    boolean remove(Reserva x){
        int posicaoHash = this.hash(x);
        return (vetorHash[posicaoHash].removeByNo(x)); // Remove pelo valor e retorna int
    }

    LDE<Reserva> getTodasReservas(){
        LDE<Reserva> listaReserva = new LDE<>();
        for(int i = 0; i < MAX; i++){
            if(vetorHash[i] != null) {
                No<Reserva> reserAux = vetorHash[i].getByIndex(0);
                while (reserAux != null) {
                    if (reserAux.getValor() != null)
                        listaReserva.insere(reserAux.getValor());
                    reserAux = reserAux.getProximo();
                }
            }
        }
        return listaReserva; // Busca pelo valor e traz No
    }

    Reserva getReservaAtual(int posicao){
        return getTodasReservas().getByIndex(posicao); // Busca pelo valor e traz No
    }

    boolean verificaDisponibilidade(Date dtEntrada, Date dtSaida, int numQuarto){

        LDE<Reserva> ldeTodasReservas = getTodasReservas();
        NoLDE<Reserva> resAtual = ldeTodasReservas.getPrimeiroNo();
        Calendar cDtEntradaNovaReserva = Calendar.getInstance();
        Calendar cDtSaidaNovaReserva = Calendar.getInstance();
        Calendar cDtEntradaReservaAtual = Calendar.getInstance();
        Calendar cDtSaidaReservaAtual = Calendar.getInstance();
        while (resAtual != null){
            if (resAtual.getValor().getQuartoReserva().getNumPorta() == numQuarto) {

                cDtEntradaNovaReserva.setTime(dtEntrada);
                cDtSaidaNovaReserva.setTime(dtSaida);
                cDtEntradaReservaAtual.setTime(resAtual.getValor().getDtEntrada());
                cDtSaidaReservaAtual.setTime(resAtual.getValor().getDtSaida());

                if (cDtEntradaNovaReserva.equals(cDtEntradaReservaAtual)
                || cDtSaidaNovaReserva.equals(cDtSaidaReservaAtual))
                    return false;

                else if ((resAtual.getValor().getDtEntrada().before(dtEntrada)
                && resAtual.getValor().getDtSaida().after(dtEntrada))
                || (resAtual.getValor().getDtEntrada().before(dtSaida)
                        && resAtual.getValor().getDtSaida().after(dtSaida)))
                    return false;

                else if ((dtEntrada.before(resAtual.getValor().getDtEntrada())
                        && dtSaida.after(resAtual.getValor().getDtEntrada()))
                        || (dtEntrada.before(resAtual.getValor().getDtSaida())
                        && dtSaida.after(resAtual.getValor().getDtSaida())))
                    return false;
            }
            resAtual = resAtual.getProx();
        }
        return true;
    }
}