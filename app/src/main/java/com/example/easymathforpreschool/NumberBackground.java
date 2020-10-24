package com.example.easymathforpreschool;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;

import com.nostra13.universalimageloader.core.ImageLoader;

import static com.example.easymathforpreschool.Helper.RATIO;

public class NumberBackground extends View {
    public int numBitmap;
    ImageLoader imageLoader;
    Bitmap bmp;
    int xh = Helper.theWidth;
    int yh = Helper.theHeight;

    public NumberBackground(Context context) {
        super(context);
        bmp = imageLoader.loadImageSync("drawable://" + numBitmap);
        imageLoader = ImageLoader.getInstance();

        bmp = Bitmap.createScaledBitmap(bmp, (int) (xh * RATIO * .9f), (int) (yh * .9f), true);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(bmp, (float) ((double) xh / 2) - (float) (yh * RATIO * .9f) / 2, 0, null);
    }
}
