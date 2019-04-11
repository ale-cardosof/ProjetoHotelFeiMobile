package com.example.alexandrecardoso.projetohotelfei;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Cria variáveis globais (COLOCAR NA PRIMEIRA TELA CHAMADA PELO APP)
        Administrador admsLogados[];
        Administrador admInicial = new Administrador("admin","Administrador",123456789,"01/01/2019","admin@admin.com.br","11961839318","admin");

    }
}
