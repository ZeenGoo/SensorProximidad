package com.example.sensorproximidad;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    //se configura la interfaz de usuarios cargando el diseño definido en el activity_main.xml

    LinearLayout ln;
    SensorManager sm;
    Sensor sensor;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Se inicializab las variables
        ln = findViewById(R.id.activity_main);//un objeto linearlayout que representa el diseño principal de la actividad
        tv = findViewById(R.id.tv);//un TextView que se utilizara para mostrar el valor del sensor
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);//se obtiene el sensor de proximidad con Sensor, Type_Proximity del dispositivo
        sensor = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);//Se obtiene el sensor de proximidad con Sensor; Type_Proximity del dispositivo
        sm.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);//Se registra la clase this como oyente del sensor de proximida
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        String text = String.valueOf(event.values[0]);
        tv.setText(text);
        float valor = Float.parseFloat(text);
        if (valor == 0){
            ln.setBackgroundColor(Color.GREEN);
        }else{
            ln.setBackgroundColor(Color.RED);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}