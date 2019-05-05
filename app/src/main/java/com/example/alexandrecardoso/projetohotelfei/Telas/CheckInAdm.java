package com.example.alexandrecardoso.projetohotelfei.Telas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.alexandrecardoso.projetohotelfei.R;

public class CheckInAdm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in_adm);
        getSupportActionBar().hide();
    }

    public void buscarUser(View view){
        Intent intent = new Intent(this, CheckInAdm_BuscarUser.class);
        startActivity(intent);
    }
    public void listarReservas(View view){
        Intent intent = new Intent(this, CheckInAdm_listar.class);
        startActivity(intent);
    }

    public void onBackPressed(){
        Intent intent = new Intent(CheckInAdm.this, menuAdministrador.class);
        startActivity(intent);
    }
}
