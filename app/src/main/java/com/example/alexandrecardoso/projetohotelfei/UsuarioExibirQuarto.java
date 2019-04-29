package com.example.alexandrecardoso.projetohotelfei;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class UsuarioExibirQuarto extends AppCompatActivity {

    public static Quarto quartoAtual;
    private Quarto quartoExibido;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_exibir_quarto);
        // Passar o vetor de imagens do qaurto especifico
        int[] quartos = {R.drawable.imgbanco, R.drawable.imgcasa, R.drawable.imgchale,
                R.drawable.imgfronteira, R.drawable.imghotel};
        Log.d("Usuario", "Antes de criar o quarto");
        quartoExibido = quartoAtual;
        quartoAtual = null;

        Log.d("Usuario", "Antes de setar tudo");

        quartoExibido = new Quarto();
        quartoExibido.setPossuiTv(true);
        quartoExibido.setValorDiaria(120);
        quartoExibido.setQntdChuveiros(3);
        quartoExibido.setQntdCamas(1);
        quartoExibido.setNumPorta(10);


        ((TextView)findViewById(R.id.lblNumCamas)).setText(String.valueOf(quartoExibido.getQntdCamas()));
        ((TextView)findViewById(R.id.lblDetalhes)).setText("Detalhes - Quarto : " +quartoExibido.getNumPorta());
        ((TextView)findViewById(R.id.lblPossuiTV)).setText(quartoExibido.isPossuiTv() ? "Sim" : "Não");
        ((TextView)findViewById(R.id.lblNumChuveiros)).setText(String.valueOf(quartoExibido.getQntdChuveiros()));
        ((TextView)findViewById(R.id.lblValorDiaria)).setText(String.valueOf(quartoExibido.getValorDiaria()));


        /*
        LDE<Integer> lde = new LDE<>();

        lde.insere(10);
        lde.insere(12);
        lde.insere(14);
        lde.insere(16);

        LDE<Quarto> ldq = new LDE<>();

        Quarto q1 = new Quarto();
        q1.setValorDiaria(120);
        ldq.insere(q1);

        q1 = new Quarto();
        q1.setValorDiaria(150);
        ldq.insere(q1);

        q1 = new Quarto();
        q1.setValorDiaria(180);
        ldq.insere(q1);

        int i = 0;
        Quarto q2 = ldq.getByIndex(i);
        while (q2 != null) {
            Log.d("NOLDE", "Valor Diaria" + q2.getValorDiaria());
            i++;
            q2 = ldq.getByIndex(i);
        }

        ldq.removeByIndex(2);
        i = 0;
        q2 = ldq.getByIndex(i);
        while (q2 != null) {
            Log.d("NOLDE", "Valor Diaria" + q2.getValorDiaria());
            i++;
            q2 = ldq.getByIndex(i);
        }

        lde.imprime();*/

        /*Fila f = new Fila(10);
        f.enfileira(10);
        f.enfileira(70);
        f.enfileira(30);
        f.enfileira(40);
        f.enfileira(60);

        f.imprime();
//
        f.desenfileira();
        f.desenfileira();
//
        f.imprime();
//
        f.enfileira(30);
        f.enfileira(40);
        f.enfileira(10);
        f.enfileira(70);
        f.enfileira(30);
        f.enfileira(40);
        f.enfileira(60);
//
        f.imprime();
        f.desenfileira();
        f.enfileira(40);
        f.enfileira(60);
        f.imprime();
        f.limpa();
        f.imprime();
        f.enfileira(30);
        f.imprime();
        f.desenfileira();
        f.desenfileira();
        f.imprime();*/

//        GenericClass<String> gf = new GenericClass<>();
//
//        gf.valor = "Teste Generico";
//
//        String TAG = GenericClass.class.getSimpleName();
//        Log.d(TAG, "Passou no Generico." + gf.valor);
//
//        GenericClass<Integer> gi = new GenericClass<>();
//
//        gi.valor = 150;
//        Log.d(TAG, "Passou no Generico." + gi.valor);

        ViewPager vpExibeQuarto = findViewById(R.id.vpExibeQuarto);
        vpExibeQuarto.setAdapter(new AdapterQuartos(UsuarioExibirQuarto.this, quartoExibido));

        ListView lista = findViewById(R.id.lvAvaliacoes);
        ArrayAdapter adapter = new AdapterAvaliacao(this, addAvaliacoes());

        lista.setAdapter(adapter);



    }

    private ArrayList<Avaliacao> addAvaliacoes() {
        ArrayList<Avaliacao> lista = new ArrayList<Avaliacao>();

        Avaliacao av = new Avaliacao("Otimo Quarto!", 5.0, "Otimo Quarto! Cabe toda a Familia, só os buscapés, nordestino sem dente.");
        lista.add(av);
        av = new Avaliacao("Bom pra suruba!", 5.0, "Por que tudo depende do quanto voce quer comer alguém.");
        lista.add(av);
        av = new Avaliacao("Sem spoiler", 1.0, "Thanos morre no final.");
        lista.add(av);

        ListView lvAvaliacoes = (findViewById(R.id.lvAvaliacoes));
        // Seta o tamanho da ListView de acordo com o tamanho da lista
        ViewGroup.LayoutParams params = lvAvaliacoes.getLayoutParams();
        params.height = 450 * lista.size();
        lvAvaliacoes.setLayoutParams(params);
        lvAvaliacoes.requestLayout();

        return lista;
    }
}
