package com.example.user.sudoku;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import static android.support.v4.content.ContextCompat.startActivity;


public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {


    public static int WIDTH;
    public static int HEIGHT;
    public static Canvas canvas;


    SurfaceHolder surfaceHolder;
    GameLogic gameLogic;

    FullBoard fullBoard;
    HalfBoard halfBoard;
    EmptyBoard emptyBoard;


    public GamePanel(Context context, int WIDTH, int HEIGHT) {
        super(context);



        GamePanel.WIDTH = WIDTH;
        GamePanel.HEIGHT = HEIGHT;


        getHolder().addCallback(this);

    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {


        //this.draw(canvas);

        return super.onTouchEvent(event);
    }

    @Override
    public void draw(Canvas canvas) {

        surfaceHolder = this.getHolder();
        //we lock/point canvas to our content view
        canvas = surfaceHolder.lockCanvas();

        // call the super class
        super.draw(canvas);

        // This is the color ( background color) of our canvas
        canvas.drawColor(Color.GRAY);

        emptyBoard.draw(canvas);

        halfBoard.draw(canvas);

        fullBoard.draw(canvas);


        // unlock from content view, and post the draw - draw it !!!
        surfaceHolder.unlockCanvasAndPost(canvas);

    }//end draw


    public void drawText(Canvas canvas) {

        Paint paint = new Paint();
    }


    public FullBoard getFullBoard() {
        return fullBoard;
    }

    public HalfBoard getHalfBoard() {
        return halfBoard;
    }

    public EmptyBoard getemptyBoard() {
        return emptyBoard;
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {

        fullBoard = new FullBoard(BitmapFactory.decodeResource(getResources(), R.drawable.o9csk),
                359, 359, 2 * WIDTH, 2 * HEIGHT);

        halfBoard = new HalfBoard(BitmapFactory.decodeResource(getResources(), R.drawable.o9cska),
                359, 359, 2 * WIDTH, 2 * HEIGHT);

        emptyBoard = new EmptyBoard(BitmapFactory.decodeResource(getResources(), R.drawable.o9cskb),
                359, 359, WIDTH / 2 + 200, HEIGHT / 2 + 200);

        emptyBoard.setX((WIDTH - 359) / 2);
        emptyBoard.setY(100);

        halfBoard.setX((WIDTH - 359) / 2);
        halfBoard.setY(100 + 380);

        fullBoard.setX((WIDTH - 359) / 2);
        fullBoard.setY(100 + 380 + 380);

        this.draw(canvas);


    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }
}