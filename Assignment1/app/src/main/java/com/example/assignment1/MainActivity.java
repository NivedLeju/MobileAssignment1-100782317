package com.example.assignment1;

import android.os.Bundle;
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
        resultTextView = findViewById(R.id.resultTextView);

        calculateButton.setOnClickListener(v -> {
            double principal = Double.parseDouble(principalEditText.getText().toString());
            double tenure = Double.parseDouble(tenureEditText.getText().toString());
            double interestRate = Double.parseDouble(interestRateEditText.getText().toString());

            // Convert interest rate from annual to monthly and percentage to decimal
            interestRate = interestRate / 12 / 100;
            // Calculate monthly EMI
            double emi = (principal * interestRate * Math.pow(1 + interestRate, tenure)) /
                    (Math.pow(1 + interestRate, tenure) - 1);

            resultTextView.setText("Your monthly EMI is: " + String.format("%.2f", emi/12));
        });
    }
}
