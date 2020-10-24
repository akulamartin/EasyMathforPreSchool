package com.example.easymathforpreschool;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AnticipateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class Helper {

    public static final float DOTSCALE = 0.1f;
    public static final float DOTALPHA = 0.6f;
    public static final int DOTSIZE = 8;
    public static final double RATIO = (547d / 828d);
    public static final int MY_DOT = 9000;
    public static final int NUM_ID = 1000;
    public static final ArrayList<View> DOTLIST = new ArrayList<>();
    public static final String TOASTTEXT = "You did it!";
    public static int theWidth = 0;
    public static int theHeight = 0;
    public static ConstraintLayout myLayout;
    public static View firstDot;
    public static boolean dotsDone = false;
    public static int dotNumber = 1;
    public static int TOTALDOTS = 2;
    public static MediaPlayer mediaplayerMP2 = null;


    public static View createDot(int num, float left, float top, Context context) {
        Button dot = new Button(context);
        dot.setBackgroundResource(R.drawable.circle);
        dot.setId(MY_DOT + num);
        dot.setAlpha(DOTALPHA);
        dot.setClickable(true);
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                theWidth / DOTSIZE,
                theHeight / DOTSIZE);
        params.leftMargin = (int) (((double) theWidth / 2) - theHeight * RATIO / left);
        params.topMargin = (int) (theHeight / top);
        myLayout.addView(dot, params);
        return dot;
    }

    public static void refreshHelper() {
        for (int i = 0; i < DOTLIST.size(); i++) {
            View dot = DOTLIST.get(i);
            if (!dot.isClickable()) {
                dot.animate().setDuration(300).setInterpolator(new AnticipateInterpolator())
                        .scaleXBy(-DOTSCALE).scaleYBy(-DOTSCALE).alpha(DOTALPHA);
                dot.setClickable(true);
            }
        }
        dotNumber = 1;
        dotsDone = false;
    }

    public static void getScreenDimensions(Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(metrics);
        theWidth = metrics.widthPixels;
        theHeight = metrics.heightPixels;
    }

    public static void clickHelper(View v, final Context context) {
        int audioId;
        MediaPlayer mediaplayerMP;
        if (v.getId() == NUM_ID + 1) {
            if (!dotsDone) {
                mediaplayerMP = MediaPlayer.create(context, R.raw.incorrect);
                mediaplayerMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });

                mediaplayerMP.start();
            }

        } else {
            //animate dot clicked
            v.animate().setDuration(300).setInterpolator(new AnticipateInterpolator())
                    .scaleXBy(DOTSCALE).scaleYBy(DOTSCALE).alpha(1);
            v.setClickable(false);


            //play audio of number of dots clicked
            switch (dotNumber) {
                case 1:
                    audioId = R.raw.one;
                    break;
                case 2:
                    audioId = R.raw.two;
                    break;
                case 3:
                    audioId = R.raw.three;
                    break;
                case 4:
                    audioId = R.raw.four;
                    break;
                case 5:
                    audioId = R.raw.five;
                    break;
                case 6:
                    audioId = R.raw.six;
                    break;
                case 7:
                    audioId = R.raw.seven;
                    break;
                case 8:
                    audioId = R.raw.eight;
                    break;
                case 9:
                default:
                    audioId = R.raw.nine;
                    break;
            }
            dotNumber++;

            if (dotNumber > TOTALDOTS) {
                dotsDone = true;
                dotNumber = 1;
            }


            mediaplayerMP = MediaPlayer.create(context, audioId);
            mediaplayerMP.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                public void onCompletion(MediaPlayer mp) {

                    //celebrate if final dot is clicked

                    if (dotsDone) {
                        mp.release();
                        mediaplayerMP2 = MediaPlayer.create(context, R.raw.correct2);
                        mediaplayerMP2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                            public void onCompletion(MediaPlayer mp) {
                                mp.release();

                            }
                        });

                        mediaplayerMP2.start();

                        Toast toast = Toast.makeText(context, TOASTTEXT, Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        LinearLayout toastLayout = (LinearLayout) toast.getView();
                        TextView toastTV = (TextView) toastLayout.getChildAt(0);
                        toastTV.setTextSize(30);
                        toast.show();

                    }
                }
            });

            mediaplayerMP.start();

        }
    }

    public View createLine(int num, float left, float top, Context context) {
        Button dot = new Button(context);
        dot.setBackgroundResource(R.drawable.rectangle);
        dot.setId(MY_DOT + num);
        dot.setAlpha(DOTALPHA);
        dot.setClickable(true);
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                theWidth / DOTSIZE, theHeight / DOTSIZE);
        params.leftMargin = (int) (((double) theWidth / 2) - theHeight * RATIO / left);
        params.topMargin = (int) (theHeight / top);
        if ((dot.getId()) % 2 == 0) {
            dot.setRotation(45);
        } else {
            dot.setRotation(135);
        }
        myLayout.addView(dot, params);
        return dot;
    }


}
