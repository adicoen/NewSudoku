package com.example.user.sudoku;

import android.graphics.Bitmap;

public class FullBoard extends GameObject {
    private int x;
    private int y;

    public FullBoard(Bitmap image, int width, int height, int x, int y) {
        super(image, width, height);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }
}
