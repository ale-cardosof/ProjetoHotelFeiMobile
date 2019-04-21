package com.example.alexandrecardoso.projetohotelfei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class menuEstruturaHotel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_estrutura_hotel);
        getSupportActionBar().hide();
    }

    public void menuInsercao(View view){
        Intent intent = new Intent(menuEstruturaHotel.this, menuInsercaoQuarto.class);
        startActivity(intent);
    }
}
