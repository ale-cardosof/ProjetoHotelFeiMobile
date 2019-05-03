package com.example.alexandrecardoso.projetohotelfei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.example.alexandrecardoso.projetohotelfei.menuUsuario.tela;

public class cadastroUser extends AppCompatActivity {
    private EditText edUsuario, edNome, edCPF,edData, edEmail, edCelular, edSenha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_user);
        getSupportActionBar().hide();
        edUsuario = findViewById(R.id.ednumPorta);
        edNome = findViewById(R.id.edSenhaAntiga);
        edCPF = findViewById(R.id.edSenhaNova);
        edData = findViewById(R.id.edSenhaNovaDois);
        edEmail = findViewById(R.id.edqtdChuveiro);
        edCelular = findViewById(R.id.edCelular);
        edSenha = findViewById(R.id.edSenha);
    }

    public void cadastraUsuario(View view){
        // Verifica se o username digitado tem menos de 6 caracteres
        if(edUsuario.getText().toString().length() <= 6){
            Usuario novoUser = new Usuario(edUsuario.getText().toString(),edNome.getText().toString(),edCPF.getText().toString(),edData.getText().toString(),edEmail.getText().toString(),edCelular.getText().toString(),edSenha.getText().toString());
            Estruturas.usuariosCadastrados.insere(novoUser);
            tela.exibir(getApplicationContext(),"Usuário cadastrado com sucesso!");
            // Volta para tela de Login
            Intent intent = new Intent(this, loginUser.class);
            startActivity(intent);
        }else{
            edUsuario.setText("");
            tela.exibir(getApplicationContext(),"Nome do Usuário inválido (mais de 6 caracteres)");
        }
    }
}
