package com.martin.easymathforpreschool;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.text.util.Linkify;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class About extends AppCompatActivity {
    TextView aboutText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        aboutText = findViewById(R.id.aboutText);

        aboutText.setMovementMethod(new ScrollingMovementMethod());
        Linkify.addLinks(aboutText, Linkify.WEB_URLS);
    }
}
