package com.example.alexandrecardoso.projetohotelfei;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import static com.example.alexandrecardoso.projetohotelfei.menuUsuario.usuariosLogados;
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
        Boolean login = false;
        String userProcurado = input_username.getText().toString();
        String senhaDigitada = input_password.getText().toString();
        login = tryLogin(userProcurado,senhaDigitada);

        // Caso o login seja efetuado abre o menu principal
        if(login){
            Toast.makeText(getApplicationContext(), "Logado com sucesso!", Toast.LENGTH_SHORT).show();
            /* Abrir menu principal do Cliente
            Intent intent = new Intent(this, menuAdministrador.class);
            startActivity(intent);*/
        }else{
            Toast.makeText(getApplicationContext(), "Falha ao Logar. Tente novamente", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean tryLogin(String userProcurado, String senhaDigitada){
        boolean aux = false;
        // Percorrendo o vetor de Administradores Cadastrados
        for(int i=0; i < usuariosLogados.size(); i++){
            // Usuário encontrado
            if(usuariosLogados.get(i).getUsername().equals(userProcurado)){
                // Senha correta
                if(usuariosLogados.get(i).getSenha().equals(senhaDigitada)){
                    // Login efetuado
                    // Guarda o usuario logado
                    logado.tipoUser = 2;
                    logado.posicao = i;
                    aux = true;
                    break;
                }else{// Senha incorreta
                    // Aviso sobre senha incorreta
                    aux = false;
                }
            }else{ // Usuário não existe
                // Aviso sobre usuario não existente
                aux = false;
            }
        }
        return aux;
    }

    public void novoCadastro(View view){
        Intent intent = new Intent(this, cadastroUser.class);
        startActivity(intent);
    }


}
