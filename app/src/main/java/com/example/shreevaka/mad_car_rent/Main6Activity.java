package com.example.shreevaka.mad_car_rent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main6Activity extends AppCompatActivity {

    Button b11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        b11 = findViewById(R.id.btn11);

        Log.i("Lifecycle","onCreate() invoked in activity 1");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i("Lifecycle","onCreate() invoked in activity 1");

        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(Main6Activity.this, MainActivity.class);
                startActivity(i1);
            }
        });
    }
}
