package com.example.gameinterface_hex;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Region;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;


public class Hex_SurfaceView extends SurfaceView implements View.OnTouchListener {

    private Paint brightPink = new Paint();
    private Paint forestGreen = new Paint();
    private Paint teal = new Paint();

    // Size and shape variables
    private Path hexagonGridPath;
    private Path hexagonBorderPath;
    private float radius;
    private float width, height;
    private float height_SurfaceView;
    private float width_SurfaceView;
    Paint hexPaint = new Paint();
    Paint hexBorderPaint = new Paint();


    Paint hexRedSide = new Paint();
    Paint hexBlueSide = new Paint();

    ArrayList<HexTile> tileList = new ArrayList<>();


    public Hex_SurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        brightPink.setColor(0xFFFC0FC0);
        forestGreen.setColor(0xFF228B22);
        forestGreen.setStyle(Paint.Style.STROKE);
        teal.setColor(getResources().getColor(R.color.teal_700, null));

        hexPaint.setColor(Color.WHITE);
        hexBorderPaint.setColor(Color.BLACK);
        hexBorderPaint.setStyle(Paint.Style.STROKE);

        hexRedSide.setColor(Color.RED);
        hexBlueSide.setColor(Color.BLUE);

        this.setOnTouchListener(this);

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
        //height_SurfaceView = (float) getHeight();


        canvas.drawColor(Color.GRAY);

        //draws the blue side
        drawTriangle(610, 80, 875, 770, true, hexBlueSide, canvas); //left
        drawTriangle(1125, 850, 875, 770, false, hexBlueSide, canvas);//right
        //draws the red side
        drawTriangle(610, 80, 950, 400, true, hexRedSide, canvas);//top
        drawTriangle(1040, 850, 950, 400, false, hexRedSide, canvas);//bottom


        canvas.drawPath(hexagonGridPath, hexPaint);
        canvas.drawPath(hexagonGridPath, hexBorderPaint);


//        canvas.clipPath(hexagonBorderPath, Region.Op.DIFFERENCE);
//        canvas.drawColor(Color.BLACK);
//        canvas.save();
//
//        canvas.clipPath(hexagonPath, Region.Op.DIFFERENCE);
        canvas.save();

        // draws Hex Tiles
        for(HexTile hT : tileList) {
            hT.draw(canvas);
        }
    }


    private void setUp() {
        hexagonGridPath = new Path();
        hexagonBorderPath = new Path();
    }


    private void calculatePath() {
        for (float i = 0; i < 781; i = i + 73) {
            float xOffset = (width_SurfaceView / 2) - 590;
            float yOffset = 100;
            for (int j = 0; j < 990; j = j + 90) {

                float triangleHeight = (float) (Math.sqrt(3) * radius / 2);
                float centerX = (width / 2 + i);
                float centerY = (height / 2 + j);
                hexagonGridPath.moveTo(xOffset + centerX, yOffset + centerY + radius);

                hexagonGridPath.lineTo(xOffset + centerX - triangleHeight, yOffset + centerY + radius / 2);
                hexagonGridPath.lineTo(xOffset + centerX - triangleHeight, yOffset + centerY - radius / 2);
                hexagonGridPath.lineTo(xOffset + centerX, yOffset + centerY - radius);
                hexagonGridPath.lineTo(xOffset + centerX + triangleHeight, yOffset + centerY - radius / 2);
                hexagonGridPath.lineTo(xOffset + centerX + triangleHeight, yOffset + centerY + radius / 2);
                // hexagonGridPath.moveTo(xOffset + centerX, yOffset + centerY + radius);

                xOffset += (70 / 2) + 2;
                yOffset -= 25;

                invalidate();
            }
        }
    }


    // getting the view size and default radius
    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width_SurfaceView = MeasureSpec.getSize(widthMeasureSpec);
        height_SurfaceView = MeasureSpec.getSize(heightMeasureSpec);
        width = 85; //MeasureSpec.getSize(widthMeasureSpec);
        height = 85; //MeasureSpec.getSize(heightMeasureSpec);
        radius = (height / 2);
        calculatePath();
    }

    //method for drawing the sides of the hex board
    private void drawTriangle(int x, int y, int width, int height, boolean inverted, Paint paint, Canvas canvas) {


        Point p1 = new Point(x, y);
        int pointX = x + width / 2;
        int pointY = inverted ? y + height : y - height;

        Point p2 = new Point(pointX, pointY);
        Point p3 = new Point(x + width, y);


        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(p1.x, p1.y);
        path.lineTo(p2.x, p2.y);
        path.lineTo(p3.x, p3.y);
        path.close();

        canvas.drawPath(path, paint);
    }

    // what are we trying to do first: get the center of the hexagon or comparing to where the user touches?

    /** whenever the user touches the surface view */
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        HexTile hexTile = new HexTile(x,y);
        tileList.add(hexTile);
        this.invalidate();

        return false;

    }
}
