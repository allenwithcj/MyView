package com.example.lwl.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by lwl on 2017/6/12.
 */
public class MyView2 extends BaseView{
    private Paint paint = new Paint();
    private float rx = 0;
    private MyThread thread;
    private RectF rectF = new RectF(0,60,100,160);
    private float sweepAngle = 0;
    private Random random = new Random();

    public MyView2(Context context) {
        super(context);
    }

    public MyView2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void drawSub(Canvas canvas) {
        paint.setTextSize(30);
        canvas.drawText("hello",rx,30,paint);
        canvas.drawArc(rectF,0,sweepAngle,true,paint);
    }

    @Override
    protected void doSomething() {
        rx +=3;
        if(rx > getWidth()){
            rx = 0 - paint.measureText("hello");
        }
        sweepAngle ++;
        if(sweepAngle >360){
            sweepAngle = 0;
        }
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        paint.setARGB(255,r,g,b);
    }
}
