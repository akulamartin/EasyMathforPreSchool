package com.martin.easymathforpreschool;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import static com.martin.easymathforpreschool.DotHelper.NUM_ID;
import static com.martin.easymathforpreschool.DotHelper.checkMode;
import static com.martin.easymathforpreschool.DotHelper.clickHelper;
import static com.martin.easymathforpreschool.DotHelper.createDot;
import static com.martin.easymathforpreschool.DotHelper.dot1;
import static com.martin.easymathforpreschool.DotHelper.dot2;
import static com.martin.easymathforpreschool.DotHelper.dot3;
import static com.martin.easymathforpreschool.DotHelper.dotNumber;
import static com.martin.easymathforpreschool.DotHelper.dotsDone;
import static com.martin.easymathforpreschool.DotHelper.getScreenDimensions;
import static com.martin.easymathforpreschool.DotHelper.myLayout;
import static com.martin.easymathforpreschool.DotHelper.refreshHelper;
import static com.martin.easymathforpreschool.DotHelper.totalDots;


public class DotsThree extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dots);

        //initialize variables
        totalDots = 3;
        dotsDone = false;
        dotNumber = 1;
        myLayout = findViewById(R.id.mainView);

        getScreenDimensions(this);

        checkMode();

        //create screen layout
        NumberBackground numView = new NumberBackground(this);
        numView.setOnClickListener(this);
        numView.setClickable(true);
        numView.setId(NUM_ID + 1);
        numView.numBitmap = MainActivity.threeBitmap;
        myLayout.addView(numView);

        dot1 = createDot(1, 2.7f, 4.9f, this);
        dot2 = createDot(2, 7f, 2.75f, this);
        dot3 = createDot(3, 2.65f, 1.75f, this);
        dot1.setOnClickListener(this);
        dot2.setOnClickListener(this);
        dot3.setOnClickListener(this);

        getLayoutInflater().inflate(R.layout.navbuttons, myLayout);

    }


    public void onClick(View v) {
        clickHelper(v, getApplicationContext());
    }


    public void refreshDots(View view) {
        refreshHelper();
    }

    public void home(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void leftNav(View view) {
        Intent intent = new Intent(this, DotsTwo.class);
        startActivity(intent);
    }

    public void rightNav(View view) {
        Intent intent = new Intent(this, DotsFour.class);
        startActivity(intent);
    }
}