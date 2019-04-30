package com.example.alexandrecardoso.projetohotelfei;

import java.util.ArrayList;

public class Estruturas{


    public static boolean criado = false;
    public static ArrayList<Quarto> alQuartos = new ArrayList<>();

    public static void criaEstru (){
        Quarto q = new Quarto();

        q.setNumPorta(1);
        q.setQntdCamas(2);
        q.setQntdChuveiros(1);
        q.setValorDiaria(120);
        q.setPossuiTv(true);
        q.setAvaliacao(4);
        q.setImagemQuarto(R.drawable.imgcasa);
        alQuartos.add(q);

        q = new Quarto();
        q.setNumPorta(2);
        q.setQntdCamas(1);
        q.setQntdChuveiros(1);
        q.setValorDiaria(160);
        q.setPossuiTv(true);
        q.setAvaliacao(4.5);
        q.setImagemQuarto(R.drawable.imgbanco);
        alQuartos.add(q);

        q = new Quarto();
        q.setNumPorta(3);
        q.setQntdCamas(1);
        q.setQntdChuveiros(1);
        q.setValorDiaria(200);
        q.setPossuiTv(true);
        q.setAvaliacao(5);
        q.setImagemQuarto(R.drawable.imgvilla);
        alQuartos.add(q);

        q = new Quarto();
        q.setNumPorta(4);
        q.setQntdCamas(4);
        q.setQntdChuveiros(3);
        q.setValorDiaria(400);
        q.setPossuiTv(true);
        q.setAvaliacao(5);
        q.setImagemQuarto(R.drawable.imgoregon);
        alQuartos.add(q);

        criado = true;
    }
}
