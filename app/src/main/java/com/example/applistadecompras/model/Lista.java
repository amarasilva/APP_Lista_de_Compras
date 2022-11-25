package com.example.applistadecompras.model;

public class Lista {

    private int id;
    private String nome;
    private User user;

    public Lista(int id, String nome, User user) {
        this.id = id;
        this.nome = nome;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
