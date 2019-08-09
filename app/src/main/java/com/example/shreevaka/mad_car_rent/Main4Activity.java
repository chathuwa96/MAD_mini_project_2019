package com.example.shreevaka.mad_car_rent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main4Activity extends AppCompatActivity {

    Button b19;
    Button b20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        b19 = findViewById(R.id.btn19);
        b20 = findViewById(R.id.btn20);


        Log.i("Lifecycle","onCreate() invoked in activity 1");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i("Lifecycle","onCreate() invoked in activity 1");

        b19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(Main4Activity.this, Main3Activity.class);
                startActivity(i1);
            }
        });

        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Main4Activity.this, MainActivity.class);
                startActivity(i2);
            }
        });
    }
}
