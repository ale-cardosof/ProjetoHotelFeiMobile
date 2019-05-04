package com.example.alexandrecardoso.projetohotelfei;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class UsuarioReservas extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_reservas);

        ListView lista = findViewById(R.id.lvUsuarioReserva);
        ArrayAdapter adapter = new ReservaAdapter(this, Estruturas.logado.user.getMinhasReservas());
        lista.setAdapter(adapter);

    }
}