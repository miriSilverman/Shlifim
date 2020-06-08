package com.example.myfirstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class transformations extends AppCompatActivity {

    private Button shearing;
    private Button scaling;
    private Button rotation;
    private Button reflection;
    private Button translation;
    private Button[] btns = {shearing,scaling,rotation, reflection};
    private ImageView imgView;
    private int[] images = {R.drawable.ron, R.drawable.shearing,R.drawable.scaling,R.drawable.rotation,
            R.drawable.reflection, R.drawable.translation};

    public void transformation()
    {
        shearing = (Button) findViewById(R.id.shearing);
        scaling = (Button) findViewById(R.id.scailing);
        rotation = (Button) findViewById(R.id.rotation);
        reflection = (Button) findViewById(R.id.reflection);
        translation = (Button) findViewById(R.id.translation);
        imgView = (ImageView) findViewById(R.id.transformationing);

        translation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                imgView.setImageResource(images[5]);
            }
        });


        reflection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                imgView.setImageResource(images[4]);
            }
        });

        rotation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                imgView.setImageResource(images[3]);
            }
        });

        scaling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                imgView.setImageResource(images[2]);
            }
        });


        shearing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                imgView.setImageResource(images[1]);
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transformations);
        transformation();
    }





}
