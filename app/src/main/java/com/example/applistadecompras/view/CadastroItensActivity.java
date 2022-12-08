package com.example.applistadecompras.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.applistadecompras.R;
import com.example.applistadecompras.adapter.ItensAdapter;
import com.example.applistadecompras.adapter.ListaAdapter;
import com.example.applistadecompras.model.Item;
import com.example.applistadecompras.model.Lista;
import com.example.applistadecompras.model.User;
import com.example.applistadecompras.repository.ItemSQLRepository;
import com.google.android.material.snackbar.Snackbar;

public class CadastroItensActivity extends AppCompatActivity {

    private final String TAG = "Cadastro Item Activity";

    String idLista;
    String nomeUser;
    //instancia do banco
    private ItemSQLRepository banco;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_itens);

        banco = new ItemSQLRepository(getApplicationContext());

        idLista = getIntent().getStringExtra("idLista");// aqui recebe
        nomeUser = getIntent().getStringExtra("nomeUser");// aqui recebe

        findViewById(R.id.buttonInsereItem).setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Log.d(TAG, ">:>:>:>:>:>:>" + idLista);

                String nomeItem = ((TextView) findViewById(R.id.editTextTextPersonNameCadastroItem)).getText().toString();
                Item item = new Item(Integer.parseInt(idLista), nomeItem);
                banco.addItem(idLista, item);

                Snackbar snackbar = Snackbar.make(view, "Item Cadastrado ", Snackbar.LENGTH_LONG);
                snackbar.show();
                Log.d(TAG, "adicionado item");

                Intent intent = new Intent(view.getContext(), CadastroItensActivity.class);
                intent.putExtra("idLista", idLista); //aqui envia a lista
                intent.putExtra("nomeUser", nomeUser); //aqui envia o usuario
                startActivity(intent);
            }

        });
        findViewById(R.id.buttonExcluiItem).setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                String nomeLista = ((TextView) findViewById(R.id.editTextTextPersonNameExclusaoItem)).getText().toString();
                Item item = new Item(Integer.parseInt(idLista), nomeLista);
                banco.deleteItem(idLista, item);

                Snackbar snackbar = Snackbar.make(view, "Item excluido ", Snackbar.LENGTH_LONG);
                snackbar.show();


                Intent intent = new Intent(view.getContext(), CadastroItensActivity.class);
                intent.putExtra("idLista", idLista); //aqui envia
                intent.putExtra("nomeUser", nomeUser);
                startActivity(intent);
            }

        });

        findViewById(R.id.buttonVoltarLista).setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), CadastroListasActivity.class);
                intent.putExtra("nomeUser", nomeUser); //aqui envia
                startActivity(intent);
            }


        });


        //organizando o adapter
        //nomeUser = getIntent().getStringExtra("nomeUser");// aqui recebe
        RecyclerView rc = findViewById(R.id.RecycleViewItens);
        ItensAdapter adapter = new ItensAdapter(banco, idLista);
        rc.setAdapter(adapter);
        LinearLayoutManager llm1 = new LinearLayoutManager(getApplicationContext());
        rc.setLayoutManager(llm1);


    }
}