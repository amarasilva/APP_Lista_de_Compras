package com.example.applistadecompras.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.applistadecompras.R;
import com.example.applistadecompras.model.User;
import com.example.applistadecompras.repository.UserSQLRepository;
import com.google.android.material.snackbar.Snackbar;

public class CadastroUserActivity extends AppCompatActivity {


    private final String TAG = "Cadastro User Activity";

    private UserSQLRepository banco;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        banco = new UserSQLRepository(getApplicationContext());

        setContentView(R.layout.activity_cadastro_user);


        //captura o botao LAbutton1
        findViewById(R.id.buttonCAcadastrar).setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                EditText etlogin = findViewById(R.id.editTextTextPersonNameCAlogin);
                EditText etsenha = findViewById(R.id.editTextTextPersonNameCAsenha);

                User u = new User(etlogin.getText().toString(),etsenha.getText().toString());

                banco.addUser(u);

            Snackbar snackbar = Snackbar.make(view,"Usuário Cadastrado ",Snackbar.LENGTH_LONG);
            snackbar.show();


              Log.d(TAG, "adicionado usuário"+ banco.getUsers());
            }

        });

        findViewById(R.id.buttonCALU).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), UsuariosCadastradosActivity.class);
                    startActivity(intent);
            }
        });



    }
}

