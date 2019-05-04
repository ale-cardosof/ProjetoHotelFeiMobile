package com.example.alexandrecardoso.projetohotelfei;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import static com.example.alexandrecardoso.projetohotelfei.Estruturas.*;

public class menuInsercaoQuarto extends AppCompatActivity {
    private String[] permissoesNecessarias = new String[]{
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
    };
    private EditText edNumPorta, edValorDiaria, edAvaliacao, edqdtCama, edqtdChuveiro;
    private ImageButton imgCamera, imgGaleria;
    private ImageView imgQuarto1;
    private  static  final int SELECAO_CAMERA = 100;
    private  static  final int SELECAO_GALERIA = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_insercao_quarto);
        edNumPorta = findViewById(R.id.ednumPorta);
        edValorDiaria = findViewById(R.id.edValorDiaria);
        edqdtCama = findViewById(R.id.edQtdCama);
        edqtdChuveiro = findViewById(R.id.edqtdChuveiro);
        imgCamera = findViewById(R.id.imgCamera);
        imgGaleria = findViewById(R.id.imgGaleria);
        imgQuarto1 = findViewById(R.id.imgQuarto1);

        // Retira barra superior com o nome do app
        getSupportActionBar().hide();

        Permissao.validarPermissoes(permissoesNecessarias, this, 1);

        imgCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(i.resolveActivity(getPackageManager()) != null) {
                    //Start a activity e restaura a foto
                    startActivityForResult(i, SELECAO_CAMERA);
                }

            }
        });

        imgGaleria.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                if(i.resolveActivity(getPackageManager()) != null) {
                    //Start a activity e restaura a foto
                    startActivityForResult(i, SELECAO_GALERIA);
                }
            }
        });

        imgGaleria.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                if(i.resolveActivity(getPackageManager()) != null) {
                    //Start a activity e restaura a foto
                    startActivityForResult(i, SELECAO_GALERIA);
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            Bitmap imagem = null;
            try{
                switch (requestCode){
                    case SELECAO_CAMERA:
                        imagem = (Bitmap) data.getExtras().get("data");
                        break;
                    case SELECAO_GALERIA:
                        Uri localImagemSelecionada = data.getData();
                        imagem = MediaStore.Images.Media.getBitmap(getContentResolver(), localImagemSelecionada);
                        break;
                }

                if(imagem != null){
                    imgQuarto1.setImageBitmap(imagem);

                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for(int permissaoResultado : grantResults){
            if( permissaoResultado == PackageManager.PERMISSION_DENIED){
                alertaValidacaoPermissao();
            }
        }
    }

    public void alertaValidacaoPermissao(){
        //informar que precisa aceitar permissao
    }


    public void limparCampos(){
        edNumPorta.setText("");
        edValorDiaria.setText("");
        edqdtCama.setText("");
        edqtdChuveiro.setText("");
    }

    public boolean verificaPreenchimento(){
        if(edNumPorta.getText().toString().equals("") ||edValorDiaria.getText().toString().equals("")
        || edqdtCama.getText().toString().equals("") || edqtdChuveiro.getText().toString().equals("")){
            return  false;
        }
        return  true;
    }

    public void cadastraQuarto(View view){
        if(verificaPreenchimento()){
            Quarto novoQuarto = new Quarto();
        novoQuarto.setNumPorta(Integer.parseInt(edNumPorta.getText().toString()));
        novoQuarto.setValorDiaria(Double.parseDouble(edValorDiaria.getText().toString()));
        novoQuarto.setQntdCamas(Integer.parseInt(edqdtCama.getText().toString()));
        novoQuarto.setQntdChuveiros(Integer.parseInt(edqtdChuveiro.getText().toString()));
        novoQuarto.setPossuiTv(true);
        tela.exibir(getApplicationContext(),"Quarto cadastrado com sucesso!");
        Estruturas.ldeQuartos.insere(novoQuarto);
        limparCampos();
        }
        else{
            tela.exibir(getApplicationContext(),"Todos os campos precisam estar preenchidos!");
        }
    }
}
