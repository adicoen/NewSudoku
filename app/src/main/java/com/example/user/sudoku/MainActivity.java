package com.example.user.sudoku;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.content.IntentFilter;




//finished
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int score= 0;
    Button[] buttons;
    Button button;
    Button[] given;
    int[] nums;
    TableLayout board, bar;
    String value = "1";
    TextView text;
    int count = 0;

    MyBroadcastReciever myBroadcastReciever = new MyBroadcastReciever();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_activity);
        board = findViewById(R.id.tableLayout);
        bar = findViewById(R.id.tableLayout2);
        buttons = new Button[91];
        for (int i = 3; i < 94; i++) {
            String str = "button" + i;
            button = findViewById(getResources().getIdentifier(str, "id", getPackageName()));
            buttons[i - 3] = button;
            buttons[i - 3].setOnClickListener(this);
        }
        text = findViewById(R.id.textView2);
        text.setText(value);
        given = new Button[]{buttons[81], buttons[83], buttons[85], buttons[88], buttons[89], buttons[73], buttons[78], buttons[63], buttons[65], buttons[68], buttons[54], buttons[55], buttons[50], buttons[51], buttons[53], buttons[37], buttons[41], buttons[42], buttons[43], buttons[31], buttons[34], buttons[35], buttons[21], buttons[25], buttons[9], buttons[10], buttons[17]};
        nums = new int[]{1, 2, 8, 7, 9, 9, 1, 7, 4, 9, 9, 1, 8, 9, 3, 8, 7, 2, 5, 2, 4, 5, 4, 9, 3, 4, 6};
        for (int i = 0; i < given.length; i++) {
            given[i].setText(Integer.toString(nums[i]));
            given[i].setTextColor(Color.parseColor("#5e6c82"));
            given[i].setEnabled(false);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button3:
                value = "1";
                text.setText(value);
                break;
            case R.id.button4:
                value = "2";
                text.setText(value);
                break;
            case R.id.button5:
                value = "3";
                text.setText(value);
                break;
            case R.id.button6:
                value = "4";
                text.setText(value);
                break;
            case R.id.button7:
                value = "5";
                text.setText(value);
                break;
            case R.id.button8:
                value = "6";
                text.setText(value);
                break;
            case R.id.button9:
                value = "7";
                text.setText(value);
                break;
            case R.id.button10:
                value = "8";
                text.setText(value);
                break;
            case R.id.button11:
                value = "9";
                text.setText(value);
                break;
            case R.id.button93:
                value = " ";
                text.setText("erase");
                break;
            default:
                for (int i = 9; i < 90; i++)
                    if (v == buttons[i])
                        buttons[i].setText(value);
        }
        for (int i = 9; i < 90; i++) {
            if (buttons[i].getText() == "")
                break;
            count = Integer.parseInt(buttons[i].getText().toString());
            if (count == 405 && i >= 89)
                startActivity(new Intent(MainActivity.this, Highscore.class));
        }
        score++;
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_LOW);
        registerReceiver(myBroadcastReciever, filter);

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myBroadcastReciever);

    }


}