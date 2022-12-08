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

    User getItemBynome(String nomeItem);
}
