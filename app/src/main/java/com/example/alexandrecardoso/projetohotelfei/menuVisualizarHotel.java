package com.example.alexandrecardoso.projetohotelfei;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.alexandrecardoso.projetohotelfei.menuUsuario.admsLogados;
import static com.example.alexandrecardoso.projetohotelfei.menuUsuario.logado;

public class menuVisualizarHotel extends AppCompatActivity {
    TextView quartosDisponiveis,quantosPreReservados,quartosReservados,quartosTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_visualizar_hotel);
        getSupportActionBar().hide();
        // Verifica se esta logado
        if(logado.tipoUser == 1){
            // Cria conecções
            quartosDisponiveis = findViewById(R.id.quartosDisponiveis);
            quantosPreReservados = findViewById(R.id.quantosPreReservados);
            quartosReservados = findViewById(R.id.quartosReservados);
            quartosTotal = findViewById(R.id.quartosTotal);

            // Seleciona
            int disp,pre,reserv,total;

            //admsLogados.get(logado.posicao);

            // Altera valor da tela
            quartosDisponiveis.setText(Integer.toString(6));
            quantosPreReservados.setText(Integer.toString(2));
            quartosReservados.setText(Integer.toString(13));
            quartosTotal.setText(Integer.toString(150));


        }else if(logado.tipoUser == 0){
            // Deslogado

        }else if(logado.tipoUser == 0){
            // Logado como usuário (nunca deve acontecer, já que está tela é uma tela de adm)
        }
    }
}
