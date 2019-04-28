package com.example.alexandrecardoso.projetohotelfei;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import static com.example.alexandrecardoso.projetohotelfei.menuUsuario.tela;
import static com.example.alexandrecardoso.projetohotelfei.menuUsuario.usuariosCadastrados;
import static com.example.alexandrecardoso.projetohotelfei.menuUsuario.logado;

public class loginUser extends AppCompatActivity {
    TextInputEditText input_username, input_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);
        getSupportActionBar().hide();
        input_username = findViewById(R.id.input_username);
        input_password = findViewById(R.id.input_password);
    }

    public void loginUser(View view){
        int login;
        String userProcurado = input_username.getText().toString();
        String senhaDigitada = input_password.getText().toString();
        login = tryLogin(userProcurado,senhaDigitada);

        // Caso o login seja efetuado abre o menu principal
        if(login == 0){
            tela.exibir(getApplicationContext(),"Logado com sucesso!");
            Intent intent = new Intent(this, usuarioMenu.class);
            startActivity(intent);
        }else if(login == 1){
            tela.exibir(getApplicationContext(),"Falha ao Logar (Senha Incorreta). Tente novamente");
        }else if(login == 2){
            tela.exibir(getApplicationContext(),"Falha ao Logar (Usuário Inválido). Tente novamente");
        }else if(login == 3){
            tela.exibir(getApplicationContext(),"Falha ao Logar (Erro Inesperado). Tente novamente");
        }
    }

    public int tryLogin(String userProcurado, String senhaDigitada){
        int aux = 3;
        // Percorrendo o vetor de Administradores Cadastrados
        for(int i=0; i < usuariosCadastrados.n; i++){
            // Usuário encontrado
            if(usuariosCadastrados.v[i].getUsername().equals(userProcurado)){
                // Senha correta
                if(usuariosCadastrados.v[i].getSenha().equals(senhaDigitada)){
                    // Login efetuado
                    // Guarda o usuario logado
                    logado.username = userProcurado;
                    logado.tipoUser = 2;
                    logado.posicao = i;
                    aux = 0;
                    break;
                }else{// Senha incorreta
                    // Aviso sobre senha incorreta
                    aux = 1;
                }
            }else{ // Usuário não existe
                // Aviso sobre usuario não existente
                aux = 2;
            }
        }
        return aux;
    }

    public void novoCadastro(View view){
        Intent intent = new Intent(this, cadastroUser.class);
        startActivity(intent);
    }


}
