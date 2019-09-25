package com.example.shreevaka.tourism;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class placedetails extends AppCompatActivity {

    TextView pname,pcity,paddress,pnum;

    DatabaseReference dbRefe;

    private void clearControls(){
        pname.setText("");
        pcity.setText("");
        paddress.setText("");
        pnum.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placedetails);

        pname = findViewById(R.id.pName);
        pcity = findViewById(R.id.pCity);
        paddress = findViewById(R.id.pAddress);
        pnum = findViewById(R.id.pNumber);
        Intent i2 = getIntent();
        final String a = i2.getStringExtra("key");


        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Place").child(a);
        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()){
                    pname.setText(dataSnapshot.child("pname").getValue().toString());
                    pcity.setText(dataSnapshot.child("pcity").getValue().toString());
                    paddress.setText(dataSnapshot.child("paddress").getValue().toString());
                    pnum.setText(dataSnapshot.child("pnum").getValue().toString());
                }
                else
                    Toast.makeText(getApplicationContext(),a,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


}

