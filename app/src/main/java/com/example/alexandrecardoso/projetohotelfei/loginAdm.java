package com.example.alexandrecardoso.projetohotelfei;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static com.example.alexandrecardoso.projetohotelfei.menuUsuario.admsCadastrados;
import static com.example.alexandrecardoso.projetohotelfei.menuUsuario.logado;
import static com.example.alexandrecardoso.projetohotelfei.menuUsuario.tela;

public class loginAdm extends AppCompatActivity {
    TextInputEditText input_username, input_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_adm);
        getSupportActionBar().hide();
        input_username = findViewById(R.id.input_username);
        input_password = findViewById(R.id.input_password);
    }

    public void loginAdm(View view){
        int login;
        String admProcurado = input_username.getText().toString();
        String senhaDigitada = input_password.getText().toString();
        login = tryLogin(admProcurado,senhaDigitada);

        // Caso o login seja efetuado abre o menu principal
        if(login == 0){
            tela.exibir(getApplicationContext(),"Logado com sucesso!");
            Intent intent = new Intent(this, menuAdministrador.class);
            startActivity(intent);
        }else if(login == 1){
            tela.exibir(getApplicationContext(),"Falha ao Logar (Senha Incorreta). Tente novamente");
        }else if(login == 2){
            tela.exibir(getApplicationContext(),"Falha ao Logar (Usuário Inválido). Tente novamente");
        }else if(login == 3){
            tela.exibir(getApplicationContext(),"Falha ao Logar (Erro Inesperado). Tente novamente");
        }
    }

    public int tryLogin(String admProcurado, String senhaDigitada){
        int aux=3;
        // Percorrendo o vetor de Administradores Cadastrados
        for(int i=0; i < admsCadastrados.n; i++){
            // Usuário encontrado
            if(admsCadastrados.busca(admProcurado) != -1){
                // Senha correta
                if(admsCadastrados.v[i].getSenha().equals(senhaDigitada)){
                    // Login efetuado
                    // Guarda o usuario logado
                    logado.username = admProcurado;
                    logado.tipoUser = 1;
                    logado.posicao = i;
                    aux = 0;
                    break;
                }else{ // Senha incorreta
                    // Senha incorreta
                    aux = 1;
                }
            }else{ // Usuário não existe
                // Usuario não existente
                aux = 2;
            }
        }
        return aux;
    }


}
