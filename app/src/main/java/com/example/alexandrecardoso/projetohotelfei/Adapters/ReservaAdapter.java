package com.example.alexandrecardoso.projetohotelfei.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alexandrecardoso.projetohotelfei.Classes.Reserva;
import com.example.alexandrecardoso.projetohotelfei.Estruturas_.LDE;
import com.example.alexandrecardoso.projetohotelfei.R;

import java.text.DateFormat;

public class ReservaAdapter extends ArrayAdapter<Reserva> {

    private final Context context;
    private final LDE<Reserva> ldeReserva;
    private Reserva reservaAtual;

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
        reservaAtual = ldeReserva.getByIndex(position);

        ((ImageView)rowView.findViewById(R.id.imvQuarto)).setImageBitmap(
                reservaAtual.getQuartoReserva().getImagemQuarto());
        ((TextView)rowView.findViewById(R.id.nomeDoUsuario)).setText(String.valueOf(
                reservaAtual.getQuartoReserva().getNumPorta()));
        ((TextView)rowView.findViewById(R.id.boolCheckIN)).setText(String.valueOf(
                reservaAtual.getValor()));
        ((TextView)rowView.findViewById(R.id.idQuarto)).setText(dateFormat.format(
                reservaAtual.getDtEntrada()));
        ((TextView)rowView.findViewById(R.id.dtEntrada)).setText(dateFormat.format(
                reservaAtual.getDtSaida()));

        return rowView;
    }

    @Override
    public int getCount() {
        return ldeReserva.getSize();
    }
}
