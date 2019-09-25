package com.example.shreevaka.tourism;

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

public class Main3Activity extends AppCompatActivity {

    EditText textcar,textcity,textfacilities,textdrivername,textcontactnumber,textdiscription;

    Button btnadd;

    long a1=0;

    DatabaseReference dbRef;
    Car car;

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
        setContentView(R.layout.activity_main3);

        textcar = findViewById(R.id.cetxt1);
        textcity = findViewById(R.id.cetxt2);
        textfacilities = findViewById(R.id.cetxt3);
        textdrivername = findViewById(R.id.cetxt4);
        textcontactnumber = findViewById(R.id.cetxt5);
        textdiscription = findViewById(R.id.cetxt6);

        btnadd = findViewById(R.id.cbtn4);

        car = new Car();
        dbRef = FirebaseDatabase.getInstance().getReference().child("Car");

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                    a1=(dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    if(TextUtils.isEmpty(textcar.getText().toString()))
                        Toast.makeText(getApplicationContext(),"please enter ID",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(textcity.getText().toString()))
                        Toast.makeText(getApplicationContext(),"please enter Name",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(textfacilities.getText().toString()))
                        Toast.makeText(getApplicationContext(),"please enter Address",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(textdrivername.getText().toString()))
                        Toast.makeText(getApplicationContext(),"please enter Mobile",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(textcontactnumber.getText().toString()))
                        Toast.makeText(getApplicationContext(),"please enter Mobile",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(textdiscription.getText().toString()))
                        Toast.makeText(getApplicationContext(),"please enter Mobile",Toast.LENGTH_SHORT).show();
                    else {
                        car.setCar(textcar.getText().toString().trim());
                        car.setCity(textcity.getText().toString().trim());
                        car.setFacilities(textfacilities.getText().toString().trim());
                        car.setDrivername(textdrivername.getText().toString().trim());
                        car.setContactnumber(textcontactnumber.getText().toString().trim());
                        car.setDiscription(textdiscription.getText().toString().trim());
                    }

                    //dbRef.push().setValue(car);
                    //dbRef.child("car1").setValue(car);
                    dbRef.child(String.valueOf(a1+1)).setValue(car);
                    Toast.makeText(getApplicationContext(),"data saved success",Toast.LENGTH_LONG).show();
                    finish();
                }catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"invalide contact number",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}

