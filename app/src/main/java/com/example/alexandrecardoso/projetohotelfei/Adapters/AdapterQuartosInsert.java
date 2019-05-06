package com.example.alexandrecardoso.projetohotelfei.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.alexandrecardoso.projetohotelfei.Classes.Administrador;
import com.example.alexandrecardoso.projetohotelfei.Classes.Quarto;
import com.example.alexandrecardoso.projetohotelfei.Estruturas_.LDE;
import com.example.alexandrecardoso.projetohotelfei.R;
import com.example.alexandrecardoso.projetohotelfei.Classes.Estruturas;

import static com.example.alexandrecardoso.projetohotelfei.Classes.Estruturas.logado;

public class AdapterQuartosInsert extends RecyclerView.Adapter<AdapterQuartosInsert.MyViewHolder> {

    LDE<Quarto> ldeQuartos;

    public AdapterQuartosInsert(LDE<Quarto> listQuarto) {

        this.ldeQuartos = listQuarto;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemLista = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_lista, viewGroup, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Quarto quarto = Estruturas.ldeQuartos.getByIndex(i);
        //Quarto quarto = ((Administrador)(logado.user)).getMeuHotel().getQuartos().getByIndex(i);
        myViewHolder.numeroPorta.setText("Numero da porta: " +quarto.getNumPorta());
        myViewHolder.valorDiaria.setText("Valor da diária: R$"+quarto.getValorDiaria());
        myViewHolder.quantidadeCama.setText("Quantidade de cama:" + quarto.getQntdCamas());
        myViewHolder.quantidadeChuveiro.setText("Numero de chuveiro:" + quarto.getQntdChuveiros());
        if(quarto.isPossuiTv())
            myViewHolder.possuiTV.setText("Possui TV");
        else
            myViewHolder.possuiTV.setText("Não possui TV");
        myViewHolder.imgQuartos1.setImageBitmap(quarto.retornaImagem(0));
        myViewHolder.imgQuartos2.setImageBitmap(quarto.retornaImagem(1));
        myViewHolder.imgQuartos3.setImageBitmap(quarto.retornaImagem(2));
        myViewHolder.imgQuartos4.setImageBitmap(quarto.retornaImagem(3));
        myViewHolder.imgQuartos5.setImageBitmap(quarto.retornaImagem(4));
        //notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {

        return ldeQuartos.getSize();
    }

    //Inner Class  - classe para armazenar os dados dentro de cada elemento de lista
    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView numeroPorta;
        TextView valorDiaria;
        TextView quantidadeCama;
        TextView quantidadeChuveiro;
        TextView possuiTV;
        ImageView imgQuartos1,imgQuartos2,imgQuartos3,imgQuartos4,imgQuartos5;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            numeroPorta = itemView.findViewById(R.id.txtPorta);
            valorDiaria = itemView.findViewById(R.id.txtDiaria);
            quantidadeCama = itemView.findViewById(R.id.txtCama);
            quantidadeChuveiro = itemView.findViewById(R.id.txtChuveiro);
            possuiTV = itemView.findViewById(R.id.txtTV);
            imgQuartos1 = itemView.findViewById(R.id.imgQuartos1);
            imgQuartos2 = itemView.findViewById(R.id.imgQuartos2);
            imgQuartos3 = itemView.findViewById(R.id.imgQuartos3);
            imgQuartos4 = itemView.findViewById(R.id.imgQuartos4);
            imgQuartos5 = itemView.findViewById(R.id.imgQuartos5);
        }
    }
}
