package com.example.applistadecompras.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "banco1";
    private static final Integer DB_VERSION = 1;
    private String scriptCriacao;

    public DataBaseHelper(Context context, String scriptCriacao) {

        super(context, DB_NAME, null, DB_VERSION);
        this.scriptCriacao = scriptCriacao;

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //String stm = "create table if not exists users (id INTEGER PRIMARY KEY, login TEXT,\n" +
          //      "     senha TEXT);";
        sqLiteDatabase.execSQL("create table if not exists users (login TEXT, senha TEXT);");
        sqLiteDatabase.execSQL("create table if not exists lista (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, user TEXT);");
        sqLiteDatabase.execSQL("create table if not exists lista_item (id_lista INTEGER, item TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

