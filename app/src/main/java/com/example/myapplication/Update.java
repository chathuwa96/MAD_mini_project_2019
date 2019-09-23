package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Update extends AppCompatActivity {

    EditText txtHid02,txtDescription, txtCNumber01;

    Button btnUpdate01,btnDelete03;

    DatabaseReference dbref;

    Hotel hotel;

    private void clearControls(){
        txtHid02.setText("");
        txtCNumber01.setText("");
        txtDescription.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        txtHid02 = findViewById(R.id.txtHId02);
        txtDescription = findViewById(R.id.txtDescription);
        txtCNumber01 = findViewById(R.id.txtCnumber01);

        btnUpdate01 = findViewById(R.id.btnUpdate01);
        btnDelete03 = findViewById(R.id.btnDelete03);

        hotel = new Hotel();

        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Hotel").child("1");
        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()){
                    txtHid02.setText(dataSnapshot.child("hotelId").getValue().toString());
                    txtDescription.setText(dataSnapshot.child("Description").getValue().toString());
                    txtCNumber01.setText(dataSnapshot.child("ContactNumber").getValue().toString());
                }
                else
                    Toast.makeText(getApplicationContext(),"No Source to Display", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btnDelete03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference delRef = FirebaseDatabase.getInstance().getReference().child("Hotel");
                delRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild("1")){
                            dbref = FirebaseDatabase.getInstance().getReference().child("Hotel").child("1");
                            dbref.removeValue();
                            clearControls();
                            Toast.makeText(getApplicationContext(),"Data deleted Successfully", Toast.LENGTH_SHORT).show();
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

        btnUpdate01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference updRef = FirebaseDatabase.getInstance().getReference().child("Hotel");
                updRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild("1")) {
                            try {
                                hotel.setHId(txtHid02.getText().toString().trim());
                                hotel.setDescription(txtDescription.getText().toString().trim());
                                hotel.setCNumber(txtCNumber01.getText().toString().trim());

                                dbref = FirebaseDatabase.getInstance().getReference().child("Hotel").child("1");
                                dbref.setValue(hotel);
                                clearControls();

                                Toast.makeText(getApplicationContext(), "Data Update Successfully", Toast.LENGTH_SHORT).show();
                            } catch (Exception e) {
                                Toast.makeText(getApplicationContext(), "Invalid Contact Number", Toast.LENGTH_SHORT).show();

                            }



                        }else
                            Toast.makeText(getApplicationContext(),"No Source to Update", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });


    }
}
