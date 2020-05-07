package com.example.ihc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    Button go_a2;
    TextView result;
    EditText input1;
    EditText input2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Atividade 1");

        button = (Button) findViewById(R.id.sum_btn);
        result = (TextView) findViewById(R.id.resultView);
        input1 = (EditText) findViewById(R.id.input1);
        input2 = (EditText) findViewById(R.id.input2);

        go_a2 = (Button) findViewById(R.id.go_a2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int number1 = Integer.parseInt(input1.getText().toString());
                int number2 = Integer.parseInt(input2.getText().toString());

                int sum = number1 + number2;

                String sum_string = Integer.toString(sum);
                result.setText(sum_string);

            }
        });


        go_a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, Atividade2.class));
            }
        });

    }
}
