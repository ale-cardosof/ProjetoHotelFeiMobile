package com.example.alexandrecardoso.projetohotelfei;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import static com.example.alexandrecardoso.projetohotelfei.menuUsuario.quartosCriados;

public class menuEstruturaHotel extends AppCompatActivity {

    public static int numeroQuarto;

    private RecyclerView listHoteis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_estrutura_hotel);
        getSupportActionBar().hide();
        listHoteis = findViewById(R.id.recyclerHotel);

        //Configuraando adapter
        AdapterQuartosInsert adapter = new AdapterQuartosInsert(quartosCriados);
        //Configurar recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        listHoteis.setLayoutManager(layoutManager);
        listHoteis.setHasFixedSize(true);
        listHoteis.setItemViewCacheSize(20);
        listHoteis.setDrawingCacheEnabled(true);
        listHoteis.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        listHoteis.setAdapter(adapter);

        //Eventos de click
        listHoteis.addOnItemTouchListener(
            new RecyclerItemClickListener(
                    getApplicationContext(),
                    listHoteis,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            menuOpcoes(position);
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        }
                    }
            )
        );

    }

    public void menuInsercao(View view){
        Intent intent = new Intent(menuEstruturaHotel.this, menuInsercaoQuarto.class);
        startActivity(intent);
    }

    public void menuOpcoes(final int position){
        //Alert Dialog
        AlertDialog.Builder dialog = new  AlertDialog.Builder(this);

        //Configurar titulo e msg
        dialog.setTitle("Menu de opções");
        dialog.setMessage("O que deseja fazer?");

        //Configura acoes para botão sim ou nao
        dialog.setPositiveButton("Alterar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),":",
                        Toast.LENGTH_SHORT).show();
                numeroQuarto = quartosCriados.get(position).getNumPorta();
                Log.d("Valor", ""+numeroQuarto);
                Intent intent = new Intent(menuEstruturaHotel.this, menuAlterarQuarto.class);
                startActivity(intent);

            }
        });
        dialog.setNegativeButton("Excluir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"O quarto foi excluido.",
                        Toast.LENGTH_SHORT).show();
                quartosCriados.remove(position);
            }
        });

        //Configura cancelamento
        dialog.setCancelable(true);

        //configurar icone

        dialog.setIcon(android.R.drawable.ic_dialog_alert);
        dialog.create();
        dialog.show();
    }

    public void atualizaAc(View v){
        finish();

        startActivity(getIntent());
    }
}
