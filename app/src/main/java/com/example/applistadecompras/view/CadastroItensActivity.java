package com.example.applistadecompras.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.applistadecompras.R;

public class CadastroItensActivity extends AppCompatActivity {
    String lista = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_itens);

        lista = getIntent().getStringExtra("nomeLista");// aqui recebe
        Log.d("Itens", "chegou a lista -> "+ lista);

    }
}