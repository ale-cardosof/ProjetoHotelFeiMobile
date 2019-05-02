package com.example.alexandrecardoso.projetohotelfei;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

// Classe que ira gerar itens da list View de Avaliação a partir da LDE
public class AdapterAvaliacao extends ArrayAdapter<Avaliacao> {
    // Variaveis globais
    private final Context context;
    private final LDE<Avaliacao> alAvaliacoes;

    // Construtor do Adapter de Avaliacao
    public AdapterAvaliacao(Context context, LDE<Avaliacao> alAvaliacoes) {
        super(context, R.layout.layout_usuario_reservas_item);
        this.context = context;
        this.alAvaliacoes = alAvaliacoes;
    }

    // Metodo que busca a Avaliação apatir da position recebida e retorna uma nova linha para a listView
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.layout_usuario_avaliacao_item, parent, false);

        if (position % 2 == 0) {
            rowView.setBackgroundColor(Color.parseColor("#4D808080"));
        }
        else
            rowView.setBackgroundColor(Color.parseColor("#BFF0E68C"));

        ((TextView)rowView.findViewById(R.id.lblTituloAvaliacao)).setText(alAvaliacoes.getByIndex(position).getTitulo());
        ((TextView)rowView.findViewById(R.id.lblNotaAvaliacao)).setText(String.valueOf(alAvaliacoes.getByIndex(position).getNota()));
        ((TextView)rowView.findViewById(R.id.lblMensagemAvaliacao)).setText(alAvaliacoes.getByIndex(position).getMensagem());

        return rowView;
    }

    // Metodo que retorna o tamanho da LDE
    // Essencial para a atividade do getView
    @Override
    public int getCount() {
        return alAvaliacoes.getSize();
    }
}
