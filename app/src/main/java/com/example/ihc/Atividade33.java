package com.example.ihc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Atividade33 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade33);
        setTitle("Atividade 3");
    }

    public void next_activity(View view){
        startActivity(new Intent(Atividade33.this, Parte2.class));
    }
}
