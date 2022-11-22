package com.example.applistadecompras.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.applistadecompras.R;
import com.example.applistadecompras.adapter.UserAdapter;
import com.example.applistadecompras.repository.UserSQLRepository;

public class UsuariosCadastradosActivity extends AppCompatActivity {


    UserSQLRepository banco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios_cadastrados);

        banco = new UserSQLRepository(getBaseContext());

        //organizando o adapter
        RecyclerView rc = findViewById(R.id.RecycleViewUsuarios);
        UserAdapter adapter = new UserAdapter(banco);
        rc.setAdapter(adapter);
        LinearLayoutManager llm1 = new LinearLayoutManager(getApplicationContext());
        rc.setLayoutManager(llm1);


    }


}