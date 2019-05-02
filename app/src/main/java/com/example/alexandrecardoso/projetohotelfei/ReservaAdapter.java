package com.example.alexandrecardoso.projetohotelfei;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;

public class ReservaAdapter extends ArrayAdapter<Reserva> {

    private final Context context;
    private final LDE<Reserva> ldeReserva;

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

        ((ImageView)rowView.findViewById(R.id.imvQuarto)).setImageResource(
                ldeReserva.getByIndex(position).getQuartoReserva().getImagemQuarto());
        ((TextView)rowView.findViewById(R.id.lblNumeroQuarto)).setText(String.valueOf(
                ldeReserva.getByIndex(position).getQuartoReserva().getNumPorta()));
        ((TextView)rowView.findViewById(R.id.lblValTotal)).setText(String.valueOf(
                ldeReserva.getByIndex(position).getValor()));
        ((TextView)rowView.findViewById(R.id.lblDataEntrada)).setText(dateFormat.format(
                ldeReserva.getByIndex(position).getDtEntrada()));
        ((TextView)rowView.findViewById(R.id.lblDataSaida)).setText(dateFormat.format(
                ldeReserva.getByIndex(position).getDtSaida()));

        return rowView;
    }

    @Override
    public int getCount() {
        return ldeReserva.getSize();
    }
}
