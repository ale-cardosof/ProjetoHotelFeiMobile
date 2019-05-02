package com.example.alexandrecardoso.projetohotelfei;

import java.util.Date;

// Classe que guardará todas as estruturas do aplicativo
public class Estruturas{


    public static boolean criado = false;
    public static LDE<Quarto> alQuartos = new LDE<>();
    public static Usuario UsuarioLogado;

    public static void criaEstru (){
        Quarto q = new Quarto();

        q.setNumPorta(1);
        q.setQntdCamas(2);
        q.setQntdChuveiros(1);
        q.setValorDiaria(120);
        q.setPossuiTv(true);
        q.setAvaliacao(4);
        q.setImagemQuarto(R.drawable.imgcasa);
        alQuartos.insere(q);

        q = new Quarto();
        q.setNumPorta(2);
        q.setQntdCamas(1);
        q.setQntdChuveiros(1);
        q.setValorDiaria(160);
        q.setPossuiTv(true);
        q.setAvaliacao(4.5);
        q.setImagemQuarto(R.drawable.imgbanco);
        alQuartos.insere(q);

        q = new Quarto();
        q.setNumPorta(3);
        q.setQntdCamas(1);
        q.setQntdChuveiros(1);
        q.setValorDiaria(200);
        q.setPossuiTv(true);
        q.setAvaliacao(5);
        q.setImagemQuarto(R.drawable.imgvilla);
        alQuartos.insere(q);

        q = new Quarto();
        q.setNumPorta(4);
        q.setQntdCamas(4);
        q.setQntdChuveiros(3);
        q.setValorDiaria(400);
        q.setPossuiTv(true);
        q.setAvaliacao(5);
        q.setImagemQuarto(R.drawable.imgoregon);
        alQuartos.insere(q);

        for (int i = 0; i < alQuartos.getSize(); i++){
            for (int j =0; j < i; j++) {
                Avaliacao aval = new Avaliacao("Titulo" + (i+j), i, "Mensagem" + i);
                alQuartos.getByIndex(i).setAvaliacoes(aval);
            }
        }
        criado = true;
    }

    public static void montarUsuario(){

        Date dtEntrada = new Date(2019 - 1900, 5, 1);
        Date dtSaida = new Date(2019 - 1900, 5, 4);
        Reserva r1 = new Reserva(dtEntrada,dtSaida, alQuartos.getByIndex(1), 150);
        UsuarioLogado.setMinhasReservas(r1);

        dtEntrada = new Date(2019 - 1900, 7, 5);
        dtSaida = new Date(2019 - 1900, 7, 3);
        r1 = new Reserva(dtEntrada,dtSaida, alQuartos.getByIndex(2), 400);
        UsuarioLogado.setMinhasReservas(r1);

        dtEntrada = new Date(2019 - 1900, 8, 2);
        dtSaida = new Date(2019 - 1900, 8, 4);
        r1 = new Reserva(dtEntrada,dtSaida, alQuartos.getByIndex(3), 180);
        UsuarioLogado.setMinhasReservas(r1);
    }

    public static void destroiEstrutura(){
        criado = false;
        alQuartos = null;
        UsuarioLogado = null;
    }
}
