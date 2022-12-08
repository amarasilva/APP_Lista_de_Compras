package com.example.applistadecompras.presenter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.applistadecompras.model.User;
import com.example.applistadecompras.repository.UserSQLRepository;
import com.example.applistadecompras.view.CadastroListasActivity;
import com.google.android.material.snackbar.Snackbar;

public class LoginPresenter extends AppCompatActivity implements LoginPresenterContract.presenter {

    @Override
    public void checkLogin(View view, Context context, String login, String senha) {
        UserSQLRepository banco2;
        banco2 = new UserSQLRepository(context);

        User user = banco2.getUserByUserLogin(login);
        if (user != null) {
            if (user.getSenha().equals(senha)) {
                validLogin(context, user);
            } else {
                Snackbar snackbar = Snackbar.make(view, "Usuário Inválido ", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        } else {
            Snackbar snackbar = Snackbar.make(view, "Usuário em branco ou inválido ", Snackbar.LENGTH_LONG);
            snackbar.show();
        }

    }

    @Override
    public void validLogin(Context context, User user) {

        //SharedPreferences
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("user", user.getLogin());
        editor.apply();

        Intent intent = new Intent(context, CadastroListasActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("nomeUser", user.getLogin()); //aqui envia
        context.startActivity(intent);


    }
}