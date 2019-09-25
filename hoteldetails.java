package com.example.shreevaka.tourism;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class hoteldetails extends AppCompatActivity {

    EditText hname,hid,haddress,hcity,hdis,hpro,hdisc,hcnum;

    Button btnUpdate01,btnDelete03;

    DatabaseReference dbref;

    Hotel hotel;

    private void clearControls(){
        hname.setText("");
        hid.setText("");
        haddress.setText("");
        hcity.setText("");
        hdis.setText("");
        hpro.setText("");
        hdisc.setText("");
        hcnum.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoteldetails);

        hname = findViewById(R.id.txtHName);
        hid = findViewById(R.id.txtHId);
        haddress = findViewById(R.id.txtAddress);
        hcity = findViewById(R.id.txtCity);
        hdis = findViewById(R.id.txtxDistrict);
        hpro = findViewById(R.id.txtProvince);
        hdisc = findViewById(R.id.txtDescription);
        hcnum = findViewById(R.id.txtCNumber);

        btnUpdate01 = findViewById(R.id.btnUpdate01);
        btnDelete03 = findViewById(R.id.btnDelete03);

        Intent i2 = getIntent();
        final String a = i2.getStringExtra("key");

        hotel = new Hotel();

        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Hotel").child(a);
        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()){
                    hname.setText(dataSnapshot.child("hname").getValue().toString());
                    hid.setText(dataSnapshot.child("hid").getValue().toString());
                    haddress.setText(dataSnapshot.child("address").getValue().toString());
                    hcity.setText(dataSnapshot.child("city").getValue().toString());
                    hdis.setText(dataSnapshot.child("district").getValue().toString());
                    hpro.setText(dataSnapshot.child("province").getValue().toString());
                    hdisc.setText(dataSnapshot.child("description").getValue().toString());
                    hcnum.setText(dataSnapshot.child("cnumber").getValue().toString());

                }
                else
                    Toast.makeText(getApplicationContext(),"No Source to Display", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
