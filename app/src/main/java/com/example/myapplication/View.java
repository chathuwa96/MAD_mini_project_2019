package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class View extends AppCompatActivity {

    ListView listView;
    FirebaseDatabase database;
    DatabaseReference dbref;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    Hotel hotel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        hotel = new Hotel();
        listView = (ListView)findViewById(R.id.lst01);
        database = FirebaseDatabase.getInstance();
        dbref = database.getReference("Hotel");
        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, R.layout.user_info,list);
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds:dataSnapshot.getChildren()){
                    hotel = ds.getValue(Hotel.class);
                    list.add(hotel.getHName().toString()+ "\n" + hotel.getAddress().toString()+ "\n" + hotel.getCity().toString()+"\n" + hotel.getDistrict().toString()+"\n" + hotel.getProvince().toString()+"\n"+hotel.getDescription().toString()+"\n"+hotel.getCNumber().toString());
                }

                listView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





    }
}
