package com.example.alexandrecardoso.projetohotelfei;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterAvaliacao extends ArrayAdapter<Avaliacao> {
    private final Context context;
    private final ArrayList<Avaliacao> alAvaliacoes;

    public AdapterAvaliacao(Context context, ArrayList<Avaliacao> alAvaliacoes) {
        super(context, R.layout.layout_usuario_reservas_item);
        this.context = context;
        this.alAvaliacoes = alAvaliacoes;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.layout_usuario_avaliacao_item, parent, false);

        rowView.setBackgroundColor(Color.parseColor("#4D808080"));

        if (position % 2 == 0) {
            rowView.setBackgroundColor(Color.parseColor("#4D808080"));
        }
        else
            rowView.setBackgroundColor(Color.parseColor("#BFF0E68C"));

        ((TextView)rowView.findViewById(R.id.lblTituloAvaliacao)).setText(alAvaliacoes.get(position).getTitulo());
        ((TextView)rowView.findViewById(R.id.lblNotaAvaliacao)).setText(String.valueOf(alAvaliacoes.get(position).getNota()));
        ((TextView)rowView.findViewById(R.id.lblMensagemAvaliacao)).setText(alAvaliacoes.get(position).getMensagem());

        return rowView;
    }

    @Override
    public int getCount() {
        return alAvaliacoes.size();
    }
}
