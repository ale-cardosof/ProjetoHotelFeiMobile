package com.example.alexandrecardoso.projetohotelfei;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class AdapterQuartos extends PagerAdapter {
    private Context context;
    private int[] imgsQuartos = new int[5];
    private int qtdQuartos;

    public AdapterQuartos(Context context, ArrayList<Quarto> alQuartos) {
        this.context = context;
        this.qtdQuartos =  alQuartos.size();
        for (int i = 0; i < alQuartos.size(); i++)
            this.imgsQuartos[i] = alQuartos.get(i).getImagemQuarto();

    }

    public AdapterQuartos(Context context, Quarto quarto) {
        this.context = context;
        this.qtdQuartos =  1;
        this.imgsQuartos[0] = quarto.getImagemQuarto();
    }

    @Override
    public int getCount() {
        return qtdQuartos;
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        LinearLayout liImgs = new LinearLayout(context);
        liImgs.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams liParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        liImgs.setLayoutParams(liParams);
        container.addView(liImgs);

        ImageView imvQuartos = new ImageView(context);
        imvQuartos.setImageResource(imgsQuartos[position]);
        liImgs.addView(imvQuartos);

        return liImgs;
    }
}