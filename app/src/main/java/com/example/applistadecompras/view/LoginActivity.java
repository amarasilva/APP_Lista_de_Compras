package com.example.applistadecompras.view;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.applistadecompras.R;
import com.example.applistadecompras.model.User;
import com.example.applistadecompras.presenter.LoginPresenter;
import com.example.applistadecompras.presenter.LoginPresenterContract;
import com.example.applistadecompras.repository.UserSQLRepository;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = "LogingActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
/*

        //SharedPreferences
        SharedPreferences preferences = getPreferences(0);
        //criando variaveis - por padrão falso/falso/-1
        boolean sqlUpdated = preferences.getBoolean("sqlUpdated", false);
        boolean logged = preferences.getBoolean("logged", false);
        int userId = preferences.getInt("userId", -1);

        Log.d("LoginActivity", "Preferences: " + sqlUpdated + ", " + logged + ", " + userId);
        //criando as condicionais
        if (userId >= 0 && sqlUpdated) {
            User u = UserSQLRepository.getInstance(getActivity()).getUserById(userId);
            if (u != null) {
                ((TextView) findViewById(R.id.editTextTextPersonNameLogin)).setText(u.getLogin());
            }
        }

  */


        findViewById(R.id.buttonEntrar).setOnClickListener(this);
        findViewById(R.id.button2Cadastrar).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String login = ((TextView) findViewById(R.id.editTextTextPersonNameLogin)).getText().toString();
        String senha = ((TextView) findViewById(R.id.editTextTextPasswordSenha)).getText().toString();
        if (view.getId() == R.id.buttonEntrar) {
            //chama o checkLogin
            LoginPresenter check = new LoginPresenter();

            check.checkLogin(this.findViewById(android.R.id.content), getApplicationContext(),
                    login,
                    senha
            );

        }
        if (view.getId() == R.id.button2Cadastrar) {
            Intent intent = new Intent(view.getContext(), CadastroUserActivity.class);
            Log.d(TAG, "enviando usuário >>>>>> "+ login);

            startActivity(intent);
        }
    }

    /*
    @Override
    public void preferencesUserUpdate(int userId) {
        SharedPreferences preferences = getPreferences(0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("userId", userId);
        editor.putBoolean("logged", true);
        editor.commit();
    }

     */
}