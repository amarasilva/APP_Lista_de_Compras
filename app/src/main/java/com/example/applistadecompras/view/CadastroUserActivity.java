package com.example.applistadecompras.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.applistadecompras.R;
import com.example.applistadecompras.repository.UserRepository;
import com.example.applistadecompras.repository.UserRepositoryInterface;

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
                        ((TextView) findViewById(R.id.editTextTextPasswordCAsenha)).getText().toString()


                );
                Log.d(TAG, "adicionado usuário" + UserRepository.getUsers().get(0).getLogin());
            }

        });




    }
}