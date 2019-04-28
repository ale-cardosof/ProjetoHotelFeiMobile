package com.example.alexandrecardoso.projetohotelfei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.example.alexandrecardoso.projetohotelfei.menuUsuario.logado;
import static com.example.alexandrecardoso.projetohotelfei.menuUsuario.tela;
import static com.example.alexandrecardoso.projetohotelfei.menuUsuario.usuariosCadastrados;

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
        Usuario novoUser = new Usuario(edUsuario.getText().toString(),edNome.getText().toString(),edCPF.getText().toString(),edData.getText().toString(),edEmail.getText().toString(),edCelular.getText().toString(),edSenha.getText().toString());
        usuariosCadastrados.insere(novoUser);
        tela.exibir(getApplicationContext(),"Usuário cadastrado com sucesso!");
        // Volta para tela de Login
        Intent intent = new Intent(this, loginUser.class);
        startActivity(intent);
    }
}
