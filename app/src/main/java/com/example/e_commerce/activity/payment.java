package com.example.e_commerce.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_commerce.Database.MyDatabase;
import com.example.e_commerce.R;

public class payment extends AppCompatActivity {
    EditText CardNumber, ExpireDateMonth, ExpireDateYear;
    Button addCreditCard;
    String userId;
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        MyDatabase obj = MyDatabase.getInstance(this);
        Intent i = getIntent();
        userId = i.getStringExtra("id");
        CardNumber = findViewById(R.id.CardNumber);
        ExpireDateMonth = findViewById(R.id.ExpireDateMonth);
        ExpireDateYear = findViewById(R.id.ExpireDateYear);
        addCreditCard = findViewById(R.id.AddPayment);

        addCreditCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get credit card information from the input fields
                String cardNumber = CardNumber.getText().toString();
                String expireDateMonth = ExpireDateMonth.getText().toString();
                String expireDateYear = ExpireDateYear.getText().toString();

                if(cardNumber.isEmpty() || expireDateMonth.isEmpty() || expireDateYear.isEmpty()){
                    Toast.makeText(payment.this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
                }else {

                }
            }
        });
    }
}