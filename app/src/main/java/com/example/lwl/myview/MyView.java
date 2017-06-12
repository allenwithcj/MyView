package com.example.lwl.myview;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lwl on 2017/6/12.
 */
public class MyView extends View{
    private Bitmap bitmap;

    public MyView(Context context) {
        super(context);

    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Paint paint = new Paint();
        paint.setTextSize(30);
        paint.setColor(0xffff0000);
        paint.setStyle(Paint.Style.STROKE);//空心
        //绘制文字
        canvas.drawText("hello world",0,30,paint);
        //绘制直线
        canvas.drawLine(0,60,100,60,paint);
        //绘制矩形
        canvas.drawRect(0,90,100,190,paint);

        Rect r = new Rect(0,90,100,190);//left  距离左边x坐标 top巨鹿顶部y坐标 right距离右x坐标  bottom距离底部y坐标
        canvas.drawRect(r,paint);

        RectF r1 = new RectF(0,90,100,190);
        canvas.drawRect(r1,paint);

        //绘制圆角矩形
        RectF r2 = new RectF(0,90,100,190);
        canvas.drawRoundRect(r2,10,10,paint);

        //绘制圆形
        canvas.drawCircle(50,270,50,paint);//cx圆心x的坐标 cy圆心y的坐标 radius半径

        //绘制图片
        canvas.drawBitmap(bitmap,0,350,paint);
    }
}
