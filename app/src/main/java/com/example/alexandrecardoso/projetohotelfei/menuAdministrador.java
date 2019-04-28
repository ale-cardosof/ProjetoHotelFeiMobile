package com.example.alexandrecardoso.projetohotelfei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import static com.example.alexandrecardoso.projetohotelfei.menuUsuario.logado;

public class menuAdministrador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_administrador);
        getSupportActionBar().hide();
    }


    public  void visualizarHotel(View view){
        Intent intent = new Intent(menuAdministrador.this, menuVisualizarHotel.class);
        startActivity(intent);
    }

    public void cadastrarFunc(View view){
        Intent intent = new Intent(menuAdministrador.this, menuCadastroNovoFuncionario.class);
        startActivity(intent);
    }

    public void estruturaHotel(View view){
        Intent intent = new Intent(menuAdministrador.this, menuEstruturaHotel.class);
        startActivity(intent);
    }

    public void deslogar(View view){
        logado.desloga();
        /* Logado com Sucesso */
        Toast.makeText(getApplicationContext(), "Administrador deslogado com sucesso!", Toast.LENGTH_SHORT).show();
        /* Voltando para o login do Adm */
        Intent intent = new Intent(menuAdministrador.this, loginAdm.class);
        startActivity(intent);
    }

}
