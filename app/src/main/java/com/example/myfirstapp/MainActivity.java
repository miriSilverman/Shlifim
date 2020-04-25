package com.example.myfirstapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    MediaPlayer player;


    public void play(View view)
    {
        if (player == null)
        {
            player = MediaPlayer.create(this, R.raw.monkey);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }
        player.start();
    }
    public void pause(View view){
        if (player != null)
        {
            player.pause();
        }
    }
    public void stop(View view){
        stopPlayer();
    }
    public void stopPlayer(){
        if (player != null)
        {
            player.release();
            player = null;
            Toast.makeText(this, "Media player released", Toast.LENGTH_SHORT);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
    {
        case R.id.item1:
            Toast.makeText(this, "press the dots to play song", Toast.LENGTH_SHORT).show();
            return true;
        case R.id.item2:
            play(this.findViewById(R.id.imageView));

            Toast.makeText(this, "playing song", Toast.LENGTH_SHORT).show();
            return true;
        case R.id.item3:
            return true;
        case R.id.sub_item1:
            stop(this.findViewById(R.id.imageView));

            Toast.makeText(this, "song is stopped", Toast.LENGTH_SHORT).show();
            return true;
        case R.id.sub_item2:
            pause(this.findViewById(R.id.imageView));
            Toast.makeText(this, "song is paused", Toast.LENGTH_SHORT).show();
            return true;
        default:
            return super.onOptionsItemSelected(item);


    }

    }

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
