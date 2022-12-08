package com.example.applistadecompras.presenter;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import com.example.applistadecompras.model.User;

public class LoginPresenterContract {

    public interface view {
        public void preferencesUserUpdate(int userId);
    }

    public interface presenter {

        public void checkLogin(View view, Context context, String login, String senha);

        public void validLogin(Context context, User user);


    }

}



