package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class Add extends AppCompatActivity {

    EditText txtHName,txtHId,txtAddress,txtCity,txtProvince,txtDistrict,txtDescription,txtCNumber;

    Button btnDone;

    long a1=0;

    DatabaseReference dbref;

    Hotel hotel;




    private void clearControls(){
        txtHName.setText("");
        txtHId.setText("");
        txtAddress.setText("");
        txtCity.setText("");
        txtDistrict.setText("");
        txtProvince.setText("");
        txtDescription.setText("");
        txtCNumber.setText("");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        txtHName = findViewById(R.id.txtHName);
        txtHId = findViewById(R.id.txtHId);
        txtAddress = findViewById(R.id.txtAddress);
        txtCity = findViewById(R.id.txtCity);
        txtDistrict = findViewById(R.id.txtxDistrict);
        txtProvince = findViewById(R.id.txtProvince);
        txtDescription = findViewById(R.id.txtDescription);
        txtCNumber = findViewById(R.id.txtCNumber);

        btnDone = findViewById(R.id.btnDone);

        hotel = new Hotel();
        dbref = FirebaseDatabase.getInstance().getReference().child("Hotel");


        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                    a1 = (dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        btnDone.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    if(TextUtils.isEmpty(txtHName.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter Hotel Name", Toast.LENGTH_SHORT).show();

                    else if(TextUtils.isEmpty(txtHId.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter Hotel ID", Toast.LENGTH_SHORT).show();

                    else if(TextUtils.isEmpty(txtAddress.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter Hotel Address", Toast.LENGTH_SHORT).show();

                    else if(TextUtils.isEmpty(txtCity.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter City", Toast.LENGTH_SHORT).show();

                    else if(TextUtils.isEmpty(txtDistrict.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter District", Toast.LENGTH_SHORT).show();

                    else if(TextUtils.isEmpty(txtProvince.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter Province", Toast.LENGTH_SHORT).show();

                    else if(TextUtils.isEmpty(txtDescription.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter Description", Toast.LENGTH_SHORT).show();

                    else if(TextUtils.isEmpty(txtCNumber.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter Contact Number", Toast.LENGTH_SHORT).show();

                    else{
                        hotel.setHName(txtHName.getText().toString().trim());
                        hotel.setHId(txtHId.getText().toString().trim());
                        hotel.setAddress(txtAddress.getText().toString().trim());
                        hotel.setCity(txtCity.getText().toString().trim());
                        hotel.setDistrict(txtDistrict.toString().trim());
                        hotel.setProvince(txtProvince.toString().trim());
                        hotel.setCNumber(txtCNumber.toString().trim());

                    }

                    dbref.child(String.valueOf(a1+1)).setValue(hotel);
                    Toast.makeText(getApplicationContext(),"Data Saved Success", Toast.LENGTH_LONG).show();

                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(),"Invalid Contact Number", Toast.LENGTH_LONG).show();
                }

            }
        });

    }







}
