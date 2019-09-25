package com.example.shreevaka.tourism;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main4Activity extends AppCompatActivity {

    TextView textcar,textcity,textfacilities,textdrivername,textcontactnumber,textdiscription;

    DatabaseReference dbRef;

    private void clearControls(){
        textcar.setText("");
        textcity.setText("");
        textfacilities.setText("");
        textdrivername.setText("");
        textcontactnumber.setText("");
        textdiscription.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        textcar = findViewById(R.id.ctxt11);
        textcity = findViewById(R.id.ctxt12);
        textfacilities = findViewById(R.id.ctxt13);
        textdrivername = findViewById(R.id.ctxt14);
        textcontactnumber = findViewById(R.id.ctxt15);
        textdiscription = findViewById(R.id.ctxt16);

        Intent i2 = getIntent();
        final String a = i2.getStringExtra("key");


        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Car").child(a);
        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()){
                    textcar.setText(dataSnapshot.child("car").getValue().toString());
                    textcity.setText(dataSnapshot.child("city").getValue().toString());
                    textfacilities.setText(dataSnapshot.child("facilities").getValue().toString());
                    textdrivername.setText(dataSnapshot.child("drivername").getValue().toString());
                    textcontactnumber.setText(dataSnapshot.child("contactnumber").getValue().toString());
                    textdiscription.setText(dataSnapshot.child("discription").getValue().toString());
                }
                else
                    Toast.makeText(getApplicationContext(),"NO Source to Display",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


}
