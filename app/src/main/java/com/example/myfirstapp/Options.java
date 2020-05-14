package com.example.myfirstapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Options extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        Intent in = getIntent();
        int index = in.getIntExtra("androidx.appcompat.app.AppCompatActivity.ITEM_INDEX", -1);
        if (index == 0)
        {
            Intent intent = new Intent(".transformations");
            startActivity(intent);
        }
        else if (index > -1)
        {
            int pic = getImage(index);
            ImageView img = (ImageView) findViewById(R.id.imageView);
            scaleImage(img, pic);
        }
    }



    public int getImage(int index)
    {
        switch (index)
        {
            case 0:
                return R.drawable.translation;
//                return R.drawable.hermione;
            case 1:
                return R.drawable.harry;
            case 2:
                return R.drawable.ron;
            default:
                return -1;
        }
    }



    public void scaleImage(ImageView img, int pic)
    {
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options op = new BitmapFactory.Options();

        op.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), pic, op);
        int imgWidth = op.outWidth;
        int screenWidth = screen.getWidth();

        if(imgWidth > screenWidth)
        {
            int ratio = Math.round( (float)imgWidth / (float) screenWidth);
            op.inSampleSize = ratio;
        }

        op.inJustDecodeBounds = false;
        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(), pic, op);
        img.setImageBitmap(scaledImg);

    }

}
