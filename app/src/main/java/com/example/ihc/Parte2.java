package com.example.ihc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Parte2 extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor lightSensor;
    private Sensor gyroSensor;

    TextView lightValue;
    TextView gyroValue;

    TextView latitudeValue;
    TextView longitudeValue;
    Button getGPSBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parte2);
        setTitle("Atividades Parte 2");

        lightValue = (TextView) findViewById(R.id.lightValueID);
        gyroValue = (TextView) findViewById(R.id.gyroValueID);

        latitudeValue = (TextView) findViewById(R.id.latitudeValueID);
        longitudeValue = (TextView) findViewById(R.id.longitudeValueID);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if (lightSensor != null){
            sensorManager.registerListener(Parte2.this, lightSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            lightValue.setText("not supported");
        }

        gyroSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if (gyroSensor != null){
            sensorManager.registerListener(Parte2.this, gyroSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            gyroValue.setText("not supported");
        }


        getGPSBtn = (Button) findViewById(R.id.getGPSBtn);
        ActivityCompat.requestPermissions(Parte2.this, new
                String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 123);

        getGPSBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GPSTracker g = new GPSTracker(getApplicationContext());
                Location l = g.getLocation();
                if(l!=null){
                    double lat = l.getLatitude();
                    double lon = l.getLongitude();

                    latitudeValue.setText(""+lat);
                    longitudeValue.setText(""+lon);
                }
            }
        });
    }


    @Override
    public void onAccuracyChanged(Sensor sensor,int accuracy){
    }

    @Override
    public void onSensorChanged(SensorEvent event){

        Sensor sensor = event.sensor;
        if(sensor.getType() == Sensor.TYPE_LIGHT) {
            lightValue.setText("" + event.values[0]);
        }

        if(sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            gyroValue.setText("" + event.values[0]);
        }
    }
}
