package com.example.shreevaka.mad_car_rent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main5Activity extends AppCompatActivity {

    Button b7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        b7 = findViewById(R.id.btn7);


        Log.i("Lifecycle","onCreate() invoked in activity 1");

    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i("Lifecycle","onCreate() invoked in activity 1");

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(Main5Activity.this, Main3Activity.class);
                startActivity(i1);
            }
        });
    }
}
