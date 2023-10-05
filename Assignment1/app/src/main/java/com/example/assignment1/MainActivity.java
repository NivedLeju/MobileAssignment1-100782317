package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText principalEditText, tenureEditText, interestRateEditText;
    Button calculateButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assigning elements by id to each variable
        principalEditText = findViewById(R.id.principalEditText);
        tenureEditText = findViewById(R.id.tenureEditText);
        interestRateEditText = findViewById(R.id.interestRateEditText);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(v -> {
            //declaring variables and initializing them
            double principal = Double.parseDouble(principalEditText.getText().toString());
            double tenure = Double.parseDouble(tenureEditText.getText().toString());
            double interestRate = Double.parseDouble(interestRateEditText.getText().toString());

            // Convert interest rate from annual to monthly and percentage to decimal
            interestRate = interestRate /12/100;
            tenure = tenure*12;
            // Calculate monthly EMI
            double emi = (principal * interestRate * Math.pow(1 + interestRate, tenure)) /
                    (Math.pow(1 + interestRate, tenure) - 1);

            //created intent and passed emi value in intent to be displayed on second page
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("emiResult", emi); // Pass the emiResult value
            startActivity(intent);
        });
    }
}
