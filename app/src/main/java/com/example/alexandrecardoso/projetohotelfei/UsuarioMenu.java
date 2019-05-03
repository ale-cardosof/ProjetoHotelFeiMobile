package com.example.alexandrecardoso.projetohotelfei;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static com.example.alexandrecardoso.projetohotelfei.menuUsuario.tela;

public class UsuarioMenu extends AppCompatActivity {

    private Button btnBuscarQuartos, btnReservas, btnInfo, btnFormasPgto, btnDeslogar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_menu);
        getSupportActionBar().hide();

        btnBuscarQuartos = findViewById(R.id.btnBuscarQuartos);
        btnReservas = findViewById(R.id.btnReservas);
        btnInfo = findViewById(R.id.btnInfo);
        btnFormasPgto = findViewById(R.id.btnFormasPgto);
        btnDeslogar = findViewById(R.id.btnDeslogar);

        btnBuscarQuartos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UsuarioMenu.this, UsuarioBuscarQuarto.class);
                startActivity(intent);
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UsuarioMenu.this, usuario_editarinfo.class);
                startActivity(intent);
            }
        });

        btnFormasPgto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UsuarioMenu.this, UsuarioReservas.class);
                startActivity(intent);
            }
        });

        btnReservas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UsuarioMenu.this, UsuarioReservas.class);
                startActivity(intent);
            }
        });

        btnDeslogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Estruturas.logado.desloga();
                /* Logado com Sucesso */
                Toast.makeText(getApplicationContext(), "Usuário deslogado com sucesso!", Toast.LENGTH_SHORT).show();
                /* Voltando para o login do Adm */
                Intent intent = new Intent(UsuarioMenu.this, loginUser.class);
                startActivity(intent);
            }
        });
    }
    public void onBackPressed(){
        boolean deslogar = true;
        new AlertDialog.Builder(this)
                .setTitle("Você esta prestes a deslogar.")
                .setMessage("Tem certeza que deseja deslogar?")
                .setPositiveButton("Sim",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Estruturas.logado.desloga();
                                /* Logado com Sucesso */
                                tela.exibir(getApplicationContext(),"Usuário deslogado com sucesso!");
                                /* Voltando para o login do Adm */
                                Intent intent = new Intent(UsuarioMenu.this, loginUser.class);
                                startActivity(intent);
                            }
                        })
                .setNegativeButton("Não", null)
                .show();
    }
}
