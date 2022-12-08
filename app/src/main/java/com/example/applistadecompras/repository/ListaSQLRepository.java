package com.example.applistadecompras.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.applistadecompras.model.Lista;
import com.example.applistadecompras.model.User;

import java.util.ArrayList;
import java.util.List;

public class ListaSQLRepository implements ListaRepositoryInterface {

    private final String TAG = "ListaSQLRepository";

    private static ListaSQLRepository instance;
    private Context contexto;
    ArrayList<Lista> lista;
    private SQLiteDatabase db;
    private DataBaseHelper database;

    public ListaSQLRepository(Context applicationContext) {
        database = new DataBaseHelper(applicationContext, "SCRIPT_CRIACAO");
    }

    @Override
    public long addLista(Lista lista) {
        ContentValues content = new ContentValues();
        content.put("nome", lista.getNome());
        content.put("user", lista.getUser().getLogin());
        db = database.getWritableDatabase();
        long tag = db.insert("lista", null, content);

        return tag;
    }

    @Override
    public long deleteLista(Lista lista) {

        String sql = "delete from lista where nome = '"+lista.getNome()+"' and user = '"+lista.getUser().getLogin()+"';";
        db = database.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        do {
            return 1;
        } while (cursor.moveToNext());
    }

    @Override
    public List<Lista> getLista() {
        lista = new ArrayList<>();
        String sql = "select * from lista;";
        db = database.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        do {
            lista.add(listaFromCursor(cursor));
        } while (cursor.moveToNext());
        return lista;
    }
    @Override
    public List<Lista> getListaByLogin(String user) {
        lista = new ArrayList<>();
        String sql = "select * from lista where user = '"+user+"';";
        db = database.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.moveToFirst()) {
            do {
                lista.add(listaFromCursor(cursor));
            } while (cursor.moveToNext());
        }
        return lista;
    }
    @Override
    public List<Lista> getListaByLoginID(String user, String nomeLista) {
        lista = new ArrayList<>();
        String sql = "select * from lista where user = '"+user+"' and nome = '"+nomeLista+"';";
        db = database.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.moveToFirst()) {
            do {
                lista.add(listaFromCursor(cursor));
            } while (cursor.moveToNext());
        }
        return lista;
    }

    @Override
    public User getListaBynome(String nome) {
        return null;
    }

    private Lista listaFromCursor(Cursor cursor) {
        Lista lista = new Lista(
                Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                new User(cursor.getString(2), ""));
        ;
        return lista;
    }



}
