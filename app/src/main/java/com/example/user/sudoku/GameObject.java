
package com.example.user.sudoku;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class GameObject {
    Bitmap image;
    private int width;
    private int height;
    private int x;
    private int y;

    public GameObject(Bitmap res, int width, int height) {
        this.height = height;
        this.width = width;

        image = Bitmap.createBitmap(res, 0, 0,
                width, height);
    }

    public void update() {
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, x, y, null);
    }


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Rect getRectangle() {
        return new Rect(x, y, x + width, y + height);
    }
}

