package com.example.myfirstapp;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FromRoot extends AppCompatActivity {
    private static SeekBar seekBar;
    private static TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_root);
        seekBarOnCreate();
    }



    public void seekBarOnCreate()
    {
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText("covered: "+ seekBar.getProgress()+ " /  "+seekBar.getMax());


        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    int progressValue;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        progressValue = progress;
                        textView.setText("covered: "+ progressValue+ " /  "+seekBar.getMax());
//                        Toast.makeText(FromRoot.this, "seek bar on progress", Toast.LENGTH_SHORT).show();



                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
//                        Toast.makeText(FromRoot.this, "seek bar on start tracking", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        textView.setText("covered: "+ progressValue+ " /  "+seekBar.getMax());
//                        Toast.makeText(FromRoot.this, "seek bar on stop tracking", Toast.LENGTH_SHORT).show();


                    }
                }
        );


    }













}
