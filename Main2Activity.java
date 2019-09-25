package com.example.shreevaka.tourism;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    Button btnviewlist;
    Button btnadd;
    Button btnupdatedelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnviewlist = findViewById(R.id.cbtn1);
        btnadd= findViewById(R.id.cbtn2);
        btnupdatedelete = findViewById(R.id.cbtn3);

        Log.i("Lifecycle","onCreate() invoked in activity 1");

        Context context = getApplicationContext();
        String message = "Welcome";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context,message,duration);
        toast.show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i("Lifecycle","onCreate() invoked in activity 1");

        btnviewlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(Main2Activity.this, Main7Activity.class);
                startActivity(i1);
            }
        });

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(i2);
            }
        });

        btnupdatedelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(Main2Activity.this, Main6Activity.class);
                startActivity(i3);
            }
        });

    }
}
