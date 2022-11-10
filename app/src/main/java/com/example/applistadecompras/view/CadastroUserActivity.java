package com.example.applistadecompras.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.applistadecompras.R;
import com.example.applistadecompras.adapter.UserAdapter;
import com.example.applistadecompras.presenter.CadastroPresenterContract;
import com.example.applistadecompras.presenter.LoginPresenterContract;
import com.example.applistadecompras.repository.UserRepository;
import com.example.applistadecompras.repository.UserRepositoryInterface;
import com.google.android.material.snackbar.Snackbar;

public class CadastroUserActivity extends AppCompatActivity {


    private final String TAG = "LogingActivity";

    private UserRepository UserRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_user);

    UserRepository = new UserRepository();

        //captura o botao LAbutton1
        findViewById(R.id.buttonCAcadastrar).setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                UserRepository.addUser(
                        ((TextView) findViewById(R.id.editTextTextPersonNameCAlogin)).getText().toString(),
                        ((TextView) findViewById(R.id.editTextTextPersonNameCAsenha)).getText().toString()


                );
            Snackbar snackbar = Snackbar.make(view,"Usuário Cadastrado",Snackbar.LENGTH_LONG);
            snackbar.show();

                Log.d(TAG, "adicionado usuário" + UserRepository.getUsers().get(0).getLogin());
            }

        });


//organizando o adapter
        RecyclerView rc = findViewById(R.id.RecycleViewDeUsuarios);
        UserAdapter adapter = new UserAdapter(UserRepository.getUsers());
        rc.setAdapter(adapter);
        LinearLayoutManager llm1 = new LinearLayoutManager(getApplicationContext());
        rc.setLayoutManager(llm1);

    }


}