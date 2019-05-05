package com.example.alexandrecardoso.projetohotelfei;

import android.util.Log;

import java.util.Date;

// Classe que guardará todas as estruturas do aplicativo
public class Estruturas{


    public static boolean criado = false;
    public static LDE<Quarto> ldeQuartos = new LDE<>();
    public static Arvore_user usuariosCadastrados = new Arvore_user();
    public static Arvore_adm admsCadastrados = new Arvore_adm();
    public static infoLogado logado = new infoLogado("",0);
    public static MensagemToast tela = new MensagemToast();
    public static Reserva reserva_clicada = new Reserva();
    public static HASH hash_reservas = new HASH();

    public static void criaEstru (){
        criaQuartos();
        insereUsuarios();
        criarAdm();
        criado = true;
    }

    public static void criaQuartos(){
        Quarto q = new Quarto();

        q.setNumPorta(1);
        q.setQntdCamas(1);
        q.setQntdChuveiros(1);
        q.setValorDiaria(120);
        q.setPossuiTv(true);
        q.setAvaliacoes(new Avaliacao("Otimo Quarto!!!",5,"Recepção excelente," +
                " serviço de quarto bem atenciosos e instalações de acordo com minhas expectativas."));
        q.setImagemQuarto(R.drawable.quarto_1);
        ldeQuartos.insere(q);

        q = new Quarto();
        q.setNumPorta(2);
        q.setQntdCamas(1);
        q.setQntdChuveiros(1);
        q.setValorDiaria(100);
        q.setPossuiTv(true);
        q.setAvaliacoes(new Avaliacao("Hotel simples.",5,"Hotel simples, " +
                "porém confortável! Café da manhã honesto! Estacionamento pago."));
        q.setImagemQuarto(R.drawable.quarto_2);
        ldeQuartos.insere(q);

        q = new Quarto();
        q.setNumPorta(3);
        q.setQntdCamas(1);
        q.setQntdChuveiros(2);
        q.setValorDiaria(300);
        q.setPossuiTv(true);
        q.setAvaliacoes(new Avaliacao("Vista incrível",5,"Os hóspedes são " +
                "bastante efusivos ao falar da vista deste hotel. Para os visitantes, um dos grandes destaques do estabelecimento é a cobertura."));
        q.setImagemQuarto(R.drawable.quarto_3);
        ldeQuartos.insere(q);

        q = new Quarto();
        q.setNumPorta(4);
        q.setQntdCamas(2);
        q.setQntdChuveiros(1);
        q.setValorDiaria(350);
        q.setPossuiTv(true);
        q.setAvaliacoes(new Avaliacao("Fachada 5 estrelas...cuidado!",3,
                "Ótima localização e café da manhã, " +
                        "mas especialmente funcionários muito atenciosos!!"));
        q.setImagemQuarto(R.drawable.quarto_4);
        ldeQuartos.insere(q);

        q = new Quarto();
        q.setNumPorta(5);
        q.setQntdCamas(2);
        q.setQntdChuveiros(2);
        q.setValorDiaria(400);
        q.setPossuiTv(true);
        q.setAvaliacoes(new Avaliacao("Ótima localização",4.5,
                "Ótima localização e café da manhã," +
                        "mas especialmente funcionários muito atenciosos!!"));
        q.setImagemQuarto(R.drawable.quarto_6);
        ldeQuartos.insere(q);

        q = new Quarto();
        q.setNumPorta(10);
        q.setQntdCamas(1);
        q.setQntdChuveiros(1);
        q.setValorDiaria(300);
        q.setPossuiTv(true);
        q.setAvaliacoes(new Avaliacao("O quarto DECA!!!",4.5,
                "Lugar confortavel, serviço de quarto excelente (Especialidade; Galinha assada)." +
                        "Quem tem mais tem 10!"));
        q.setImagemQuarto(R.drawable.quarto_10);
        ldeQuartos.insere(q);

        Date dtEntrada = new Date(2019 - 1900, 5, 1);
        Date dtEntrada2 = new Date(2017 - 1900, 7, 8);
        Date dtEntrada3 = new Date(2017 - 1900, 7, 9);
        Date dtSaida = new Date(2019 - 1900, 5, 4);

        Reserva r1 = new Reserva(logado.username, dtEntrada,dtSaida, ldeQuartos.getByIndex(1), 150);

        //LDE_Reserva lde_reserva_hash = new LDE_Reserva();
        hash_reservas.insereHash(r1);
        Reserva r2 = new Reserva(logado.username, dtEntrada2,dtSaida, ldeQuartos.getByIndex(1), 150);
        hash_reservas.insereHash(r2);
        Reserva r3 = new Reserva(logado.username, dtEntrada3,dtSaida, ldeQuartos.getByIndex(1), 150);
        hash_reservas.insereHash(r3);
        Reserva r4 = new Reserva(logado.username, dtEntrada,dtSaida, ldeQuartos.getByIndex(1), 150);
        hash_reservas.insereHash(r4);
        r4 = new Reserva(logado.username, dtEntrada2,dtSaida, ldeQuartos.getByIndex(1), 150);
        hash_reservas.insereHash(r4);
        r4 = new Reserva(logado.username, dtEntrada2,dtSaida, ldeQuartos.getByIndex(1), 150);
        hash_reservas.insereHash(r4);
        r4 = new Reserva(logado.username, dtEntrada2,dtSaida, ldeQuartos.getByIndex(1), 150);
        hash_reservas.insereHash(r4);
        r4 = new Reserva(logado.username, dtEntrada2,dtSaida, ldeQuartos.getByIndex(1), 150);
        hash_reservas.insereHash(r4);

        Log.d("HASHESTRUTURAS", " 4 "+ hash_reservas.getTodasReservas().getSize());

        Log.d("HASHESTRUTURAS", " -              ==");

        /*
        if(hash_reservas.buscaById(0) != null)
            Log.d("HASHESTRUTURAS", ""+ hash_reservas.buscaById(0).getIdReserva());
        if(hash_reservas.buscaById(1) != null)
            Log.d("HASHESTRUTURAS", ""+ hash_reservas.buscaById(1).getIdReserva());
        if(hash_reservas.buscaById(2) != null)
            Log.d("HASHESTRUTURAS", ""+ hash_reservas.buscaById(2).getIdReserva());
        if(hash_reservas.buscaById(3) != null)
            Log.d("HASHESTRUTURAS", ""+ hash_reservas.buscaById(3).getIdReserva());
        Log.d("HASHESTRUTURAS", " -              =="+ hash_reservas.buscaById(3).getIdReserva());
        /*
        Log.d("HASH", "---------------------------------- MAIN");
        if (hash_reservas.busca(r1) != null)
            Log.d("HASH", ""+hash_reservas.busca(r3).getValor().getIdReserva());
        if (hash_reservas.busca(r4) != null)
            Log.d("HASH", ""+hash_reservas.busca(r4).getValor().getIdReserva());
        if (hash_reservas.busca(r1) != null)
            Log.d("HASH", ""+hash_reservas.busca(r1).getValor().getIdReserva());
        if (hash_reservas.busca(r2) != null)
            Log.d("HASH", ""+hash_reservas.busca(r2).getValor().getIdReserva());
        Log.d("HASH", "---------------------------------- MAIN");

        Reserva r10 = hash_reservas.buscaById(2);

        if (r10 != null)
            Log.d("HASH", ""+r10.getIdReserva() + " va" + r10.getDtEntrada());

        NoLDE_Reserva lista =  hash_reservas.imprimeTodasReservas();

        Log.d("HASH", " lista " + lista.getSize());*/
    }

