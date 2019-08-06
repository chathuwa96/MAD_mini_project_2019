package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class activity_three extends AppCompatActivity {

    Button b1,b2,b3,b4;
    ImageButton b5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        b1 = findViewById(R.id.btn5);
        b2 = findViewById(R.id.btn6);
        b3 = findViewById(R.id.btn8);
        b4 = findViewById(R.id.btn9);
        b5 = findViewById(R.id.btn19);

    }

    public void onResume() {
        super.onResume();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(activity_three.this, activity_two.class);
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(activity_three.this, activity_five.class);
                startActivity(i1);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(activity_three.this, activity_seven.class);
                startActivity(i1);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(activity_three.this, activity_seven.class);
                startActivity(i1);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(activity_three.this, activity_four.class);
                startActivity(i1);
            }
        });
    }
}
