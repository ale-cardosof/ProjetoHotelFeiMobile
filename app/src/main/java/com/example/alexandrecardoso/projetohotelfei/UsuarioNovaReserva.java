package com.example.alexandrecardoso.projetohotelfei;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.TtsSpan;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UsuarioNovaReserva extends AppCompatActivity {

    private Button btnDataEntrada, btnDataSaida, btnDataReserva;
    private CalendarView cvDataReserva;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_nova_reserva);

        btnDataEntrada = findViewById(R.id.btnDataEntrada);
        btnDataSaida = findViewById(R.id.btnDataSaida);
        cvDataReserva = findViewById(R.id.cvDataReserva);

        if (cvDataReserva.getVisibility() == CalendarView.VISIBLE) {
            cvDataReserva.setVisibility(CalendarView.GONE);
        }

        btnDataEntrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Clicou", "Entrada");
                //setTextDataReserva(txtDataEntrada);
                if (cvDataReserva.getVisibility() == CalendarView.VISIBLE) {
                    cvDataReserva.setVisibility(CalendarView.GONE);
                } else {
                    cvDataReserva.setVisibility(CalendarView.VISIBLE);
                }
                btnDataReserva = btnDataEntrada;
            }
        });

        btnDataSaida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Clicou", "Saida");
                if (cvDataReserva.getVisibility() == CalendarView.VISIBLE) {
                    cvDataReserva.setVisibility(CalendarView.GONE);
                } else {
                    cvDataReserva.setVisibility(CalendarView.VISIBLE);
                }
                btnDataReserva = btnDataSaida;
            }
        });


        cvDataReserva.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                btnDataReserva.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                cvDataReserva.setVisibility(CalendarView.GONE);

                if (btnDataReserva == btnDataSaida) {
                    try {
                        String dataEntrada = btnDataEntrada.getText().toString();
                        String dataSaida = btnDataSaida.getText().toString();

                        String dataSplit[];
                        dataSplit = dataEntrada.split("/");

                        int diaEntrada = Integer.parseInt(dataSplit[0]);
                        int mesEntrada = Integer.parseInt(dataSplit[1]) - 1;
                        int anoEntrada = Integer.parseInt(dataSplit[2]);

                        SimpleDateFormat df = new SimpleDateFormat("dd-MM-YYYY");

                        Date dtEntrada = new Date(anoEntrada - 1900, mesEntrada, diaEntrada);

                        Date dtSaida = new Date(year - 1900, month, dayOfMonth);

                        if(dtEntrada.compareTo(dtSaida) == 1) {
                            btnDataSaida.setText("Data de Saida");
                            btnDataEntrada.setText("Data de entrada");
                            throw new Exception("A data de entrada não pode ser maior que a data de saida!");
                        }

//                        Log.d("Data: ", "Data Entrada : " + df.format(dtEntrada));
//                        Log.d("Data: ", "Data Saida : " + df.format(dtSaida));
//                        Log.d("Data: ", "Compare Entrada : " + dtEntrada.compareTo(dtSaida));
//                        Log.d("Data: ", "Compare Saida : " + dtSaida.compareTo(dtEntrada));
//
//                        Log.d("Data: ", "DiffData Saida : " + diffData(dtEntrada, dtSaida));

                        int diasHosp = diffData(dtEntrada, dtSaida);



                    } catch (Exception e) {
                        Log.d("Data: ", "Data Erro : " + e);
                    }
                }
            }
        });
    }


    private int diffData(Date dtEntrada, Date dtSaida){

        Calendar cDtEntrada = Calendar.getInstance();
        Calendar cDtSaida = Calendar.getInstance();

        cDtEntrada.setTime(dtEntrada);
        cDtSaida.setTime(dtSaida);

        if (cDtEntrada.get(Calendar.YEAR) == cDtSaida.get(Calendar.YEAR)){
            return cDtSaida.get(Calendar.DAY_OF_YEAR) - cDtEntrada.get(Calendar.DAY_OF_YEAR);
        }else{
            Calendar cDtUltimoDiaAno = Calendar.getInstance();
            Date dtUltDia = new Date(cDtEntrada.get(Calendar.YEAR) - 1900, 11, 31);
            cDtUltimoDiaAno.setTime(dtUltDia);
            Log.d("Data: ", "Data Diif Saida : " + dtUltDia);

            int diasRest = cDtUltimoDiaAno.get(Calendar.DAY_OF_YEAR) - cDtEntrada.get(Calendar.DAY_OF_YEAR);

            return diasRest + cDtSaida.get(Calendar.DAY_OF_YEAR);
        }
    }
}
