package com.example.shreevaka.mad_car_rent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {

    Button b6;
    Button b8;
    Button b9;
    Button b10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        b6 = findViewById(R.id.btn6);
        b8 = findViewById(R.id.btn8);
        b9 = findViewById(R.id.btn9);
        b10 = findViewById(R.id.btn10);


        Log.i("Lifecycle","onCreate() invoked in activity 1");

    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i("Lifecycle","onCreate() invoked in activity 1");

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(Main3Activity.this, Main4Activity.class);
                startActivity(i1);
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Main3Activity.this, Main5Activity.class);
                startActivity(i2);
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Main3Activity.this, Main5Activity.class);
                startActivity(i2);
            }
        });

        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Main3Activity.this, Main5Activity.class);
                startActivity(i2);
            }
        });

    }
}
