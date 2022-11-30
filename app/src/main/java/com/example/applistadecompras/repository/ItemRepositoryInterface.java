package com.example.applistadecompras.repository;

import com.example.applistadecompras.model.Item;
import com.example.applistadecompras.model.Lista;
import com.example.applistadecompras.model.User;

import java.util.List;

public interface ItemRepositoryInterface {


    public long addItem(Item item);
    public long deleteItem(Item item);
    public List<Item> getItem();
    public User getItemBynome(String nome);


}
