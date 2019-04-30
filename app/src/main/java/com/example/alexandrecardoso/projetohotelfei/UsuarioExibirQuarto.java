package com.example.alexandrecardoso.projetohotelfei;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class UsuarioExibirQuarto extends AppCompatActivity {

    public static Quarto quartoAtual;
    private Quarto quartoExibido;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_exibir_quarto);
        // Passar o vetor de imagens do qaurto especifico
        int[] quartos = {R.drawable.imgbanco, R.drawable.imgcasa, R.drawable.imgchale,
                R.drawable.imgfronteira, R.drawable.imghotel};
        quartoExibido = quartoAtual;
        quartoAtual = null;

        ((TextView)findViewById(R.id.lblNumCamas)).setText(String.valueOf(quartoExibido.getQntdCamas()));
        ((TextView)findViewById(R.id.lblDetalhes)).setText("Detalhes - Quarto : " +quartoExibido.getNumPorta());
        ((TextView)findViewById(R.id.lblPossuiTV)).setText(quartoExibido.isPossuiTv() ? "Sim" : "Não");
        ((TextView)findViewById(R.id.lblNumChuveiros)).setText(String.valueOf(quartoExibido.getQntdChuveiros()));
        ((TextView)findViewById(R.id.lblValorDiaria)).setText(String.valueOf(quartoExibido.getValorDiaria()));

        ViewPager vpExibeQuarto = findViewById(R.id.vpExibeQuarto);
        vpExibeQuarto.setAdapter(new AdapterQuartos(UsuarioExibirQuarto.this, quartoExibido));


        ListView lvAvaliacoes = findViewById(R.id.lvAvaliacoes);
        ArrayAdapter adapter = new AdapterAvaliacao(this, quartoExibido.getLdeAvaliacoes());
        lvAvaliacoes.setAdapter(adapter);

        // Seta o tamanho da ListView de acordo com o tamanho da lista
        ViewGroup.LayoutParams params = lvAvaliacoes.getLayoutParams();
        params.height = 450 * lvAvaliacoes.getCount();;
        lvAvaliacoes.setLayoutParams(params);
        lvAvaliacoes.requestLayout();
    }
}
