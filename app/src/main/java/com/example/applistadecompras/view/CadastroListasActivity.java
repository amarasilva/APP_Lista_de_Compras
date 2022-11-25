package com.example.applistadecompras.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.applistadecompras.R;

public class CadastroListasActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = "Cadastro Lista Activity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);


        findViewById(R.id.buttonCLA).setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(view.getContext(), CadastroItensActivity.class);
        startActivity(intent);


    }
}