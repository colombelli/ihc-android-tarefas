package com.example.ihc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Atividade2 extends AppCompatActivity {
    public static final String MESSAGE = "com.example.myfirstapp.MESSAGE";

    Button btn_send;
    EditText msg_to_send;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade2);
        setTitle("Atividade 2");

        msg_to_send = (EditText) findViewById(R.id.msg_to_send);
        btn_send = (Button) findViewById(R.id.btn_send);
    }


        public void sendMessage(View view) {
            Intent intent = new Intent(this, Atividade22.class);
            String message = msg_to_send.getText().toString();
            intent.putExtra(MESSAGE, message);
            startActivity(intent);
        }


}
