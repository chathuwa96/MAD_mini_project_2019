package com.example.shreevaka.tourism;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class homeGuide extends AppCompatActivity {

    Button add,view,update,delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_guide);

        add = findViewById(R.id.btnGuideBack);
        view = findViewById(R.id.btnGuideList);
        update = findViewById(R.id.btnGuideEdit);
    }

    public void onResume() {
        super.onResume();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(homeGuide.this, addGuide.class);
                startActivity(i);

                Toast.makeText(getApplicationContext(), "Please Wait", Toast.LENGTH_SHORT).show();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(homeGuide.this, userlistviewguide.class);
                startActivity(i);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(homeGuide.this,listViewGuide.class);
                startActivity(i);
            }
        });
    }
}

