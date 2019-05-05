package com.example.alexandrecardoso.projetohotelfei.Classes;

import android.content.Context;
import android.widget.Toast;

public class MensagemToast {

    public void exibir(Context context,String mensagem){
        Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show();
    }
}
