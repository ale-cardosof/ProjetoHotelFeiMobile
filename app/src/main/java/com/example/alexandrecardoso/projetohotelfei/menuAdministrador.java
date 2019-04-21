package com.example.alexandrecardoso.projetohotelfei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class menuAdministrador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_administrador);
        getSupportActionBar().hide();
    }


    public  void visualizarHotel(View view){
        Intent intent = new Intent(menuAdministrador.this, menuVisualizarHotel.class);
        startActivity(intent);
    }

    public void cadastrarFunc(View view){
        Intent intent = new Intent(menuAdministrador.this, menuCadastroNovoFuncionario.class);
        startActivity(intent);
    }

    public void estruturaHotel(View view){
        Intent intent = new Intent(menuAdministrador.this, menuEstruturaHotel.class);
        startActivity(intent);
    }
}
