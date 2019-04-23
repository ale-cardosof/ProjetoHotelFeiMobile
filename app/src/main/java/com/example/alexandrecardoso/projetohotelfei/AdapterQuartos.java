package com.example.alexandrecardoso.projetohotelfei;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class AdapterQuartos extends PagerAdapter {
    private Context context;
    private int[] imgsQuartos;

    public AdapterQuartos(Context context, int[] imgsQuartos){
        this.context = context;
        this.imgsQuartos = imgsQuartos;
    }

    @Override
    public int getCount() {
        return imgsQuartos.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

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
