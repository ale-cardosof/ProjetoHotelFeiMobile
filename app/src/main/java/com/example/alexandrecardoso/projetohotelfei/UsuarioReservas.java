package com.example.alexandrecardoso.projetohotelfei;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class UsuarioReservas extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_reservas);

        ListView lista = findViewById(R.id.lvReservas);
        ArrayAdapter adapter = new ReservaAdapter(this, addReservas());

        //String TAG = UsuarioReservas.class.getSimpleName();
        //ArrayAdapter ad = new ArrayAdapter()
        lista.setAdapter(adapter);
    }

    private ArrayList<Quarto> addReservas(){
        ArrayList<Quarto> listQuartos = new ArrayList<Quarto>();
        Quarto q = new Quarto();

        q.setImagemQuarto(R.drawable.imghotel);
        listQuartos.add(q);

        q = new Quarto();
        q.setImagemQuarto(R.drawable.imgchale);
        listQuartos.add(q);

        q = new Quarto();
        q.setImagemQuarto(R.drawable.imgfronteira);
        listQuartos.add(q);

        q = new Quarto();
        q.setImagemQuarto(R.drawable.imgoregon);
        listQuartos.add(q);

        q = new Quarto();
        q.setImagemQuarto(R.drawable.imgvilla);
        listQuartos.add(q);

        q = new Quarto();
        q.setImagemQuarto(R.drawable.imgcasa);
        listQuartos.add(q);

        q = new Quarto();
        q.setImagemQuarto(R.drawable.imgbanco);
        listQuartos.add(q);

        return listQuartos;
    }
}