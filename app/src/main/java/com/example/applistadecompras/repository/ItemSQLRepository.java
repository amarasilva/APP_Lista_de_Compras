package com.example.applistadecompras.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.applistadecompras.model.Item;
import com.example.applistadecompras.model.User;

import java.util.ArrayList;
import java.util.List;

public class ItemSQLRepository implements ItemRepositoryInterface {

    private final String TAG = "ItemSQLRepository";

    private static ItemSQLRepository instance;
    private Context contexto;
    ArrayList<Item> item;
    private SQLiteDatabase db;
    private DataBaseHelper database;


    public ItemSQLRepository(Context applicationContext) {
        database = new DataBaseHelper(applicationContext, "SCRIPT_CRIACAO");
    }

    @Override
    public long addItem(String idLista, Item item) {
        ContentValues content = new ContentValues();
        content.put("id_lista", idLista);
        content.put("item", item.getNomeitem());
        //content.put("user", lista.getUser().getLogin());
        db = database.getWritableDatabase();
        long tag = db.insert("lista_item", null, content);

        return tag;
    }

    @Override
    public long deleteItem(String idLista, Item item) {

        String sql = "delete from lista_item where item = '" + item.getNomeitem() + "' AND id_lista = '" + idLista + "'";
        db = database.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        do {
            return 1;
        } while (cursor.moveToNext());
    }

    @Override
    public List<Item> getItem() {
        item = new ArrayList<>();
        String sql = "select * from lista_item;";
        db = database.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        do {
            item.add(ItemFromCursor(cursor));
        } while (cursor.moveToNext());
        return item;
    }

    @Override
    public List<Item> getItemByLista(String idLista) {
        item = new ArrayList<>();
        String sql = "select * from lista_item where id_lista = '" + idLista + "';";
        db = database.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                item.add(ItemFromCursor(cursor));
            } while (cursor.moveToNext());
        }
        return item;
    }

    @Override
    public User getItemBynome(String nomeItem) {
        return null;
    }

    private Item ItemFromCursor(Cursor cursor) {
        Item item = new Item(
                Integer.parseInt(cursor.getString(0)),
                cursor.getString(1));
        ;
        return item;
    }


}

