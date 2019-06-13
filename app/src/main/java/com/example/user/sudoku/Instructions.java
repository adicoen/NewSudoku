package com.example.user.sudoku;

import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Point;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;

public class Instructions extends AppCompatActivity {

    private static int WIDTH;
    private static int HEIGHT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Display display = getWindowManager().getDefaultDisplay();
        // display size in pixels
        Point size = new Point();
        display.getSize(size);
        WIDTH = size.x;
        HEIGHT = size.y;
        setContentView(new GamePanel(this, WIDTH, HEIGHT));
        SystemClock.sleep(4000);
        Intent myIntent = new Intent(Instructions.this, GameMenu.class);
        startActivity(myIntent);
    }
}
