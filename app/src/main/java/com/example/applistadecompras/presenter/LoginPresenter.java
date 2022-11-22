package com.example.applistadecompras.presenter;

import android.content.ContentValues;
import android.content.Intent;
import android.view.View;

import com.example.applistadecompras.model.User;
import com.example.applistadecompras.repository.UserSQLRepository;
import com.example.applistadecompras.view.ListaActivity;
import com.google.android.material.snackbar.Snackbar;

public class LoginPresenter implements LoginPresenterContract.presenter {

    private UserSQLRepository banco;

    private View view;

    @Override
    public void checkLogin(String login, String senha) {

        if (banco.getUsers() == null || !banco.getUsers().equals(senha)) {
            Snackbar snackbar = Snackbar.make(view,"Usuário Inválido ",Snackbar.LENGTH_LONG);
            snackbar.show();
        } else {
            validLogin(null);
        }
    }

    @Override
    public void validLogin(User user) {
        Intent intent = new Intent(view.getContext(), ListaActivity.class);
        //view.preferencesUserUpdate(user.getId());
        view.getContext().startActivity(intent);


    }
}