package com.example.applistadecompras.repository;

import com.example.applistadecompras.model.User;


import java.util.List;

public interface UserRepositoryInterface {

    public List<User> getUsers();
    public User getUserById(int id);
    public List<User> getUsersByName(String name);
    public void addUser(String login, String senha);
    public User deleteUser(User user) ;
}
