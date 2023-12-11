package com.example.firstapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Home extends AppCompatActivity {

    ArrayList<DataModel> dataModels;
    ListView listView;

    private static CustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);


        List<String> imageNames = Arrays.asList(
                "https://picsum.photos/800",
                "https://picsum.photos/200",
                "https://picsum.photos/300",
                "https://picsum.photos/400",
                "https://picsum.photos/500",
                "https://picsum.photos/600",
                "https://picsum.photos/700"
        );

        listView = (ListView) findViewById(R.id.list);

        dataModels = new ArrayList<>();

        dataModels.add(new DataModel("Apple Pie", "free shipping", 1, "September 23, 2008", imageNames.get(0), 10));
        dataModels.add(new DataModel("Banana Bread", "free shipping ", 2, "February 9, 2009", imageNames.get(1), 10));
        dataModels.add(new DataModel("Cupcake", "free shipping ", 3, "April 27, 2009", imageNames.get(2), 10));
        dataModels.add(new DataModel("Donut", "free shipping", 4, "September 15, 2009", imageNames.get(3), 10));
        dataModels.add(new DataModel("Eclair", "free shipping ", 5, "October 26, 2009", imageNames.get(4), 10));
        dataModels.add(new DataModel("Froyo", "free shipping", 8, "May 20, 2010", imageNames.get(5), 10));
        dataModels.add(new DataModel("Gingerbread", "free shipping", 9, "December 6, 2010", imageNames.get(6), 10));


        adapter = new CustomAdapter(dataModels, getApplicationContext(), this);

        listView.setAdapter(adapter);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void showShoppingCart() {
        int totalSelectedProducts = 0;
        int totalPrice = 0;


        for (DataModel item : dataModels) {
            if (item.isSelected()) {
                totalSelectedProducts += item.getSelectedQuantity();
                totalPrice += item.getTotalPrice();
            }
        }

        // Now 'totalSelectedProducts' contains the total number of selected products
        // 'totalPrice' contains the total price of selected products

        // Find the TextViews by their IDs
        TextView totalSelectedPriceTextView = findViewById(R.id.totalSelectedPrice);
        TextView badgeTextView = findViewById(R.id.badg);

        if (totalSelectedPriceTextView != null) {
            // Update the total price TextView
            totalSelectedPriceTextView.setText(totalPrice + " DZD");
        }

        if (badgeTextView != null) {
            // Update the badge TextView with the total selected products
            badgeTextView.setText(String.valueOf(totalSelectedProducts));
        }


        Log.d("Selected Products", String.valueOf(totalSelectedProducts));
        Log.d("Total Price", String.valueOf(totalPrice));

    }

}