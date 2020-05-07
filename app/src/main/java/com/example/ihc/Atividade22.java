package com.example.ihc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;


public class Atividade22 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade22);
        setTitle("Atividade 2");

        Intent intent = getIntent();
        String message = intent.getStringExtra(Atividade2.MESSAGE);

        TextView receivedMsg = findViewById(R.id.received_msg);
        receivedMsg.setText(message);

    }

    public void go_to_a3(View view) {
        startActivity(new Intent(Atividade22.this, Atividade3.class));
    }
}
