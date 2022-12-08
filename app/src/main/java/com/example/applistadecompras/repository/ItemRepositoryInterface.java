package com.example.applistadecompras.repository;

import com.example.applistadecompras.model.Item;
import com.example.applistadecompras.model.Lista;
import com.example.applistadecompras.model.User;

import java.util.List;

public interface ItemRepositoryInterface {

    long addItem(String idLista, Item item);

    public long deleteItem(String idLista, Item item);
    public List<Item> getItem();

    List<Item> getItemByLista(String idLista);


    /* @Override
         public List<Item> getItemByLista(String nomeLista) {
             item = new ArrayList<>();
             String sql = "select * from lista_item where user = '"+user+"';";
             db = database.getWritableDatabase();
             Cursor cursor = db.rawQuery(sql, null);
             if(cursor.moveToFirst())
                 do {
                     lista.add(listaFromCursor(cursor));
                 } while (cursor.moveToNext());
             return lista;
         }
     */
    User getItemBynome(String nomeItem);
}
