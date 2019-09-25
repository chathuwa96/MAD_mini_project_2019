package com.example.shreevaka.tourism;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.Guide);
        b2 = findViewById(R.id.go);
    }
    public void onResume() {
        super.onResume();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, adiminmainhome.class);
                startActivity(i);

                Toast.makeText(getApplicationContext(),"Please Wait",Toast.LENGTH_SHORT).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(MainActivity.this, uhome.class);
                startActivity(i2);

                Toast.makeText(getApplicationContext(),"Please Wait",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
