package com.example.applistadecompras.model;

public class Item {

    private int id;
    private String nomeitem;

    public Item(int id, String nomeitem) {
        this.id = id;
        this.nomeitem = nomeitem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeitem() {
        return nomeitem;
    }

    public void setNomeitem(String nomeitem) {
        this.nomeitem = nomeitem;
    }
}
