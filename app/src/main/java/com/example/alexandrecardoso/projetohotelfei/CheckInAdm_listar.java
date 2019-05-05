package com.example.alexandrecardoso.projetohotelfei;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class CheckInAdm_listar extends AppCompatActivity {
    RecyclerView recicleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in_adm_listar);
        getSupportActionBar().hide();

        recicleView = findViewById(R.id.recicle);

    }
}
