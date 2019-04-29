package com.example.alexandrecardoso.projetohotelfei;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.example.alexandrecardoso.projetohotelfei.menuUsuario.quartosCriados;

public class menuInsercaoQuarto extends AppCompatActivity {
    EditText edNumPorta, edValorDiaria, edAvaliacao, edqdtCama, edqtdChuveiro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_insercao_quarto);
        edNumPorta = findViewById(R.id.ednumPorta);
        edValorDiaria = findViewById(R.id.edValDiaria);
        edqdtCama = findViewById(R.id.edqtdCama);
        edqtdChuveiro = findViewById(R.id.edqtdChuveiro);

        // Retira barra superior com o nome do app
        getSupportActionBar().hide();

    }

    public void cadastraQuarto(View view){
        Quarto novoQuarto = new Quarto();
        novoQuarto.setNumPorta(Integer.parseInt(edNumPorta.getText().toString()));
        novoQuarto.setValorDiaria(Double.parseDouble(edValorDiaria.getText().toString()));
        novoQuarto.setQntdCamas(Integer.parseInt(edqdtCama.getText().toString()));
        novoQuarto.setQntdChuveiros(Integer.parseInt(edqtdChuveiro.getText().toString()));
        novoQuarto.setPossuiTv(true);
        MensagemToast.exibir(getApplicationContext(),"Quarto cadastrado com sucesso!");
        quartosCriados.add(novoQuarto);
    }
}
