package com.example.applistadecompras.repository;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.applistadecompras.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserSQLRepository implements UserRepositoryInterface {

    private final String TAG = "UserSQLRepository";

    private static UserSQLRepository instance;
    private Context contexto;
    ArrayList<User> users;
    private SQLiteDatabase db;
    private DataBaseHelper database;

    private String SCRIPT_CRIACAO = "create table if not exists users (login TEXT, " +
            "senha TEXT);";
    private String SCRIPT_CRIACAO_ITENS = "create table if not exists lista (user TEXT, " +
            "item TEXT);";
/*
    public static UserSQLRepository getInstance(Context contexto) {
        if (instance == null) {
            instance = new UserSQLRepository(contexto);
        }

        return instance;
    }
*/
    public UserSQLRepository(Context contexto) {
        database = new DataBaseHelper(contexto, SCRIPT_CRIACAO);
    }


    @Override
    public long addUser(User user) {
        ContentValues content = new ContentValues();
        content.put("login", user.getLogin());
        content.put("senha", user.getSenha());
        db = database.getWritableDatabase();
        long tag = db.insert("users", null, content);

        return tag;
    }

    public long delete(User user) {

        String sql = "delete from users where login = '"+user.getLogin()+"';";
        db = database.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        do {
            return 1;
        } while (cursor.moveToNext());
    }



    private User userFromCursor(Cursor cursor) {
        User user = new User(
                cursor.getString(0),
                cursor.getString(1));
        return user;
    }

    @Override
    public User getUserById(int id) {
        User user = null;
        String sql = "select * from users where id = '"+id+"';";
        String[] args = {""+id};
        db = database.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            return userFromCursor(cursor);
        } else {
            return null;
        }
    }


    @Override
    public List<User> getUsers() {
        users = new ArrayList<>();
        String sql = "select login, senha from users;";
        db = database.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        do {
            users.add(userFromCursor(cursor));
        } while (cursor.moveToNext());
        return users;
    }

    @Override
    public User getUserByUserLogin(String login) {
        User user = null;
        String sql = "select * from users where login = '"+login+"';";
        db = database.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if(!login.equals("")){
            if(cursor.moveToFirst()) {
                do {
                    user = userFromCursor(cursor);
                } while (cursor.moveToNext());
            }
        }
        return user;
    }
}



