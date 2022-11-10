package com.example.applistadecompras.repository;

import android.content.Context;

import com.example.applistadecompras.model.User;
import com.example.applistadecompras.presenter.CadastroPresenterContract;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements UserRepositoryInterface {

    private List<User> users;
    private Context contexto;

    //construtor
    public UserRepository() {
        super();
            users = new ArrayList<>();

    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public List<User> getUsersByName(String name) {
        return null;
    }

    @Override
    public void addUser(String login, String senha) {
        User u = new User(1, login, senha);
        users.add(u);

    }

    @Override
    public User deleteUser(User user) {
        return null;
    }


}
