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
import com.example.applistadecompras.adapter.ListaAdapter;
import com.example.applistadecompras.model.Lista;
import com.example.applistadecompras.model.User;
import com.example.applistadecompras.repository.ListaSQLRepository;
import com.google.android.material.snackbar.Snackbar;

public class CadastroListasActivity extends AppCompatActivity {

    private final String TAG = "CadastroListaActivity";

    String nomeUser;

    //instancia do banco
    private ListaSQLRepository banco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_listas);

        banco = new ListaSQLRepository(getApplicationContext());

        nomeUser = getIntent().getStringExtra("nomeUser");// aqui recebe

        Log.d(TAG, "recebido usuário >>>>>> " + nomeUser);
        findViewById(R.id.buttonInsereLista).setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                String nomeLista = ((TextView) findViewById(R.id.editTextTextPersonNameCadastroLista)).getText().toString();
                Lista lista = new Lista(-1, nomeLista, new User(nomeUser, ""));

                //adição de lista
                banco.addLista(lista);

                Snackbar snackbar = Snackbar.make(view, "Lista Cadastrada ", Snackbar.LENGTH_LONG);
                snackbar.show();
                Log.d(TAG, "adicionado usuário" + banco.getLista().get(0).getNome());

                Intent intent = new Intent(view.getContext(), CadastroItensActivity.class);
                String idLista = banco.getListaByLoginID(nomeUser, nomeLista).get(0).getId() + "";
                Log.d(TAG, "adicionado lista num " + idLista);
                intent.putExtra("idLista", idLista); //aqui envia
                intent.putExtra("nomeUser", nomeUser); //aqui envia
                startActivity(intent);
            }

        });
        findViewById(R.id.buttonExcluiLista).setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                String nomeLista = ((TextView) findViewById(R.id.editTextTextPersonNameExclusaoLista)).getText().toString();
                Lista lista = new Lista(-1, nomeLista, new User(nomeUser, ""));

                //exclusão de lista
                banco.deleteLista(lista);

                Snackbar snackbar = Snackbar.make(view, "Lista excluida ", Snackbar.LENGTH_LONG);
                snackbar.show();


                Intent intent = new Intent(view.getContext(), CadastroListasActivity.class);
                intent.putExtra("nomeUser", nomeUser); //aqui envia
                startActivity(intent);
            }

        });

/*
        findViewById(R.id.buttonExcluiLista).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                EditText excLista = findViewById(R.id.editTextTextPersonNameListaExclusao);

                Lista l = new Lista(-1,excLista,new User("adm",""));

                banco.deleteLista(l);

                Snackbar snackbar = Snackbar.make(view,"Lista excluida",Snackbar.LENGTH_LONG);
                snackbar.show();

                Log.d(TAG, "lista excluida"+ banco.getLista().get(0).getNome());
            }

        });
*/


        //organizando o adapter
        //nomeUser = getIntent().getStringExtra("nomeUser");// aqui recebe
        RecyclerView rc = findViewById(R.id.RecycleViewLista);
        ListaAdapter adapter = new ListaAdapter(banco, nomeUser);
        rc.setAdapter(adapter);
        LinearLayoutManager llm1 = new LinearLayoutManager(getApplicationContext());
        rc.setLayoutManager(llm1);

    }


}