package com.martin.easymathforpreschool;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import static com.martin.easymathforpreschool.DotHelper.NUM_ID;
import static com.martin.easymathforpreschool.DotHelper.checkMode;
import static com.martin.easymathforpreschool.DotHelper.clickHelper;
import static com.martin.easymathforpreschool.DotHelper.createDot;
import static com.martin.easymathforpreschool.DotHelper.createLine;
import static com.martin.easymathforpreschool.DotHelper.dot1;
import static com.martin.easymathforpreschool.DotHelper.dot2;
import static com.martin.easymathforpreschool.DotHelper.dot3;
import static com.martin.easymathforpreschool.DotHelper.dot4;
import static com.martin.easymathforpreschool.DotHelper.dot5;
import static com.martin.easymathforpreschool.DotHelper.dot6;
import static com.martin.easymathforpreschool.DotHelper.dot7;
import static com.martin.easymathforpreschool.DotHelper.dot8;
import static com.martin.easymathforpreschool.DotHelper.dot9;
import static com.martin.easymathforpreschool.DotHelper.dotNumber;
import static com.martin.easymathforpreschool.DotHelper.dotsDone;
import static com.martin.easymathforpreschool.DotHelper.getScreenDimensions;
import static com.martin.easymathforpreschool.DotHelper.myLayout;
import static com.martin.easymathforpreschool.DotHelper.refreshHelper;
import static com.martin.easymathforpreschool.DotHelper.totalDots;


public class DotsNine extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dots);

        //initialize variables
        totalDots = 9;
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
        numView.numBitmap = MainActivity.nineBitmap;
        myLayout.addView(numView);

        dot1 = createDot(1, 2.55f, 4f, this);
        dot2 = createLine(2, 5.5f, 12f, this);
        dot3 = createLine(3, 5.5f, 12f, this);
        dot4 = createLine(4, -8f, 3.5f, this);
        dot5 = createLine(5, -8f, 3.5f, this);
        dot6 = createLine(6, -8f, 1.9f, this);
        dot7 = createLine(7, -8f, 1.9f, this);
        dot8 = createLine(8, 14f, 1.34f, this);
        dot9 = createLine(9, 14f, 1.34f, this);
        dot1.setOnClickListener(this);
        dot2.setOnClickListener(this);
        dot3.setOnClickListener(this);
        dot4.setOnClickListener(this);
        dot5.setOnClickListener(this);
        dot6.setOnClickListener(this);
        dot7.setOnClickListener(this);
        dot8.setOnClickListener(this);
        dot9.setOnClickListener(this);

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
        Intent intent = new Intent(this, DotsEight.class);
        startActivity(intent);
    }

    public void rightNav(View view) {
        Intent intent = new Intent(this, DotsOne.class);
        startActivity(intent);
    }
}