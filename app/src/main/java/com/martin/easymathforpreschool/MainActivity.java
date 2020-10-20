package com.martin.easymathforpreschool;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class MainActivity extends AppCompatActivity {

    public static int oneBitmap, twoBitmap, threeBitmap, fourBitmap, fiveBitmap, sixBitmap, sevenBitmap, eightBitmap, nineBitmap;
    public static String mode = "learn";
    Bitmap numberBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create global configuration and initialize ImageLoader with this config
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .build();
        ImageLoader.getInstance().init(config);

        createBitmaps();
    }

    private void createBitmaps() {
        oneBitmap = R.drawable.one;
        twoBitmap = R.drawable.two;
        threeBitmap = R.drawable.three;
        fourBitmap = R.drawable.four;
        fiveBitmap = R.drawable.five;
        sixBitmap = R.drawable.six;
        sevenBitmap = R.drawable.seven;
        eightBitmap = R.drawable.eight;
        nineBitmap = R.drawable.nine;

    }

    public void countDots(View view) {
        mode = "learn";
        Intent intent = new Intent(this, DotsOne.class);
        startActivity(intent);
    }

    public void practice(View view) {
        mode = "practice";
        Intent intent = new Intent(this, DotsOne.class);
        startActivity(intent);
    }

    public void add(View view) {

        Intent intent = new Intent(this, Add.class);
        startActivity(intent);
    }

    public void subtract(View view) {

        Intent intent = new Intent(this, Subtract.class);
        startActivity(intent);
    }

    public void multiply(View view) {

        Intent intent = new Intent(this, Multiply.class);
        startActivity(intent);
    }

    public void divide(View view) {

        Intent intent = new Intent(this, Divide.class);
        startActivity(intent);
    }

    public void about(View view) {
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }
}
