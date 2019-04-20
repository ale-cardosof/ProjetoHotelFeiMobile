package com.example.alexandrecardoso.projetohotelfei;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.example.alexandrecardoso.projetohotelfei.menuUsuario.admsLogados;

public class menuCadastroNovoFuncionario extends AppCompatActivity {
    private EditText edUsuario, edNome, edCPF,edData, edEmail, edCelular, edSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_cadastro_novo_funcionario);
        edUsuario = findViewById(R.id.ednumPorta);
        edNome = findViewById(R.id.edValDiaria);
        edCPF = findViewById(R.id.edAvaliacao);
        edData = findViewById(R.id.edqtdCama);
        edEmail = findViewById(R.id.edqtdChuveiro);
        edCelular = findViewById(R.id.edCelular);
        edSenha = findViewById(R.id.edSenha);

        // Retira barra superior com o nome do app
        getSupportActionBar().hide();
    }

    public void cadastraFuncionario(View view){
        Administrador novoUser = new Administrador();
        novoUser.setUsername(edUsuario.getText().toString());
        novoUser.setNome(edNome.getText().toString());
        novoUser.setCpf(edCPF.getText().toString());
        novoUser.setDataNascimento(edData.getText().toString());
        novoUser.setEmail(edEmail.getText().toString());
        novoUser.setCelular(edCelular.getText().toString());
        novoUser.setSenha(edSenha.getText().toString());
        admsLogados.add(novoUser);

    }
}
