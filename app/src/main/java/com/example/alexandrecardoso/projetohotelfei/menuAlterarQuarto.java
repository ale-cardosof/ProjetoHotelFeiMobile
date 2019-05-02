package com.example.alexandrecardoso.projetohotelfei;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import static com.example.alexandrecardoso.projetohotelfei.menuUsuario.quartosCriados;
import static com.example.alexandrecardoso.projetohotelfei.menuUsuario.tela;
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
       for(i=0; i <= quartosCriados.size();i++){
            if(numeroQuarto == quartosCriados.get(i).getNumPorta()){
                Log.d("Eita", "Diaria=" +quartosCriados.get(i).getValorDiaria());
                edNumPorta.setText(""+quartosCriados.get(i).getNumPorta());
                edValorDiaria.setText(""+quartosCriados.get(i).getValorDiaria());
                edqdtCama.setText(""+ quartosCriados.get(i).getQntdCamas());
                edqtdChuveiro.setText(""+quartosCriados.get(i).getQntdChuveiros());
                break;

            }
            else{

            }

        }
}



    public void alteraQuarto(View view){
        int i;
        for(i=0; i <= quartosCriados.size();i++){
            if(numeroQuarto == quartosCriados.get(i).getNumPorta()){
                quartosCriados.get(i).setValorDiaria(Double.parseDouble(edValorDiaria.getText().toString()));
                quartosCriados.get(i).setQntdCamas(Integer.parseInt(edqdtCama.getText().toString()));
                quartosCriados.get(i).setQntdChuveiros(Integer.parseInt(edqtdChuveiro.getText().toString()));
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
