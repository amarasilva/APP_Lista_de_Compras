package com.example.applistadecompras.repository;

import com.example.applistadecompras.model.Lista;
import com.example.applistadecompras.model.User;

import java.util.List;

public interface ListaRepositoryInterface {


    public long addLista(Lista lista);
    public long deleteLista(Lista lista);
    public List<Lista> getLista();


    List<Lista> getListaByLogin(String user);

    List<Lista> getListaByLoginID(String user, String nomeLista);

    public User getListaBynome(String nome);


}
