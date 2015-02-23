package com.androidstudioacademy.stopwatch;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends ActionBarActivity {

    Timer timer;
    int stopwatch_counter;
    TextView lbl_stopwatch;
    Button btn_start;
    Button btn_pause;
    Button btn_reset;
    View.OnClickListener listener_start;
    View.OnClickListener listener_pause;
    View.OnClickListener listener_reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stopwatch_counter = 0;
        lbl_stopwatch = (TextView) findViewById(R.id.lbl_timer);
        btn_start = (Button) findViewById(R.id.btn_start);
        btn_pause = (Button) findViewById(R.id.btn_pause);
        btn_reset = (Button) findViewById(R.id.btn_reset);
        listener_start = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //START
                startTimer();
            }
        };
        btn_start.setOnClickListener(listener_start);
        listener_pause = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //PAUSE
                pauseTimer();
            }
        };
        btn_pause.setOnClickListener(listener_pause);
        listener_reset = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //RESET
                resetTimer();
            }
        };
        btn_reset.setOnClickListener(listener_reset);
    }

    private void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                timerCalled();
            }
        }, 1000, 1000);
    }

    private void pauseTimer() {
        timer.cancel();
    }

    private void resetTimer() {
        timer.cancel();
        stopwatch_counter = 0;
        lbl_stopwatch.setText(stopwatch_counter + "");
    }

    private void timerCalled() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                stopwatch_counter++;
                lbl_stopwatch.setText(stopwatch_counter + "");
            }
        });
    }

}
