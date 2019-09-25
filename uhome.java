package com.example.shreevaka.tourism;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class uhome extends AppCompatActivity {

    Button b1,b2,b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uhome);

        b1 = findViewById(R.id.btng);
        b2 = findViewById(R.id.btnc);
        b3 = findViewById(R.id.btnh);
        b4 = findViewById(R.id.btnp);
    }
    public void onResume() {
        super.onResume();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(uhome.this, userlistviewguide.class);
                startActivity(i);

                Toast.makeText(getApplicationContext(),"Please Wait",Toast.LENGTH_SHORT).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(uhome.this, Main7Activity.class);
                startActivity(i2);

                Toast.makeText(getApplicationContext(),"Please Wait",Toast.LENGTH_SHORT).show();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(uhome.this, Hlistview.class);
                startActivity(i3);

                Toast.makeText(getApplicationContext(),"Please Wait",Toast.LENGTH_SHORT).show();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i4 = new Intent(uhome.this, placelist.class);
                startActivity(i4);

                Toast.makeText(getApplicationContext(),"Please Wait",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
