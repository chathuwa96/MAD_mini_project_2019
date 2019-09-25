package com.example.shreevaka.tourism;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homeplace extends AppCompatActivity {

    Button pview,padd,pedit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeplace);

        pview = findViewById(R.id.pView);
        padd = findViewById(R.id.pAdd);
        pedit = findViewById(R.id.pEdit);

        pview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(homeplace.this,placelist.class);
                startActivity(i1);
            }
        });

        padd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(homeplace.this,Addplace.class);
                startActivity(i2);
            }
        });

        pedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(homeplace.this,placelist2.class);
                startActivity(i3);
            }
        });
    }
}

