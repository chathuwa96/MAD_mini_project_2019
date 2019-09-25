package com.example.shreevaka.tourism;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class updateGuide extends AppCompatActivity {

    TextView textName,textTown,textCon,textDes,textLangage;
    Button btnUpdate,btndelet;

    Student std;

    DatabaseReference dbRef;

    private void clearControls() {
        textName.setText("");
        textTown.setText("");
        textCon.setText("");
        textDes.setText("");
        textLangage.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_guide);

        textName = findViewById(R.id.updateName);
        textTown = findViewById(R.id.updateTown);
        textCon = findViewById(R.id.updateCon);
        textDes = findViewById(R.id.updateDes);
        textLangage = findViewById(R.id.updateLanguage);

        btnUpdate = findViewById(R.id.btnUpdate);
        btndelet = findViewById(R.id.btnViewDelete);

        Intent i2 = getIntent();
        final String a = i2.getStringExtra("key");

        std = new Student();


        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Student").child(a);
        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChildren()){
                    textName.setText(dataSnapshot.child("name").getValue().toString());
                    textTown.setText(dataSnapshot.child("town").getValue().toString());
                    textCon.setText(dataSnapshot.child("con").getValue().toString());
                    textDes.setText(dataSnapshot.child("des").getValue().toString());
                    textLangage.setText(dataSnapshot.child("language").getValue().toString());
                }
                else
                    Toast.makeText(getApplicationContext(),"No Sourse Display",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        btndelet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference delRef = FirebaseDatabase.getInstance().getReference().child("Student");
                delRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild(a)){
                            dbRef = FirebaseDatabase.getInstance().getReference().child("Student").child(a);
                            dbRef.removeValue();
                            clearControls();
                            Toast.makeText(getApplicationContext(),"Data deleted Successfully",Toast.LENGTH_SHORT).show();
                            finish();

                        }
                        else
                            Toast.makeText(getApplicationContext(),"No Source to Delete",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference updRef = FirebaseDatabase.getInstance().getReference().child("Student");
                updRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild(a)){
                            try{
                                std.setName(textName.getText().toString().trim());
                                std.setTown(textTown.getText().toString().trim());
                                std.setCon(textCon.getText().toString().trim());
                                std.setDes(textDes.getText().toString().trim());
                                std.setLanguage(textLangage.getText().toString().trim());

                                dbRef = FirebaseDatabase.getInstance().getReference().child("Student").child(a);
                                dbRef.setValue(std);
                                clearControls();

                                Toast.makeText(getApplicationContext(),"Data Update Successfully",Toast.LENGTH_SHORT).show();
                                finish();

                            }
                            catch (NumberFormatException e){
                                Toast.makeText(getApplicationContext(),"Invalid Contact Number",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                            Toast.makeText(getApplicationContext(),"No Source to Update",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
