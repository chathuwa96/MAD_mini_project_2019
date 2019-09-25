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

public class Placeupdate extends AppCompatActivity {

    EditText pname,pcity,paddress,pnumber;

    Button btnupdate,btndelete;

    DatabaseReference dbRefe;

    Place place;

    private void clearControls(){
        pname.setText("");
        pcity.setText("");
        paddress.setText("");
        pnumber.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placeupdate);

        pname = findViewById(R.id.pName);
        pcity = findViewById(R.id.pCity);
        paddress = findViewById(R.id.pAddress);
        pnumber = findViewById(R.id.pNumber);

        btnupdate = findViewById(R.id.btnPupdate);
        btndelete = findViewById(R.id.btnPdelete);

        Intent i2 = getIntent();
        final String a = i2.getStringExtra("key");

        place = new Place();

        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Place").child(a);
        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()){
                    pname.setText(dataSnapshot.child("pname").getValue().toString());
                    pcity.setText(dataSnapshot.child("pcity").getValue().toString());
                    paddress.setText(dataSnapshot.child("paddress").getValue().toString());
                    pnumber.setText(dataSnapshot.child("pnum").getValue().toString());
                }
                else
                    Toast.makeText(getApplicationContext(),"NO Source to Display",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference delRef = FirebaseDatabase.getInstance().getReference().child("Place");
                delRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild(a)){
                            dbRefe = FirebaseDatabase.getInstance().getReference().child("Place").child(a);
                            dbRefe.removeValue();
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

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference updRef = FirebaseDatabase.getInstance().getReference().child("Place");
                updRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild(a)){
                            try{
                                place.setPname(pname.getText().toString().trim());
                                place.setPcity(pcity.getText().toString().trim());
                                place.setPaddress(paddress.getText().toString().trim());
                                place.setPnum(pnumber.getText().toString().trim());

                                dbRefe = FirebaseDatabase.getInstance().getReference().child("Place").child(a);
                                dbRefe.setValue(place);
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

