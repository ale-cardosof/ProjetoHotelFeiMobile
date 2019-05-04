package com.example.alexandrecardoso.projetohotelfei;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import static com.example.alexandrecardoso.projetohotelfei.Estruturas.*;
import static com.example.alexandrecardoso.projetohotelfei.menuEstruturaHotel.numeroQuarto;

public class menuAlterarQuarto extends AppCompatActivity {
    EditText edNumPorta, edValorDiaria, edAvaliacao, edqdtCama, edqtdChuveiro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_alterar_quarto);
        edNumPorta = findViewById(R.id.ednumPorta_);
        edValorDiaria = findViewById(R.id.edValDiaria_);
        edqdtCama = findViewById(R.id.edqtdCama_);
        edqtdChuveiro = findViewById(R.id.edqtdChuveiro_);
        //setDadosQuarto();

        // Retira barra superior com o nome do app
        getSupportActionBar().hide();
        this.setDadosQuarto();
    }
    public void limparCampos(){
        edNumPorta.setText("");
        edValorDiaria.setText("");
        edqdtCama.setText("");
        edqtdChuveiro.setText("");

    }

    public void setDadosQuarto(){
        int i;
       for(i=0; i <= Estruturas.ldeQuartos.getSize();i++){
            if(numeroQuarto == Estruturas.ldeQuartos.getByIndex(i).getNumPorta()){
                Log.d("Eita", "Diaria=" +Estruturas.ldeQuartos.getByIndex(i).getValorDiaria());
                edNumPorta.setText(""+Estruturas.ldeQuartos.getByIndex(i).getNumPorta());
                edValorDiaria.setText(""+Estruturas.ldeQuartos.getByIndex(i).getValorDiaria());
                edqdtCama.setText(""+ Estruturas.ldeQuartos.getByIndex(i).getQntdCamas());
                edqtdChuveiro.setText(""+Estruturas.ldeQuartos.getByIndex(i).getQntdChuveiros());
                break;

            }
            else{

            }

        }
}



    public void alteraQuarto(View view){
        int i;
        for(i=0; i <= Estruturas.ldeQuartos.getSize();i++){
            if(numeroQuarto == Estruturas.ldeQuartos.getByIndex(i).getNumPorta()){
                Estruturas.ldeQuartos.getByIndex(i).setValorDiaria(Double.parseDouble(edValorDiaria.getText().toString()));
                Estruturas.ldeQuartos.getByIndex(i).setQntdCamas(Integer.parseInt(edqdtCama.getText().toString()));
                Estruturas.ldeQuartos.getByIndex(i).setQntdChuveiros(Integer.parseInt(edqtdChuveiro.getText().toString()));
                break;
            }
            else{

            }
        }
        tela.exibir(getApplicationContext(),"Quarto alterado com sucesso!");
        limparCampos();
        finish();
    }
}
