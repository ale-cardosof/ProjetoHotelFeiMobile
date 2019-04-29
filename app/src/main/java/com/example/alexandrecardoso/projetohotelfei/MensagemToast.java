package com.example.alexandrecardoso.projetohotelfei;

import android.content.Context;
import android.widget.Toast;

public class MensagemToast {

    public static void exibir(Context a,String mensagem){
        Toast.makeText(a, mensagem, Toast.LENGTH_SHORT).show();
    }

}
