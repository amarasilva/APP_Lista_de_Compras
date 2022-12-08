package com.example.applistadecompras.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.applistadecompras.R;
import com.example.applistadecompras.adapter.UserAdapter;
import com.example.applistadecompras.model.User;
import com.example.applistadecompras.repository.UserSQLRepository;
import com.google.android.material.snackbar.Snackbar;

public class UsuariosCadastradosActivity extends AppCompatActivity {

    private final String TAG = "UsuariosCadastradosActivity";

    //instancia do banco
    UserSQLRepository banco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios_cadastrados);

        banco = new UserSQLRepository(getApplicationContext());

        //captura Do botao EXCLUIR
        findViewById(R.id.buttonExcluirUser).setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                EditText exLogin = findViewById(R.id.editTextTextPersonNameExcluirLogin);

                User u = new User(exLogin.getText().toString(), "");

                banco.delete(u);

                //menssagem exibida na tela
                Snackbar snackbar = Snackbar.make(view, "Usuário Excluido ", Snackbar.LENGTH_LONG);
                snackbar.show();

            }
        });

        //organizando o adapter
        RecyclerView rc = findViewById(R.id.RecycleViewUsuarios);
        UserAdapter adapter = new UserAdapter(banco);
        rc.setAdapter(adapter);
        LinearLayoutManager llm1 = new LinearLayoutManager(getApplicationContext());
        rc.setLayoutManager(llm1);


    }
}
