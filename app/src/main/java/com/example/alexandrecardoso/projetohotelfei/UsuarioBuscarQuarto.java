package com.example.alexandrecardoso.projetohotelfei;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class UsuarioBuscarQuarto extends AppCompatActivity {
    private ViewPager vpBuscaQuarto;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_buscar_quartos);

        vpBuscaQuarto = findViewById(R.id.vpBuscaQuarto);
        Button btnVisuQuarto = findViewById(R.id.btnVisuQuarto);

        Estruturas.criaEstru();

        vpBuscaQuarto.setAdapter(new AdapterQuartos(UsuarioBuscarQuarto.this, Estruturas.alQuartos));
        Log.d("Adapter", "" + vpBuscaQuarto.getCurrentItem());
        Quarto q = new Quarto();
        btnVisuQuarto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Usuario", "Clicou");
                Intent intent = new Intent(UsuarioBuscarQuarto.this, UsuarioExibirQuarto.class);
                UsuarioExibirQuarto.quartoAtual = Estruturas.alQuartos.get(vpBuscaQuarto.getCurrentItem());
                Log.d("Usuario", "Passou o quarto");
                startActivity(intent);
            }
        });
    }
}
