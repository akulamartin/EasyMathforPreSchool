package com.martin.easymathforpreschool;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.view.View;

import com.nostra13.universalimageloader.core.ImageLoader;

import static com.martin.easymathforpreschool.DotHelper.ratio;

public class NumberBackground extends View {

    DisplayMetrics metrics;
    ImageLoader imageLoader;

    int numBitmap;

    public NumberBackground(Context context) {
        super(context);

        setBackgroundResource(R.drawable.bg);

        imageLoader = ImageLoader.getInstance();

    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        int x = DotHelper.width;
        int y = DotHelper.height;

        Bitmap bmp = imageLoader.loadImageSync("drawable://" + numBitmap);

        bmp = Bitmap.createScaledBitmap(bmp, (int) (y * ratio * .9f), (int) (y * .9f), true);

        canvas.drawBitmap(bmp, (x / 2) - (int) (y * ratio * .9f) / 2, 0, null);

    }


}