package com.example.firstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Product extends AppCompatActivity {
    private TextView tvQuantity;
    private Button btnAdd;
    private Button btnMinus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.row_item);

        tvQuantity = findViewById(R.id.qty);
        btnAdd = findViewById(R.id.btnAdd);
        btnMinus = findViewById(R.id.btnMinus);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementQuantity();
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementQuantity();
            }
        });
    }

    private void incrementQuantity() {
        int quantity = Integer.parseInt(tvQuantity.getText().toString());
        quantity++;
        tvQuantity.setText(String.valueOf(quantity));
    }

    private void decrementQuantity() {
        int quantity = Integer.parseInt(tvQuantity.getText().toString());
        if (quantity > 0) {
            quantity--;
            tvQuantity.setText(String.valueOf(quantity));
        }
    }

}
