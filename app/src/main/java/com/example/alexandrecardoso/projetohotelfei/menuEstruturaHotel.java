package com.example.alexandrecardoso.projetohotelfei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import static com.example.alexandrecardoso.projetohotelfei.menuUsuario.quartosCriados;

public class menuEstruturaHotel extends AppCompatActivity {

    private RecyclerView listHoteis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_estrutura_hotel);
        getSupportActionBar().hide();
        listHoteis = findViewById(R.id.recyclerHotel);

        //Configuraando adapter
        AdapterQuartosInsert adapter = new AdapterQuartosInsert(quartosCriados);
        //Configurar recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        listHoteis.setLayoutManager(layoutManager);
        listHoteis.setHasFixedSize(true);
        listHoteis.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        listHoteis.setAdapter(adapter);
        //listHoteis.setAdapter();

    }

    public void menuInsercao(View view){
        Intent intent = new Intent(menuEstruturaHotel.this, menuInsercaoQuarto.class);
        startActivity(intent);
    }
}
