package com.example.user.sudoku;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class Highscore extends AppCompatActivity {

    TextView top;
    int lastScore, best;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);
        top = findViewById(R.id.score);
        if (lastScore > best) {
            best = lastScore;
        }
        SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        lastScore = preferences.getInt("lastScore", 0);
        best = preferences.getInt("best1", 0);

        top.setText("Last Score:  " + lastScore + "\n" + "Best Score: " + best);

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), GameMenu.class));
        finish();
    }
}
