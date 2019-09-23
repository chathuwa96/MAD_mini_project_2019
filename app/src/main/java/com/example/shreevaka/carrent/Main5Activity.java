package com.example.shreevaka.carrent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class Main5Activity extends AppCompatActivity {

    TextView textcar,textcity,textfacilities,textdrivername,textcontactnumber,textdiscription;

    Button btnupdate,btndelete;

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
        setContentView(R.layout.activity_main5);

        textcar = findViewById(R.id.cetxt7);
        textcity = findViewById(R.id.cetxt8);
        textfacilities = findViewById(R.id.cetxt9);
        textdrivername = findViewById(R.id.cetxt10);
        textcontactnumber = findViewById(R.id.cetxt11);
        textdiscription = findViewById(R.id.cetxt12);

        btnupdate = findViewById(R.id.cbtn11);
        btndelete = findViewById(R.id.cbtn10);

        car = new Car();

        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Car").child("1");
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

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference delRef = FirebaseDatabase.getInstance().getReference().child("Car");
                delRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild("1")){
                            dbRef = FirebaseDatabase.getInstance().getReference().child("Car").child("1");
                            dbRef.removeValue();
                            clearControls();
                            Toast.makeText(getApplicationContext(),"Data deleted Successfully",Toast.LENGTH_SHORT).show();

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
                DatabaseReference updRef = FirebaseDatabase.getInstance().getReference().child("Car");
                updRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild("1")){
                            try{
                                car.setCar(textcar.getText().toString().trim());
                                car.setCity(textcity.getText().toString().trim());
                                car.setFacilities(textfacilities.getText().toString().trim());
                                car.setDrivername(textdrivername.getText().toString().trim());
                                car.setContactnumber(textcontactnumber.getText().toString().trim());
                                car.setDiscription(textdiscription.getText().toString().trim());

                                dbRef = FirebaseDatabase.getInstance().getReference().child("Car").child("1");
                                dbRef.setValue(car);
                                clearControls();

                                Toast.makeText(getApplicationContext(),"Data Update Successfully",Toast.LENGTH_SHORT).show();

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
