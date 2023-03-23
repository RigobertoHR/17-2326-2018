package com.example.parcialii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class layoutempleado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layoutempleado);
        findViewById(R.id.compania_text_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencion= new Intent(layoutempleado.this,persona.class);
                startActivity(intencion);
            }
        });
    }
}