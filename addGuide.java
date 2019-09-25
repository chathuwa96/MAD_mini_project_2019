package com.example.shreevaka.tourism;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class addGuide extends AppCompatActivity {

    EditText textTown, textName, textDes, textCon, textLanguage;

    Button btnSave, btnBack, btnUpdate, btnDelete;
    long a1=0,a2=0,a3=0,a4=4;

    DatabaseReference dbRef1,dbRef2,dbRef3;
    Student std;

    private void clearControls() {
        textName.setText("");
        textTown.setText("");
        textCon.setText("");
        textDes.setText("");
        textLanguage.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_guide);

        textTown = findViewById(R.id.updateName);
        textName = findViewById(R.id.updateTown);
        textDes = findViewById(R.id.updateCon);
        textCon = findViewById(R.id.updateDes);
        textLanguage = findViewById(R.id.updateLanguage);

        btnSave = findViewById(R.id.btnUpdate);
        btnBack = findViewById(R.id.btnAddGuideBack);
        //btnUpdate = findViewById(R.id.button3);
        //btnDelete = findViewById(R.id.button4);

        std = new Student();
        dbRef1 = FirebaseDatabase.getInstance().getReference().child("Student");

        dbRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                    a1=(dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //dbRef1 = FirebaseDatabase.getInstance().getReference().child("Student");

                try {
                    if (TextUtils.isEmpty(textName.getText().toString()))
                        Toast.makeText(getApplicationContext(), "please enter Name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(textTown.getText().toString()))
                        Toast.makeText(getApplicationContext(), "please enter Town", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(textCon.getText().toString()))
                        Toast.makeText(getApplicationContext(), "please enter Mobile", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(textDes.getText().toString()))
                        Toast.makeText(getApplicationContext(), "please enter Description", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(textLanguage.getText().toString()))
                        Toast.makeText(getApplicationContext(), "please enter Language", Toast.LENGTH_SHORT).show();
                    else {
                        std.setName(textTown.getText().toString().trim());
                        std.setTown(textName.getText().toString().trim());
                        std.setCon(textDes.getText().toString().trim());
                        std.setDes(textCon.getText().toString().trim());
                        std.setLanguage(textLanguage.getText().toString().trim());
                    }

                    // dbRef.push().setValue(std);
                    //dbRef.child("guide1").setValue(std);

                    dbRef1.child(String.valueOf(a1+1)).setValue(std);
                    Toast.makeText(getApplicationContext(), "data saved success", Toast.LENGTH_LONG).show();
                    finish();
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "invalid contact number", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void onResume() {
        super.onResume();
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(addGuide.this, homeGuide.class);
                startActivity(i);

                Toast.makeText(getApplicationContext(),"Please Wait",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

