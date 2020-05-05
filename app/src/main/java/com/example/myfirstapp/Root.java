package com.example.myfirstapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Root extends AppCompatActivity {
    public static Button exit;

    public void backToMainButton()
    {
        exit = (Button)findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(Root.this);
                alert.setMessage("wanna go back to main menu?")
                        .setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog alertDialog = alert.create();
                alertDialog.setTitle("Hi there !!!!");
                alertDialog.show();

            }
        });
    }

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


        backToMainButton();



    }
}
