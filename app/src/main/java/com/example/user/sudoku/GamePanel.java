package com.example.user.sudoku;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
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

        gameLogic = new GameLogic(this);


        setWIDTH(WIDTH);
        setHEIGHT(HEIGHT);

        GamePanel.WIDTH = WIDTH;
        GamePanel.HEIGHT = HEIGHT;


        getHolder().addCallback(this);

    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static void setWIDTH(int WIDTH) {
        GamePanel.WIDTH = WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static void setHEIGHT(int HEIGHT) {
        GamePanel.HEIGHT = HEIGHT;
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        surfaceHolder = this.getHolder();
        fullBoard = new FullBoard(BitmapFactory.decodeResource(getResources(), R.drawable.o9csk),
                359, 359, 2 * WIDTH, 2 * HEIGHT);


        halfBoard = new HalfBoard(BitmapFactory.decodeResource(getResources(), R.drawable.o9cska),
                359, 359, 2 * WIDTH, 2 * HEIGHT);

        emptyBoard = new EmptyBoard(BitmapFactory.decodeResource(getResources(), R.drawable.o9cskb),
                359, 359, WIDTH / 2 + 200, HEIGHT / 2 + 200);

        this.update();
        this.draw(canvas);

        SystemClock.sleep(2000);

        emptyBoard.setX(2 * WIDTH);
        emptyBoard.setY(2 * HEIGHT);

        halfBoard.setX(WIDTH / 2 + 200);
        halfBoard.setY(HEIGHT / 2 + 200);

        this.update();
        this.draw(canvas);

        SystemClock.sleep(2000);

        halfBoard.setX(2 * WIDTH);
        halfBoard.setY(2 * HEIGHT);

        fullBoard.setX(WIDTH / 2 + 200);
        fullBoard.setY(HEIGHT / 2 + 200);

        this.update();
        this.draw(canvas);

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        this.update();
        this.draw(canvas);

        return super.onTouchEvent(event);
    }

    public void update() {
        fullBoard.update();
        halfBoard.update();
        emptyBoard.update();
        gameLogic.check_Logic();


    }


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

}