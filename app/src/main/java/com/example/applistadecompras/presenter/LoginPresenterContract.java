package com.example.applistadecompras.presenter;

import android.app.Activity;

import com.example.applistadecompras.model.User;

public class LoginPresenterContract {


    public interface view {
        public void message(String msg);

    }

    public interface presenter {
        public void checkLogin(String login, String senha);
        public void validLogin(User user);

    }

}



