package com.example.applistadecompras.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.applistadecompras.R;
import com.example.applistadecompras.repository.UserSQLRepository;
import com.google.android.material.snackbar.Snackbar;

public class ListaActivity extends AppCompatActivity {
    private final String TAG = "ListaActivity";
    private UserSQLRepository banco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
       // banco = new UserSQLRepository(getBaseContext());
        //Log.d(TAG, "Primeiro usuario do banco = "+ banco.getUsers().get(0).getLogin());

    }
}