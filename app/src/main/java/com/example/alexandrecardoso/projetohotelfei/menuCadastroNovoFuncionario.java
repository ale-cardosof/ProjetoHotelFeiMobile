package com.example.alexandrecardoso.projetohotelfei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.example.alexandrecardoso.projetohotelfei.menuUsuario.admsCadastrados;
import static com.example.alexandrecardoso.projetohotelfei.menuUsuario.logado;
import static com.example.alexandrecardoso.projetohotelfei.menuUsuario.tela;

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
        // Verifica se o username digitado tem menos de 6 caracteres
        if(edUsuario.getText().toString().length() <= 6){
            Administrador novoUser = new Administrador(edUsuario.getText().toString(),edNome.getText().toString(),edCPF.getText().toString(),edData.getText().toString(),edEmail.getText().toString(),edCelular.getText().toString(),edSenha.getText().toString());
            admsCadastrados.insere(novoUser);
            logado.atualizaPosicao(); // Atualizando a posição do Logado
            tela.exibir(getApplicationContext(),"Novo Administrador Cadastrado com sucesso.");
            Intent intent = new Intent(this, menuAdministrador.class);
            startActivity(intent);
        }else{
            edUsuario.setText("");
            tela.exibir(getApplicationContext(),"Nome do Usuário inválido (mais de 6 caracteres)");
        }
    }
}
