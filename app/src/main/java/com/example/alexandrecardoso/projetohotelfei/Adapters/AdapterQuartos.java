package com.example.alexandrecardoso.projetohotelfei.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.alexandrecardoso.projetohotelfei.Classes.Quarto;
import com.example.alexandrecardoso.projetohotelfei.Estruturas_.LDE;
import com.example.alexandrecardoso.projetohotelfei.Estruturas_.LES;
import com.example.alexandrecardoso.projetohotelfei.R;


public class AdapterQuartos extends PagerAdapter {
    private Context context;
    private LES<Bitmap> imgsQuartos = new LES<>();
    private LDE<Quarto> ldeQuartos;
    private int qtdQuartos;
    private Quarto quartoAtual;
    private boolean meuBool;

    public AdapterQuartos(Context context, LDE<Quarto> ldeQuartos) {
        this.context = context;
        this.qtdQuartos =  ldeQuartos.getSize();
        this.ldeQuartos = ldeQuartos;
        this.meuBool = true;
    }

    public AdapterQuartos(Context context, Quarto quarto) {
        this.context = context;
        this.qtdQuartos =  1;
        this.imgsQuartos = quarto.getLesImagens();
        this.meuBool = false;
        this.quartoAtual = quarto;
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

        LinearLayout liImgs = new LinearLayout(context);
        liImgs.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams liParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        liImgs.setLayoutParams(liParams);
        container.addView(liImgs);

        ImageView imvQuartos = new ImageView(context);

        if(meuBool){
            if(ldeQuartos.getByIndex(position).retornaImagem(0) != null)
                imvQuartos.setImageBitmap(ldeQuartos.getByIndex(position).retornaImagem(0));
            else{
                //Bitmap icon = BitmapFactory.decodeResource(context.getResources(), ldeQuartos.getByIndex(position).getq);
                imvQuartos.setImageResource(ldeQuartos.getByIndex(position).getQuartoImg());
            }
        }else{
            if(imgsQuartos.busca(position) != null)
                imvQuartos.setImageBitmap(imgsQuartos.busca(position));
            else{
                //Bitmap icon = BitmapFactory.decodeResource(context.getResources(), R.drawable.quarto_10);
                //imvQuartos.setImageBitmap(icon);
                imvQuartos.setImageResource(quartoAtual.getQuartoImg());

                Log.d("HOTELMOBILE","Quartos : " + quartoAtual.getQuartoImg());
            }
        }

        liImgs.addView(imvQuartos);

        return liImgs;
    }
}
