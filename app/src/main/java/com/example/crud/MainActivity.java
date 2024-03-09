package com.example.crud;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.List;
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
        Map<String ,Object> data = new HashMap<>();
        data.put("name",name);
        data.put("country",country);
        data.put("state",state);
        collectionReference.document(name).set(data);
        Intent intent = new Intent(MainActivity.this, ListCountry.class);
        intent.putExtra("name",name);
        startActivity(intent);
    }

}
