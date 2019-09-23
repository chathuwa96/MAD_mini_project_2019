package com.example.shreevaka.carrent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Main6Activity extends AppCompatActivity {

    Button btnlistback;
    ListView listview;
    FirebaseDatabase database;
    DatabaseReference dbRef;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        btnlistback = findViewById(R.id.cbtn30);
        car = new Car();
        listview = (ListView)findViewById(R.id.clist1);
        database = FirebaseDatabase.getInstance();
        dbRef = database.getReference("Car");
        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this,R.layout.user_info,R.id.userInfo, list);
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds:dataSnapshot.getChildren())
                {
                    car = ds.getValue(Car.class);
                    list.add(car.getCar().toString() + "\n" +car.getCity().toString()+ "\n" +car.getFacilities().toString());

                }
                listview.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Log.i("Lifecycle","onCreate() invoked in activity 1");

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent i2 = new Intent(Main6Activity.this, Main5Activity.class);
                startActivity(i2);
            }
        });
    }
}
