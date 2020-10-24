package com.example.easymathforpreschool;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.easymathforpreschool.numbers.One;

public class MainActivity extends AppCompatActivity {

    public static final int ONEBITMAP = R.drawable.num_1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        final Button buttonAbout = findViewById(R.id.button_about);
        final Button buttonLearn = findViewById(R.id.button_learn);

        buttonAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aboutIntent = new Intent(MainActivity.this, AboutApp.class);
                startActivity(aboutIntent);
            }
        });

        buttonLearn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent learnIntent = new Intent(MainActivity.this, One.class);
                startActivity(learnIntent);
            }
        });
    }

}
