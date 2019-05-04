package com.example.alexandrecardoso.projetohotelfei;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.alexandrecardoso.projetohotelfei.Estruturas.logado;


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

            // Cria variaveis
            int disp = 0;
            int pre = 0;
            int reserv = 0;
            int total = 0;

            // Calcula valores
            disp = ((Administrador)(Estruturas.logado.user)).getMeuHotel().getNumQuartosDisponiveis();
            pre = ((Administrador)(Estruturas.logado.user)).getMeuHotel().getNumQuartosPreReservados();
            reserv = ((Administrador)(Estruturas.logado.user)).getMeuHotel().getNumQuartosReservados();
            total = ((Administrador)(Estruturas.logado.user)).getMeuHotel().getNumQuartosExistentes();

            // Altera valor da tela
            quartosDisponiveis.setText(Integer.toString(disp));
            quantosPreReservados.setText(Integer.toString(pre));
            quartosReservados.setText(Integer.toString(reserv));
            quartosTotal.setText(Integer.toString(total));

        }else if(logado.tipoUser == 0){
            // Deslogado

        }else if(logado.tipoUser == 0){
            // Logado como usuário (nunca deve acontecer, já que está tela é uma tela de adm)
        }
    }
}
