package com.example.alexandrecardoso.projetohotelfei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.alexandrecardoso.projetohotelfei.Estruturas.logado;
import static com.example.alexandrecardoso.projetohotelfei.Estruturas.tela;

public class usuario_editarinfo extends AppCompatActivity {
    private EditText edNome, edCPF,edData, edEmail, edCelular;
    private TextView edUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_editarinfo);
        getSupportActionBar().hide();
        this.atualizaInfo();
     }

     public void atualizaInfo(){
         edUsuario = findViewById(R.id.nomeDoUser);
         // Cria referencia para cada uma das caixas
         edNome = findViewById(R.id.edSenhaAntiga);
         edCPF = findViewById(R.id.edSenhaNova);
         edData = findViewById(R.id.edSenhaNovaDois);
         edEmail = findViewById(R.id.edqtdChuveiro);
         edCelular = findViewById(R.id.edCelular);

         // Edita as caixas com os valores atuais do usuário logado
         edUsuario.setText("Alterando as informações de: " + logado.user.getUsername());
         edNome.setText(logado.user.getNome());
         edCPF.setText(logado.user.getCpf());
         edData.setText(logado.user.getDataNascimento());
         edEmail.setText(logado.user.getEmail());
         edCelular.setText(logado.user.getCelular());

     }

     public void editaInfo(View view){
         logado.user.setNome(edNome.getText().toString());
         logado.user.setCpf(edCPF.getText().toString());
         logado.user.setDataNascimento(edData.getText().toString());
         logado.user.setEmail(edEmail.getText().toString());
         logado.user.setCelular(edCelular.getText().toString());
         tela.exibir(getApplicationContext(),"Informações atualizadas com sucesso.");
         this.atualizaInfo();
     }

     public void alteraSenha(View view){
         Intent intent = new Intent(this, usuario_editarSenha.class);
         startActivity(intent);

     }
}
