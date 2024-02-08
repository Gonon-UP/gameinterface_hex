package com.example.gameinterface_hex;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;



public class Hex_SurfaceView extends SurfaceView    {


    private Paint brightPink = new Paint();
    private Paint forestGreen = new Paint();
    private Paint teal = new Paint();


    public Hex_SurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        brightPink.setColor(0xFFFC0FC0);
        forestGreen.setColor(0xFF228B22);
        forestGreen.setStyle(Paint.Style.STROKE);
        teal.setColor(getResources().getColor(R.color.teal_700, null));

        setWillNotDraw(false);
    }
    // Drag and drop
    // Zoom in and out
    // Change color settings
    // Wizard
    // Ads
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(200.0f, 300.0f, 50.0f, brightPink);
        canvas.drawRect(300.0f, 100.0f, 350.0f, 175.0f, forestGreen);

        // int[] xPoints = {200, 300, 350, 300, 200, 150};
        // int[] yPoints = {350, 350, 250, 150, 150, 250};
        // canvas.drawPoint(xPoints, yPoints, xPoints.length);
        }
//        for(int i = 1, i < 6, i++){
//            canvas.drawPoint();
//        }

        //Create a bitmap oblect that contains the image
//        Bitmap smileyBitmap =
//                BitmapFactory.decodeResource(getResources(),
//                        R.drawable.smiley_cody);
//
//        //Resize to 100x100 dp
//        smileyBitmap = Bitmap.createScaledBitmap(smileyBitmap, 100, 100, false);
//
//        //draw the bit map
//        canvas.drawBitmap(smileyBitmap, 500.0f, 200.0f, null);

}
