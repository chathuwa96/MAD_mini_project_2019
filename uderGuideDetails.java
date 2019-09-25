package com.example.shreevaka.tourism;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class uderGuideDetails extends AppCompatActivity {

    Button btnBack;
    TextView textName,textTown,textCon,textDes,textLangage;
    DatabaseReference dbRef;

    private void clearControls() {
        textName.setText("");
        textTown.setText("");
        textCon.setText("");
        textDes.setText("");
        textLangage.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uder_guide_details);

        btnBack = findViewById(R.id.viewBack);

        textName = findViewById(R.id.textViewName);
        textTown = findViewById(R.id.textViewTown);
        textCon = findViewById(R.id.textViewCon);
        textDes = findViewById(R.id.textViewDes);
        textLangage = findViewById(R.id.textViewLanguage);

        Intent i2 = getIntent();
        final String a = i2.getStringExtra("key");


        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Student").child(a);
        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChildren()){
                    textName.setText(dataSnapshot.child("name").getValue().toString());
                    textTown.setText(dataSnapshot.child("town").getValue().toString());
                    textCon.setText(dataSnapshot.child("con").getValue().toString());
                    textDes.setText(dataSnapshot.child("des").getValue().toString());
                    textLangage.setText(dataSnapshot.child("language").getValue().toString());
                }
                else
                    Toast.makeText(getApplicationContext(),"No Sourse Display",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(uderGuideDetails.this,listViewGuide.class);
                startActivity(i);

                Toast.makeText(getApplicationContext(), "Please Wait", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

