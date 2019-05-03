package com.example.alexandrecardoso.projetohotelfei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class menuUsuario extends AppCompatActivity {

    // Variáveis Globais
    public static MensagemToast tela = new MensagemToast();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Inicia o Programa na Tela de seleção de Usuário
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_usuario);
        // Retira barra superior com o nome do app
        getSupportActionBar().hide();
        if(!Estruturas.criado)
            Estruturas.criaEstru();
    }

    public void abrirTelaADM(View view){
        Intent intent = new Intent(menuUsuario.this, loginAdm.class);
        startActivity(intent);

    }
    public void abrirTelaCliente(View view){
        Intent intent = new Intent(menuUsuario.this, loginUser.class);
        startActivity(intent);
    }

}
