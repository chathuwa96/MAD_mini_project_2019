package com.example.shreevaka.tourism;

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
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class userlistviewguide extends AppCompatActivity {

    ListView listView;
    FirebaseDatabase database;
    DatabaseReference ref;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    Student std;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlistviewguide);

        listView = findViewById(R.id.listView);
        back = findViewById(R.id.listBack);

        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Student");
        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, R.layout.user_info, R.id.userInfo, list);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    std = ds.getValue(Student.class);
                    std.setID(Integer.parseInt(ds.getKey().toString()));
                    list.add(std.getID() + "\n" +std.getName().toString() + "\n" + std.getTown().toString() + "\n" + std.getCon().toString());
                }
                listView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Log.i("Lifecycle", "onCreate() invoked in activity 1");
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String a = list.get(i).toString().substring(0,1);
                Intent i2 = new Intent(userlistviewguide.this,uderGuideDetails.class);
                i2.putExtra("key",a);
                startActivity(i2);
            }
        });
    }
    public void onResume() {
        super.onResume();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(userlistviewguide.this,homeGuide.class);
                startActivity(i);

                Toast.makeText(getApplicationContext(), "Please Wait", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
