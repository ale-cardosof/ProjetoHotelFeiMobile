package com.example.alexandrecardoso.projetohotelfei;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import static com.example.alexandrecardoso.projetohotelfei.menuUsuario.admsLogados;
import static com.example.alexandrecardoso.projetohotelfei.menuUsuario.logado;

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
        Boolean login = false;
        String admProcurado = input_username.getText().toString();
        String senhaDigitada = input_password.getText().toString();
        login = tryLogin(admProcurado,senhaDigitada);

        // Caso o login seja efetuado abre o menu principal
        if(login){
            Toast.makeText(getApplicationContext(), "Logado com sucesso!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, menuAdministrador.class);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(), "Falha ao Logar. Tente novamente", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean tryLogin(String admProcurado, String senhaDigitada){
        boolean aux = false;
        // Percorrendo o vetor de Administradores Cadastrados
        for(int i=0; i < admsLogados.size(); i++){
            // Usuário encontrado
            if(admsLogados.get(i).getUsername().equals(admProcurado)){
                // Senha correta
                if(admsLogados.get(i).getSenha().equals(senhaDigitada)){
                    // Login efetuado
                    // Guarda o usuario logado
                    logado.tipoUser = 1;
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


}
