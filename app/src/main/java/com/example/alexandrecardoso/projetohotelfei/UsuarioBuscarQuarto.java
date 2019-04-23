package com.example.alexandrecardoso.projetohotelfei;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class UsuarioBuscarQuarto  extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_buscar_quartos);

        int[] quartos = {R.drawable.imgbanco,R.drawable.imgcasa,R.drawable.imgchale,
                R.drawable.imgfronteira,R.drawable.imghotel};

        ViewPager vpBuscaQuarto = findViewById(R.id.vpBuscaQuarto);
        vpBuscaQuarto.setAdapter(new AdapterQuartos(UsuarioBuscarQuarto.this, quartos));
    }
}
