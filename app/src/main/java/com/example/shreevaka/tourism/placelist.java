package com.example.shreevaka.tourism;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class placelist extends AppCompatActivity {

    ListView listview;
    FirebaseDatabase database;
    DatabaseReference dbrefe;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    Place place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placelist);

        place= new Place();
        listview = (ListView)findViewById(R.id.clist1);
        database = FirebaseDatabase.getInstance();
        dbrefe = database.getReference("Place");
        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this,R.layout.userplace,R.id.plaseinfo, list);
        dbrefe.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds:dataSnapshot.getChildren())
                {
                    place = ds.getValue(Place.class);
                    place.setID(Integer.parseInt(ds.getKey().toString()));
                    list.add(place.getID() + "\n" + place.getPname().toString() + "\n" +place.getPcity().toString()+ "\n" +place.getPnum().toString());

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

                String a = list.get(i).toString().substring(0,1);
               Intent i2 = new Intent(placelist.this,placedetails.class);
               i2.putExtra("key",a);
               startActivity(i2);
            }
        });

    }

}
