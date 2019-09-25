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

public class Addplace extends AppCompatActivity {

    EditText pname,pcity,paddress,pnumber;

    Button btnadd;

    long a1=0;

    DatabaseReference dbRef;
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
        setContentView(R.layout.activity_addplace);

        pname = findViewById(R.id.pName);
        pcity = findViewById(R.id.pCity);
        paddress = findViewById(R.id.pAddress);
        pnumber = findViewById(R.id.pNumber);


        btnadd = findViewById(R.id.pAdd);

        place = new Place();
        dbRef = FirebaseDatabase.getInstance().getReference().child("Place");

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
                    if(TextUtils.isEmpty(pname.getText().toString()))
                        Toast.makeText(getApplicationContext(),"please enter name",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(pcity.getText().toString()))
                        Toast.makeText(getApplicationContext(),"please enter city",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(paddress.getText().toString()))
                        Toast.makeText(getApplicationContext(),"please enter Address",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(pnumber.getText().toString()))
                        Toast.makeText(getApplicationContext(),"please enter Mobile",Toast.LENGTH_SHORT).show();
                    else {
                        place.setPname(pname.getText().toString().trim());
                        place.setPcity(pcity.getText().toString().trim());
                        place.setPaddress(paddress.getText().toString().trim());
                        place.setPnum(pnumber.getText().toString().trim());
                    }

                    //dbRef.push().setValue(car);
                    //dbRef.child("car1").setValue(car);
                    dbRef.child(String.valueOf(a1+1)).setValue(place);
                    Toast.makeText(getApplicationContext(),"data saved success",Toast.LENGTH_LONG).show();
                    finish();
                }catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"invalide contact number",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}