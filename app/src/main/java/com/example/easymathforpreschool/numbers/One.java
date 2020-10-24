package com.example.easymathforpreschool.numbers;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.easymathforpreschool.MainActivity;
import com.example.easymathforpreschool.NumberBackground;
import com.example.easymathforpreschool.R;

import static com.example.easymathforpreschool.Helper.NUM_ID;
import static com.example.easymathforpreschool.Helper.TOTALDOTS;
import static com.example.easymathforpreschool.Helper.clickHelper;
import static com.example.easymathforpreschool.Helper.createDot;
import static com.example.easymathforpreschool.Helper.dotNumber;
import static com.example.easymathforpreschool.Helper.dotsDone;
import static com.example.easymathforpreschool.Helper.firstDot;
import static com.example.easymathforpreschool.Helper.getScreenDimensions;
import static com.example.easymathforpreschool.Helper.myLayout;

public class One extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dots);
        TOTALDOTS = 1;
        dotsDone = false;
        dotNumber = 1;
        myLayout = findViewById(R.id.main_view);

        getScreenDimensions(this);

        //create screen layout
        NumberBackground numView = new NumberBackground(this);
        numView.setOnClickListener(this);
        numView.setClickable(true);
        numView.setId(NUM_ID + 1);
        numView.numBitmap = MainActivity.ONEBITMAP;

        myLayout.addView(numView);

        firstDot = createDot(1, 11f, 20f, this);

        firstDot.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        clickHelper(v, getApplicationContext());
    }


}
