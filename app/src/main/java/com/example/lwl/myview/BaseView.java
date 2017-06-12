package com.example.lwl.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lwl on 2017/6/12.
 */
public abstract class BaseView extends View{
    private MyThread thread;
    public BaseView(Context context) {
        super(context);
    }

    public BaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected abstract void drawSub(Canvas canvas);
    protected abstract void doSomething();

    @Override
    protected final void onDraw(Canvas canvas) {
        if(thread == null){
            thread = new MyThread();
            thread.start();
        }else{
            drawSub(canvas);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        running = false;
        super.onDetachedFromWindow();
    }

    private boolean running = true;
    class MyThread extends Thread{
        @Override
        public void run() {
             while(running){
                 doSomething();
                 postInvalidate();
                 try {
                     Thread.sleep(30);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
        }
    }
}
