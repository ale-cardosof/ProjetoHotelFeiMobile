package com.example.alexandrecardoso.projetohotelfei;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ReservaAdapter extends ArrayAdapter<Quarto> {

    private final Context context;
    private final ArrayList<Quarto> elementos;

    public ReservaAdapter(Context context, ArrayList<Quarto> elementos){
        super(context, R.layout.layout_usuario_reservas_item);
        this.context = context;
        this.elementos = elementos;
        String TAG = UsuarioReservas.class.getSimpleName();
        Log.d(TAG, "Passou no Construtor." + elementos.size());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        String TAG = UsuarioReservas.class.getSimpleName();
        Log.d(TAG, "Passou no getView." + position);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.layout_usuario_reservas_item, parent, false);

        //rowView.setBackgroundColor(Color.BLUE);
        if (position % 2 == 0)
            rowView.setBackgroundColor(Color.parseColor("#4D808080"));
        else
            rowView.setBackgroundColor(Color.parseColor("#BFF0E68C"));

        TextView lblNomeHotel = rowView.findViewById(R.id.TextView1);
        TextView lblDataReserva = rowView.findViewById(R.id.lblValorDiaria);
        ImageView imvHotelItem = rowView.findViewById(R.id.imvHotelItem);

        lblNomeHotel.setText("WOWTEL");

        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String data = df.format(c);
        lblDataReserva.setText(data);
        imvHotelItem.setImageResource(elementos.get(position).getImagemQuarto());

        return rowView;
    }

    @Override
    public int getCount() {
        return elementos.size();
    }
}
