package com.example.alexandrecardoso.projetohotelfei;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.alexandrecardoso.projetohotelfei.Estruturas.*;

public class UsuarioAvaliacao extends AppCompatActivity {

    public static Quarto quartoStatic;
    private Quarto quartoAtual;
    private EditText txtTitulo, txtMensagem, txtNota;
    private Button btnSalvar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_avaliacao);
        getSupportActionBar().hide();

        txtTitulo = findViewById(R.id.txtTitulo);
        txtMensagem = findViewById(R.id.txtMensagem);
        txtNota = findViewById(R.id.txtNota);
        btnSalvar = findViewById(R.id.btnSalvar);

        if(quartoStatic != null)
            quartoAtual = quartoStatic;

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (String.valueOf(txtTitulo.getText()).isEmpty()
                 || String.valueOf(txtMensagem.getText()).isEmpty()
                 || String.valueOf(txtNota.getText()).isEmpty()){
                    tela.exibir(UsuarioAvaliacao.this, "Por favor, preencha todos os campos!");
                }else if(Integer.parseInt(txtNota.getText().toString()) < 0
                    || Integer.parseInt(txtNota.getText().toString()) > 5 ){
                    tela.exibir(UsuarioAvaliacao.this, "A nota deve ser de 0 a 5.");
                }
                else{
                    Avaliacao avUsuario = new Avaliacao(txtTitulo.getText().toString(), Double.parseDouble(txtNota.getText().toString()), String.valueOf(txtMensagem.getText()));
                    quartoAtual.setAvaliacoes(avUsuario);
                }
            }
        });
    }
}
