package com.example.alexandrecardoso.projetohotelfei;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;

public class ReservaAdapter extends ArrayAdapter<Reserva> {

    private final Context context;
    private final LDE<Reserva> ldeReserva;
    private Reserva reservaAtual;
    public Button btnAvaliar;

    public ReservaAdapter(Context context, LDE<Reserva>  ldeReserva){
        super(context, R.layout.layout_usuario_reservas_item);
        this.context = context;
        this.ldeReserva = ldeReserva;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.layout_usuario_reservas_item, parent, false);

        if (position % 2 == 0) {
            rowView.setBackgroundColor(Color.parseColor("#4D808080"));
        }
        else
            rowView.setBackgroundColor(Color.parseColor("#BFF0E68C"));

        DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(context.getApplicationContext());

        btnAvaliar = rowView.findViewById(R.id.btnAvaliar);
        reservaAtual = ldeReserva.getByIndex(position);

        (rowView.findViewById(R.id.btnAvaliar)).setVisibility(
                (reservaAtual.isAvaliada()) ? View.INVISIBLE : View.VISIBLE);
        ((ImageView)rowView.findViewById(R.id.imvQuarto)).setImageResource(
                reservaAtual.getQuartoReserva().getImagemQuarto());
        ((TextView)rowView.findViewById(R.id.lblNumeroQuarto)).setText(String.valueOf(
                reservaAtual.getQuartoReserva().getNumPorta()));
        ((TextView)rowView.findViewById(R.id.lblValTotal)).setText(String.valueOf(
                reservaAtual.getValor()));
        ((TextView)rowView.findViewById(R.id.lblDataEntrada)).setText(dateFormat.format(
                reservaAtual.getDtEntrada()));
        ((TextView)rowView.findViewById(R.id.lblDataSaida)).setText(dateFormat.format(
                reservaAtual.getDtSaida()));

        btnAvaliar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TESTECLICK", "CLICOU");
            }
        });

        return rowView;
    }

    @Override
    public int getCount() {
        return ldeReserva.getSize();
    }
}
