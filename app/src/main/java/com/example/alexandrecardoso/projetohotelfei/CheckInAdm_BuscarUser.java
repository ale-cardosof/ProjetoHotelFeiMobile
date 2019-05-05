package com.example.alexandrecardoso.projetohotelfei;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CheckInAdm_BuscarUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in_adm__buscar_user);
        getSupportActionBar().hide();

        ListView listView = findViewById(R.id.lvReservaUsuario);
        ArrayAdapter adapter = new AdapterReservaAdm(this, Estruturas.usuariosCadastrados.busca("filipi").getMinhasReservas());
        listView.setAdapter(adapter);
    }
}
