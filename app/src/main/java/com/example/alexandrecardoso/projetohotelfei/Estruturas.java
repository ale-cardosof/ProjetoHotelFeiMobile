package com.example.alexandrecardoso.projetohotelfei;

import java.util.Date;

// Classe que guardará todas as estruturas do aplicativo
public class Estruturas{


    public static boolean criado = false;
    public static LDE<Quarto> alQuartos = new LDE<>();
    public static LES_usu usuariosCadastrados = new LES_usu();
    public static Usuario UsuarioLogado;
    public static LES_adm admsCadastrados = new LES_adm();
    public static infoLogado logado = new infoLogado("",0,0);

    public static void criaEstru (){
        criaQuartos();
        criaAvaliacoes();
        insereUsuarios();
        criarAdm();

        criado = true;
    }

    public static void criaQuartos(){
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

    }

    public static void criaAvaliacoes(){
        for (int i = 0; i < alQuartos.getSize(); i++){
            for (int j =0; j < i; j++) {
                Avaliacao aval = new Avaliacao("Titulo" + (i+j), i, "Mensagem" + i);
                alQuartos.getByIndex(i).setAvaliacoes(aval);
            }
        }
    }

    public static void montarReservasUsuario(){

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

    public static void insereUsuarios(){
        // Cria o usuário padrão
        Usuario userInicial = new Usuario("user","User Inicial","123456789",
                "01/01/2019","user@user.com.br","11954546565","user");
        usuariosCadastrados.insere(userInicial);
    }

    public static void criarAdm(){
        // Cria o adm padrão
        Administrador admInicial = new Administrador("admin","Administrador Inicial","123456789","01/01/2019","admin@admin.com.br","11954546565","admin");
        admsCadastrados.insere(admInicial);
    }
}
