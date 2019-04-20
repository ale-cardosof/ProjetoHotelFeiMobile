package com.example.alexandrecardoso.projetohotelfei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

// Para ver em outra tela, usar:
// import static com.example.alexandrecardoso.projetohotelfei.MainActivity.admsLogados;


public class menuUsuario extends AppCompatActivity {
    // Cria variáveis globais (COLOCAR NA PRIMEIRA TELA CHAMADA PELO APP)
    public static Administrador admsLogados[] = new Administrador[5];
    //public static Usuario usuariosLogados[] = new Usuario[5];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Inicia o Programa na Tela de seleção de Usuário
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_usuario);
        // Retira barra superior com o nome do app
        getSupportActionBar().hide();
        // Cria o adm padrão
        Administrador admInicial = new Administrador("admin","Administrador Inicial","123456789","01/01/2019","admin@admin.com.br","11954546565","admin");
        admsLogados[0] = admInicial;
    }

    public void abrirTelaADM(View view){
        Intent intent = new Intent(menuUsuario.this, loginAdm.class);
        startActivity(intent);

    }
    public void abrirTelaCliente(View view){
        /* Quando criar, setar tela de login para cliente
        Intent intent = new Intent(menuUsuario.this, menuAdministrador.class);
        startActivity(intent);*/
        Toast toast = Toast.makeText(this, "Recurso não criado.",Toast.LENGTH_SHORT);
        toast.show();
    }

}
