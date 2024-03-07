package com.example.crud;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edname = findViewById(R.id.edname);
        EditText edstate = findViewById(R.id.edstate);
        EditText edcountry = findViewById(R.id.edcountry);
        Button btnAdd = findViewById(R.id.btnAdd);
        firestore = FirebaseFirestore.getInstance();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edname.getText().toString();
                String state = edstate.getText().toString();
                String country = edcountry.getText().toString();
                Add(name,state,country);
            }
        });

    }
    public void Add(String name, String country , String state){
        CollectionReference collectionReference = firestore.collection("Country");
        try {
            Map<String ,Object> data = new HashMap<>();
            data.put("name",name);
            data.put("country",country);
            data.put("state",state);
            collectionReference.add(data);
        }catch (Exception e){
            Toast.makeText(MainActivity.this,""+e,Toast.LENGTH_LONG).show();
        }
    }
}