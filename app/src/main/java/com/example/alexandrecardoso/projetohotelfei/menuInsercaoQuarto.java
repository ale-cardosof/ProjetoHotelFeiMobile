package com.example.alexandrecardoso.projetohotelfei;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.example.alexandrecardoso.projetohotelfei.menuUsuario.tela;

public class menuInsercaoQuarto extends AppCompatActivity {
    EditText edNumPorta, edValorDiaria, edAvaliacao, edqdtCama, edqtdChuveiro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_insercao_quarto);
        edNumPorta = findViewById(R.id.ednumPorta);
        edValorDiaria = findViewById(R.id.edValorDiaria);
        edqdtCama = findViewById(R.id.edQtdCama);
        edqtdChuveiro = findViewById(R.id.edqtdChuveiro);

        // Retira barra superior com o nome do app
        getSupportActionBar().hide();

    }

    public void limparCampos(){
        edNumPorta.setText("");
        edValorDiaria.setText("");
        edqdtCama.setText("");
        edqtdChuveiro.setText("");
    }

    public boolean verificaPreenchimento(){
        if(edNumPorta.getText().toString().equals("") ||edValorDiaria.getText().toString().equals("")
        || edqdtCama.getText().toString().equals("") || edqtdChuveiro.getText().toString().equals("")){
            return  false;
        }
        return  true;
    }

    public void cadastraQuarto(View view){
        if(verificaPreenchimento()){
            Quarto novoQuarto = new Quarto();
        novoQuarto.setNumPorta(Integer.parseInt(edNumPorta.getText().toString()));
        novoQuarto.setValorDiaria(Double.parseDouble(edValorDiaria.getText().toString()));
        novoQuarto.setQntdCamas(Integer.parseInt(edqdtCama.getText().toString()));
        novoQuarto.setQntdChuveiros(Integer.parseInt(edqtdChuveiro.getText().toString()));
        novoQuarto.setPossuiTv(true);
        tela.exibir(getApplicationContext(),"Quarto cadastrado com sucesso!");
        Estruturas.alQuartos.insere(novoQuarto);
        limparCampos();
        }
        else{
            tela.exibir(getApplicationContext(),"Todos os campos precisam estar preenchidos!");
        }
    }
}
