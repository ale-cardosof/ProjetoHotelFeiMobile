package com.example.alexandrecardoso.projetohotelfei;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import static com.example.alexandrecardoso.projetohotelfei.menuUsuario.tela;

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
            Intent intent = new Intent(loginUser.this, UsuarioMenu.class);
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
        Long userProcuradoAsc = this.geraAsc(userProcurado);
        Usuario usuarioBuscado = Estruturas.usuariosCadastrados.busca(userProcuradoAsc);
        // Usuário encontrado
        if(usuarioBuscado != null){
            // Senha correta
            if(usuarioBuscado.getSenha().equals(senhaDigitada)){
                // Login efetuado
                // Guarda o usuario logado
                Estruturas.logado.user = usuarioBuscado;
                Estruturas.logado.username = userProcurado;
                Estruturas.logado.usernameASC = userProcuradoAsc;
                Estruturas.logado.tipoUser = 2;
                aux = 0;
                Estruturas.montarReservasUsuario();
                Log.d("UsuarioLogado", "Antes de criar user");
            }else{// Senha incorreta
                // Aviso sobre senha incorreta
                aux = 1;
            }
        }else{ // Usuário não existe
            // Aviso sobre usuario não existente
            aux = 2;
        }return aux;
    }

    public Long geraAsc(String entrada) {
        if(entrada.equals("")){
            return Long.parseLong("0");
        }else{
            /* Converte String pra ASC */
            String provisorio = "";
            char[] ascii2 = entrada.toCharArray();
            for(char ch:ascii2){
                provisorio = provisorio + (int)ch;
            }
            return Long.parseLong(provisorio);
        }
    }

    public void novoCadastro(View view){
        Intent intent = new Intent(this, cadastroUser.class);
        startActivity(intent);
    }

    public void onBackPressed(){
        Intent intent = new Intent(loginUser.this, menuUsuario.class);
        startActivity(intent);
    }
}
