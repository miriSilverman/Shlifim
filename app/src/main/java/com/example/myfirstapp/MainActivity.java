package com.example.myfirstapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addBtn = (Button) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText firstNumEditText = (EditText)findViewById(R.id.firstNumEditText);
                EditText secondNumEditText = (EditText)findViewById(R.id.secondEditText);
                TextView result = (TextView)findViewById(R.id.results);

                int num1 = Integer.parseInt(firstNumEditText.getText().toString());
                int num2 = Integer.parseInt(secondNumEditText.getText().toString());
                int results = num1 + num2;
                result.setText(results+"");
            }
        });

        Button multBtn = (Button) findViewById(R.id.multiplyBtn);
        multBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText firstNumEditText = (EditText)findViewById(R.id.firstNumEditText);
                EditText secondNumEditText = (EditText)findViewById(R.id.secondEditText);
                TextView result = (TextView)findViewById(R.id.results);

                int num1 = Integer.parseInt(firstNumEditText.getText().toString());
                int num2 = Integer.parseInt(secondNumEditText.getText().toString());
                int results = num1 * num2;
                result.setText(results+"");

            }
        });


        Button rootBtn = (Button) findViewById(R.id.Root);
        rootBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Root.class);
                startIntent.putExtra("com.example.myfirstapp.SOMETHING", "Welcome to the roots world!");
                startActivity(startIntent);
            }
        });


        Button moreOptions = (Button) findViewById(R.id.moreOptions);
        moreOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Menu.class);
//                startIntent.putExtra("moving to ", "Welcome to the roots world!");
                startActivity(startIntent);
            }
        });



        Button walfarmBtn = (Button) findViewById(R.id.walfarm);
        walfarmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String path = "https://www.wolframalpha.com/";
                Uri web = Uri.parse(path);

                Intent goToWolf = new Intent(Intent.ACTION_VIEW, web);
                if (goToWolf.resolveActivity(getPackageManager()) != null)
                {
                    startActivity(goToWolf);
                }
            }
        });



    }
}
