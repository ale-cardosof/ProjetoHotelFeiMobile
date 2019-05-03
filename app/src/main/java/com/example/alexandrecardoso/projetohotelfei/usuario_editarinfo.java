package com.example.alexandrecardoso.projetohotelfei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.alexandrecardoso.projetohotelfei.menuUsuario.tela;

public class usuario_editarinfo extends AppCompatActivity {
    private EditText edNome, edCPF,edData, edEmail, edCelular;
    private TextView edUsuario;
    Usuario meuUsuario = Estruturas.usuariosCadastrados.busca(Estruturas.logado.username);
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
         edUsuario.setText("Alterando as informações de: " + meuUsuario.getUsername());
         edNome.setText(meuUsuario.getNome());
         edCPF.setText(meuUsuario.getCpf());
         edData.setText(meuUsuario.getDataNascimento());
         edEmail.setText(meuUsuario.getEmail());
         edCelular.setText(meuUsuario.getCelular());

     }

     public void editaInfo(View view){
         meuUsuario.setNome(edNome.getText().toString());
         meuUsuario.setCpf(edCPF.getText().toString());
         meuUsuario.setDataNascimento(edData.getText().toString());
         meuUsuario.setEmail(edEmail.getText().toString());
         meuUsuario.setCelular(edCelular.getText().toString());
         tela.exibir(getApplicationContext(),"Informações atualizadas com sucesso.");
         this.atualizaInfo();
     }

     public void alteraSenha(View view){
         Intent intent = new Intent(this, usuario_editarSenha.class);
         startActivity(intent);

     }
}
