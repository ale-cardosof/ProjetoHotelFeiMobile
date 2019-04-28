package com.example.alexandrecardoso.projetohotelfei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;


public class menuUsuario extends AppCompatActivity {

    // Variáveis Globais
    public static MensagemToast tela = new MensagemToast();
    public static LES_adm admsCadastrados = new LES_adm();
    public static LES_usu usuariosCadastrados = new LES_usu();

    public static ArrayList<Quarto> quartosCriados = new ArrayList();
    public static infoLogado logado = new infoLogado("",0,0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Inicia o Programa na Tela de seleção de Usuário
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_usuario);
        // Retira barra superior com o nome do app
        getSupportActionBar().hide();
        // Cria o adm padrão
        Administrador admInicial = new Administrador("admin","Administrador Inicial","123456789","01/01/2019","admin@admin.com.br","11954546565","admin");
        admsCadastrados.insere(admInicial);

        // Cria 10 quartos automáticos para o adm padrão
        for(int i=0; i < 10; i++){
            admInicial.insereQuarto(i,15,2,1,true);
        }
        // Cria o usuário padrão
        Usuario userInicial = new Usuario("user","User Inicial","123456789","01/01/2019","user@user.com.br","11954546565","user");
        usuariosCadastrados.insere(userInicial);
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