    public static void destroiEstrutura(){
        criado = false;
        ldeQuartos = null;
    }

    public static void insereUsuarios(){
        Usuario userInicial = new Usuario("user","User Inicial","123456789",
                "01/01/2019","user@user.com.br","11954546565","user");
        usuariosCadastrados.insere(userInicial);

        Usuario userDois = new Usuario("ale","Alexandre Cardoso","123456789",
                "01/01/2019","user@user.com.br","11954546565","ale");
        usuariosCadastrados.insere(userDois);

        Usuario userTres = new Usuario("filipi","Filipi Guimares Silva","123456789",
                "01/01/2019","user@user.com.br","11954546565","filipi");
        Date dtEntrada = new Date(2019 - 1900, 5, 1);
        Date dtSaida = new Date(2019 - 1900, 5, 4);
        Reserva r1 = new Reserva( userTres.getNome(), dtEntrada,dtSaida, ldeQuartos.getByIndex(1), 150);
        userTres.setMinhasReservas(r1);

        dtEntrada = new Date(2019 - 1900, 5, 8);
        dtSaida = new Date(2019 - 1900, 5, 12);
        r1 = new Reserva( userTres.getNome(), dtEntrada,dtSaida, ldeQuartos.getByIndex(3), 450);
        userTres.setMinhasReservas(r1);
        usuariosCadastrados.insere(userTres);

        Usuario userQuatro = new Usuario("serain","Lucas Machado Serain","123456789",
                "01/01/2019","user@user.com.br","11954546565","serain");
        usuariosCadastrados.insere(userQuatro);
    }

    public static void criarAdm(){
        // Cria o adm padrão
        Administrador admInicial = new Administrador("admin","Administrador Inicial","123456789","01/01/2019","admin@admin.com.br","11954546565","admin");
        admsCadastrados.insere(admInicial);
    }

}
