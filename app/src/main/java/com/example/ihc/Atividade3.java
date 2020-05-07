package com.example.ihc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;

public class Atividade3 extends AppCompatActivity implements SensorEventListener{

    private SensorManager sManager;
    private Sensor accSensor;

    EditText x_text;
    EditText y_text;
    EditText z_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade3);
        setTitle("Atividade 3");

        x_text = (EditText) findViewById(R.id.x_coord);
        y_text = (EditText) findViewById(R.id.y_coord);
        z_text = (EditText) findViewById(R.id.z_coord);


        sManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        accSensor = sManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor,int accuracy){
    }


    @Override
    public void onSensorChanged(SensorEvent event){

        float x=event.values[0];
        float y=event.values[1];
        float z=event.values[2];

        x_text.setText(Float.toString(x));
        y_text.setText(Float.toString(y));
        z_text.setText(Float.toString(y));

        if (x < -8) {
            startActivity(new Intent(Atividade3.this, Atividade33.class));
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        sManager.registerListener(this, accSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sManager.unregisterListener(this);
    }


}
