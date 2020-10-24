package com.martin.easymathforpreschool;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import static com.martin.easymathforpreschool.DotHelper.NUM_ID;
import static com.martin.easymathforpreschool.DotHelper.checkMode;
import static com.martin.easymathforpreschool.DotHelper.clickHelper;
import static com.martin.easymathforpreschool.DotHelper.createLine;
import static com.martin.easymathforpreschool.DotHelper.dot1;
import static com.martin.easymathforpreschool.DotHelper.dot2;
import static com.martin.easymathforpreschool.DotHelper.dot3;
import static com.martin.easymathforpreschool.DotHelper.dot4;
import static com.martin.easymathforpreschool.DotHelper.dot5;
import static com.martin.easymathforpreschool.DotHelper.dot6;
import static com.martin.easymathforpreschool.DotHelper.dot7;
import static com.martin.easymathforpreschool.DotHelper.dot8;
import static com.martin.easymathforpreschool.DotHelper.dotNumber;
import static com.martin.easymathforpreschool.DotHelper.dotsDone;
import static com.martin.easymathforpreschool.DotHelper.getScreenDimensions;
import static com.martin.easymathforpreschool.DotHelper.myLayout;
import static com.martin.easymathforpreschool.DotHelper.refreshHelper;
import static com.martin.easymathforpreschool.DotHelper.totalDots;


public class DotsEight extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dots);

        //initialize variables
        totalDots = 8;
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
        numView.numBitmap = MainActivity.eightBitmap;
        myLayout.addView(numView);

        dot1 = createLine(1, 2.4f, 4.5f, this);
        dot2 = createLine(2, 2.4f, 4.5f, this);
        dot3 = createLine(3, -12f, 4.5f, this);
        dot4 = createLine(4, -12f, 4.5f, this);
        dot5 = createLine(5, 2.17f, 1.7f, this);
        dot6 = createLine(6, 2.17f, 1.7f, this);
        dot7 = createLine(7, -7f, 1.7f, this);
        dot8 = createLine(8, -7f, 1.7f, this);
        dot1.setOnClickListener(this);
        dot2.setOnClickListener(this);
        dot3.setOnClickListener(this);
        dot4.setOnClickListener(this);
        dot5.setOnClickListener(this);
        dot6.setOnClickListener(this);
        dot7.setOnClickListener(this);
        dot8.setOnClickListener(this);

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
        Intent intent = new Intent(this, DotsSeven.class);
        startActivity(intent);
    }

    public void rightNav(View view) {
        Intent intent = new Intent(this, DotsNine.class);
        startActivity(intent);
    }
}