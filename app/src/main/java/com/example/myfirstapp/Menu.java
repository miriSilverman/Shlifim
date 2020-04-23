package com.example.myfirstapp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {
    ListView myList;
    String[] options;
    String[] prices;
    String[] descriptions;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Resources res = getResources();
        myList = (ListView) findViewById(R.id.myList);
        options = res.getStringArray(R.array.options);
        prices = res.getStringArray(R.array.prices);
        descriptions = res.getStringArray(R.array.descriptions);

        ItemAdapter itemAdapter = new ItemAdapter(this, options, prices, descriptions);
        myList.setAdapter(itemAdapter);


        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent showDetailActivity = new Intent(getApplicationContext(), Options.class);
                showDetailActivity.putExtra("androidx.appcompat.app.AppCompatActivity.ITEM_INDEX", position);
                startActivity(showDetailActivity);

            }
        });


    }
}
