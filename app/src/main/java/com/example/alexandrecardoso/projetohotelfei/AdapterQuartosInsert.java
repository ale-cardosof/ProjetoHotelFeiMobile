package com.example.alexandrecardoso.projetohotelfei;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static com.example.alexandrecardoso.projetohotelfei.menuUsuario.quartosCriados;

public class AdapterQuartosInsert extends RecyclerView.Adapter<AdapterQuartosInsert.MyViewHolder> {

    private List<Quarto> listaQuartos;

    public AdapterQuartosInsert(List<Quarto> listQuarto) {
        this.listaQuartos = listQuarto;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemLista = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_lista, viewGroup, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Quarto quarto = quartosCriados.get(i);
        myViewHolder.numeroPorta.setText("Numero da porta: " +quarto.getNumPorta());
        myViewHolder.valorDiaria.setText("Valor da diária: R$"+quarto.getValorDiaria());
        myViewHolder.quantidadeCama.setText("Quantidade de cama:" + quarto.getQntdCamas());
        myViewHolder.quantidadeChuveiro.setText("Numero de chuveiro:" + quarto.getQntdChuveiros());



    }

    @Override
    public int getItemCount() {
        return quartosCriados.size();
    }

    //Inner Class  - classe para armazenar os dados dentro de cada elemento de lista
    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView numeroPorta;
        TextView valorDiaria;
        TextView quantidadeCama;
        TextView quantidadeChuveiro;
        TextView possuiTV;
        //ImageView imgQuarto1,imgQuarto2,imgQuarto3,imgQuarto4,imgQuarto5;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            numeroPorta = itemView.findViewById(R.id.txtPorta);
            valorDiaria = itemView.findViewById(R.id.txtDiaria);
            quantidadeCama = itemView.findViewById(R.id.txtCama);
            quantidadeChuveiro = itemView.findViewById(R.id.txtChuveiro);
            possuiTV = itemView.findViewById(R.id.txtTV);
        }
    }
}
