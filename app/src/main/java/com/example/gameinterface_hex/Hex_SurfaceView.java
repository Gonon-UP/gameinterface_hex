package com.example.gameinterface_hex;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Region;
import android.widget.Button;


public class Hex_SurfaceView extends SurfaceView {

    private Paint brightPink = new Paint();
    private Paint forestGreen = new Paint();
    private Paint teal = new Paint();

    // Size and shape variables
    private Path hexagonPath;
    private Path hexagonBorderPath;
    private float radius;
    private float width, height;
    private float height_SurfaceView;
    private float width_SurfaceView;
    Paint hexPaint = new Paint();
    Paint hexBorderPaint = new Paint();



    public Hex_SurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        brightPink.setColor(0xFFFC0FC0);
        forestGreen.setColor(0xFF228B22);
        forestGreen.setStyle(Paint.Style.STROKE);
        teal.setColor(getResources().getColor(R.color.teal_700, null));

        hexPaint.setColor(Color.WHITE);
        hexBorderPaint.setColor(Color.BLACK);
        hexBorderPaint.setStyle(Paint.Style.STROKE);

        setUp();
        setWillNotDraw(false);
    }


    /**
     * External Citation
     * Date: 13 February 2024
     * Problem: Could not draw a hexagon on the surface view
     * Resource:
     * https://stackoverflow.com/questions/30217450/how-to-draw-hexagons-in-android
     * Solution: I used the example code from this post as the basis for the code below
     * Only change is the size and position of the hexagon
     */

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawColor(Color.WHITE);

        //canvas.getWidth();

        canvas.drawColor(Color.RED);
        canvas.drawPath(hexagonPath, hexPaint);
        canvas.drawPath(hexagonPath, hexBorderPaint);


//        canvas.clipPath(hexagonBorderPath, Region.Op.DIFFERENCE);
//        canvas.drawColor(Color.BLACK);
//        canvas.save();
//
//        canvas.clipPath(hexagonPath, Region.Op.DIFFERENCE);
        canvas.save();
    }


    private void setUp() {
        hexagonPath = new Path();
        hexagonBorderPath = new Path();
    }

    public void setRadius(float r) {
        this.radius = r;
        calculatePath();
    }


    private void calculatePath() {


        for (int i = 0; i < 770; i = i + 77) {
            float xOffset = (width_SurfaceView / 2) - 570;
            float yOffset = 200;
            for (int j = 0; j < 900; j = j + 90) {

                float triangleHeight = (float) (Math.sqrt(3) * radius / 2);
                float centerX = (width / 2 + i);
                float centerY = (height / 2 + j);
                hexagonPath.moveTo(xOffset + centerX, yOffset + centerY + radius);
                hexagonPath.lineTo(xOffset + centerX - triangleHeight, yOffset + centerY + radius / 2);
                hexagonPath.lineTo(xOffset + centerX - triangleHeight, yOffset + centerY - radius / 2);
                hexagonPath.lineTo(xOffset + centerX, yOffset + centerY - radius);
                hexagonPath.lineTo(xOffset + centerX + triangleHeight, yOffset + centerY - radius / 2);
                hexagonPath.lineTo(xOffset + centerX + triangleHeight, yOffset + centerY + radius / 2);
                hexagonPath.moveTo(xOffset + centerX, yOffset + centerY + radius);

                xOffset += 77 / 2;
                yOffset -= 24;


//                float radiusBorder = radius - 2;
//                float triangleBorderHeight = (float) (Math.sqrt(3) * radiusBorder / 2);
//                hexagonBorderPath.moveTo(centerX, centerY + radiusBorder);
//                hexagonBorderPath.lineTo(centerX - triangleBorderHeight, centerY + radiusBorder / 2);
//                hexagonBorderPath.lineTo(centerX - triangleBorderHeight, centerY - radiusBorder / 2);
//                hexagonBorderPath.lineTo(centerX, centerY - radiusBorder);
//                hexagonBorderPath.lineTo(centerX + triangleBorderHeight, centerY - radiusBorder / 2);
//                hexagonBorderPath.lineTo(centerX + triangleBorderHeight, centerY + radiusBorder / 2);
//                hexagonBorderPath.moveTo(centerX, centerY + radiusBorder);
                  invalidate();
            }
        }
    }


    // getting the view size and default radius
    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width_SurfaceView = MeasureSpec.getSize(widthMeasureSpec);
        // height_SurfaceView = MeasureSpec.getSize(MeasureSpec);
        width = 100; //MeasureSpec.getSize(widthMeasureSpec);
        height = 100; //MeasureSpec.getSize(heightMeasureSpec);
        radius = height / 2 - 5;
        calculatePath();
    }
}