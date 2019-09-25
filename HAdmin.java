package com.example.shreevaka.tourism;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HAdmin extends AppCompatActivity {

    Button btnView, btnAdd,btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hadmin);

        btnView = findViewById(R.id.btnView);
        btnAdd = findViewById(R.id.btnAdd);
        btnUpdate = findViewById(R.id.btnUpdate);


    }

    @Override
    public void onResume() {
        super.onResume();

        btnView.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HAdmin.this,Hlistview.class);
                startActivity(intent);
            }
        });


        btnAdd.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HAdmin.this,Add.class);
                startActivity(intent);
            }
        });


        btnUpdate.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HAdmin.this,Hlistview2.class);
                startActivity(intent);
            }
        });




    }
}

