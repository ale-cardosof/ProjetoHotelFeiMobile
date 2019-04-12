package com.example.alexandrecardoso.projetohotelfei;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

// Para ver em outra tela, usar:
// import static com.example.alexandrecardoso.projetohotelfei.MainActivity.admsLogados;


public class MainActivity extends AppCompatActivity {
    // Cria variáveis globais (COLOCAR NA PRIMEIRA TELA CHAMADA PELO APP)
    public static Administrador admsLogados[] = new Administrador[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Administrador admInicial = new Administrador("admin","Administrador",123456789,"01/01/2019","admin@admin.com.br","11961839318","admin");
        admsLogados[0] = admInicial;



    }
}
