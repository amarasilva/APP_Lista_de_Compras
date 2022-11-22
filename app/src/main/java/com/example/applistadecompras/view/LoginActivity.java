package com.example.applistadecompras.view;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.applistadecompras.R;
import com.example.applistadecompras.model.User;
import com.example.applistadecompras.presenter.LoginPresenterContract;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = "LogingActivity";

    //private LoginPresenterContract.presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.d(TAG, "iniciando o APP");

        findViewById(R.id.buttonEntrar).setOnClickListener(this);
        findViewById(R.id.button2Cadastrar).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonEntrar) {
            //chama o checkLogin
            LoginPresenterContract.presenter.checkLogin(
                    ((TextView) findViewById(R.id.editTextTextPersonNameLogin)).getText().toString(),
                    ((TextView) findViewById(R.id.editTextTextPasswordSenha)).getText().toString()


            );

        }
        if (view.getId() == R.id.button2Cadastrar) {
            Intent intent = new Intent(view.getContext(), CadastroUserActivity.class);
            startActivity(intent);
        }
    }


}