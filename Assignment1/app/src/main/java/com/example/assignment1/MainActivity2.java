package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        EditText emiResult = findViewById(R.id.editTextText);
        ImageButton img = findViewById(R.id.imageButton);

        //receiving emi value from first page using intent
        double emi = getIntent().getDoubleExtra("emiResult", 0.0);
        //setting text view to show emi value
        emiResult.setText( String.format("%.2f", emi));

        img.setOnClickListener(v-> { //return to main page button
            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(intent);
        });
    }
}