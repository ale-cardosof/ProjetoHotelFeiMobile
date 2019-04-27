package com.example.alexandrecardoso.projetohotelfei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.example.alexandrecardoso.projetohotelfei.menuUsuario.usuariosCadastrados;
import static com.example.alexandrecardoso.projetohotelfei.menuUsuario.pessoasCadastradas;

public class cadastroUser extends AppCompatActivity {
    private EditText edUsuario, edNome, edCPF,edData, edEmail, edCelular, edSenha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_user);
        getSupportActionBar().hide();
        edUsuario = findViewById(R.id.ednumPorta);
        edNome = findViewById(R.id.edValDiaria);
        edCPF = findViewById(R.id.edAvaliacao);
        edData = findViewById(R.id.edqtdCama);
        edEmail = findViewById(R.id.edqtdChuveiro);
        edCelular = findViewById(R.id.edCelular);
        edSenha = findViewById(R.id.edSenha);
    }

    public void cadastraUsuario(View view){
        Usuario novoUser = new Usuario();
        novoUser.setId(pessoasCadastradas);
        novoUser.setUsername(edUsuario.getText().toString());
        novoUser.setNome(edNome.getText().toString());
        novoUser.setCpf(edCPF.getText().toString());
        novoUser.setDataNascimento(edData.getText().toString());
        novoUser.setEmail(edEmail.getText().toString());
        novoUser.setCelular(edCelular.getText().toString());
        novoUser.setSenha(edSenha.getText().toString());
        usuariosCadastrados.add(novoUser);
        pessoasCadastradas++;
        // Volta para tela de Login
        Intent intent = new Intent(this, loginUser.class);
        startActivity(intent);

    }
}
