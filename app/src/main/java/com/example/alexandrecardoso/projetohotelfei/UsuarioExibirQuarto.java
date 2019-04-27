package com.example.alexandrecardoso.projetohotelfei;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class UsuarioExibirQuarto extends AppCompatActivity {

    private Quarto quarto;

    public UsuarioExibirQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public UsuarioExibirQuarto() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_exibir_quarto);

        // Passar o vetor de imagens do qaurto especifico
        int[] quartos = {R.drawable.imgbanco, R.drawable.imgcasa, R.drawable.imgchale,
                R.drawable.imgfronteira, R.drawable.imghotel};
        String TAG = "Fila Class";
        Log.d(TAG, "Antes Fila Class ");
        Fila f = new Fila(10);
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
        f.imprime();

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
        vpExibeQuarto.setAdapter(new AdapterQuartos(UsuarioExibirQuarto.this, quartos));

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
