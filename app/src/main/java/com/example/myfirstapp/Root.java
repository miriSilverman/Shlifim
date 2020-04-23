package com.example.myfirstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Root extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);

        if (getIntent().hasExtra("com.example.myfirstapp.SOMETHING"))
        {
            TextView title = (TextView) findViewById(R.id.title);
            String text = getIntent().getExtras().getString("com.example.myfirstapp.SOMETHING");
            title.setText(text);
        }

        Button calc = (Button) findViewById(R.id.calc);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText a = (EditText) findViewById(R.id.a);
                EditText b = (EditText) findViewById(R.id.b);
                EditText c = (EditText) findViewById(R.id.c);

                TextView result = (TextView) findViewById(R.id.res);

                int a_num = Integer.parseInt(a.getText().toString());
                int b_num = Integer.parseInt(b.getText().toString());
                int c_num = Integer.parseInt(c.getText().toString());
                double res1 = (-b_num + Math.sqrt(Math.pow(b_num, 2) -4*a_num*c_num)) / (2*a_num);
                double res2 = (-b_num - Math.sqrt(Math.pow(b_num, 2) -4*a_num*c_num)) / (2*a_num);

                result.setText("first root is: \n      "+ res1 + "\n\nsecond root is: \n      "+res2+"");

            }
        });








    }
}
